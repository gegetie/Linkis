/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.net.ConnectException

import com.fasterxml.jackson.core.JsonParseException
import com.webank.wedatasphere.linkis.common.utils.{HDFSUtils, Logging, Utils}
import com.webank.wedatasphere.linkis.resourcemanager.YarnResource
import com.webank.wedatasphere.linkis.resourcemanager.exception.{RMErrorException, RMFatalException, RMWarnException}
import dispatch.{Http, as}
import org.apache.commons.lang.StringUtils
import org.apache.hadoop.fs.Path
import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.util.RMHAUtils
import org.json4s.JsonAST._
import org.json4s.{DefaultFormats, JValue}
import org.json4s.jackson._
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration

import com.fasterxml.jackson.core.JsonParseException
import com.webank.wedatasphere.linkis.common.utils.{HDFSUtils, Logging, Utils}
import com.webank.wedatasphere.linkis.resourcemanager.YarnResource
import com.webank.wedatasphere.linkis.resourcemanager.exception.{RMErrorException, RMFatalException, RMWarnException}
import dispatch.{Http, as}
import org.apache.commons.lang.StringUtils
import org.apache.hadoop.fs.Path
import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.util.RMHAUtils
import org.json4s.JsonAST._
import org.json4s.{DefaultFormats, JValue}

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration
/**
  * Created by shanhuang on 2018/9/24.
  */
object YarnUtilTest extends Logging{
    
  private implicit val executor = ExecutionContext.global
  private val yarnConf = new YarnConfiguration()
  private var rm_web_address: String = "http://bx-namenode-02:8088"
  private var hadoop_version:String = "2.6.0"
  implicit val format = DefaultFormats

  def getChildQueuestest(resp:JValue):JValue = {
      val childQueues = if (hadoop_version.startsWith("2.7")) {
        resp \ "scheduler" \ "schedulerInfo" \ "rootQueue"  \ "childQueues"
      }else{
        resp \ "scheduler" \ "schedulerInfo" \ "rootQueue"  \ "childQueues" \ "queue"
      }
      childQueues
    }
  

  def getQueueInfo(queueName: String): (YarnResource, YarnResource) = {
    val url = dispatch.url(rm_web_address) / "ws" / "v1" / "cluster" / "scheduler"
    url.setContentType("application/json", "UTF-8")

    def getYarnResource(jValue: Option[JValue]): Option[YarnResource] = {
      jValue.map(r => new YarnResource((r \ "memory").asInstanceOf[JInt].values.toLong * 1024l * 1024l, (r \ "vCores").asInstanceOf[JInt].values.toInt, 0, queueName))
    }

    val realQueueName = "root." + queueName
    def getQueue(queues: JValue): Option[JValue] = queues match {
      case JArray(queue) =>
        queue.foreach { q =>
          val yarnQueueName = (q \ "queueName").asInstanceOf[JString].values
          if(yarnQueueName == realQueueName) return Some(q)
          else if(realQueueName.startsWith(yarnQueueName + ".")) return getQueue(q \ "childQueues")
        }
        None
      case JObject(queue) =>
        if(queue.find(_._1 == "queueName").exists(_._2.asInstanceOf[JString].values == realQueueName)) Some(queues)
        else {
          val childQueues = queue.find(_._1 == "childQueues")
          if(childQueues.isEmpty) None
          else getQueue(childQueues.map(_._2).get)
        }
      case JNull | JNothing => None
    }
    def getChildQueues(resp:JValue):JValue = {
      val childQueues = if (hadoop_version.startsWith("2.7")) {
        resp \ "scheduler" \ "schedulerInfo" \ "rootQueue"  \ "childQueues"
      }else{
        resp \ "scheduler" \ "schedulerInfo" \ "rootQueue"  \ "childQueues" \ "queue"
      }
      childQueues
    }

    val future = Http(url > as.json4s.Json).map {resp =>
      val childQueues = getChildQueues(resp)
      val queue = getQueue(childQueues)
      if(queue.isEmpty) {
        debug(s"cannot find any information about queue $queueName, response: " + resp)
        throw new RMWarnException(111006, s"queue $queueName is not exists in YARN.")
      }
      (getYarnResource(queue.map( _ \ "maxResources")).get,
        getYarnResource(queue.map( _ \ "usedResources")).get)
    }
    
    Utils.tryCatch(Await.result(future, Duration.Inf))( t => {
      if((t.getCause.isInstanceOf[JsonParseException] && t.getCause.getMessage.contains("This is standby RM"))
        || t.getCause.isInstanceOf[ConnectException]) {
        //reloadRMWebAddress()
        getQueueInfo(queueName)
      } else throw new RMErrorException(111006, "Get the Yarn queue information exception.(获取Yarn队列信息异常)", t)
    })
  }
   
 

   def main(args:Array[String]) {  
        
        YarnUtilTest.getQueueInfo("kanzhun.dac.three.default")  
    }

}
