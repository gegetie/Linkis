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

package com.webank.wedatasphere.linkis.engine.hive.common

import java.io.File
import java.nio.file.Paths

import com.webank.wedatasphere.linkis.engine.hive.exception.HadoopConfSetFailedException
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hive.conf
import org.apache.hadoop.hive.conf.HiveConf
import org.apache.hadoop.hive.ql.Driver
import com.webank.wedatasphere.linkis.common.conf.{Configuration => CommonConfiguration}

/**
  * created by cooperyang on 2018/11/22
  * Description:
  */
object HiveUtils {

  def jarOfClass(cls: Class[_]):Option[String] = {
    val uri = cls.getResource("/" + cls.getName.replace('.', '/') + ".class")
    if (uri != null) {
      val uriStr = uri.toString
      if (uriStr.startsWith("jar:file:")) {
        Some(uriStr.substring("jar:file:".length, uriStr.indexOf("!")))
      } else {
        None
      }
    } else {
      None
    }
  }

  def getHiveConf:HiveConf = {
    val confDir:File = new File(CommonConfiguration.hiveConfDir)
    if (!confDir.exists() || confDir.isFile){
      throw HiveConfSetFailedException(41001, "hive conf set failed, reason: conf dir does not exist")
    } 
    val hiveConf:Configuration = new Configuration()
    hiveConf.addResource(new Path(Paths.get(CommonConfiguration.hiveConfDir, "core-site.xml").toAbsolutePath.toFile.getAbsolutePath))
    hiveConf.addResource(new Path(Paths.get(CommonConfiguration.hiveConfDir, "hdfs-site.xml").toAbsolutePath.toFile.getAbsolutePath))
    hiveConf.addResource(new Path(Paths.get(CommonConfiguration.hiveConfDir, "yarn-site.xml").toAbsolutePath.toFile.getAbsolutePath))
    hiveConf.addResource(new Path(Paths.get(CommonConfiguration.hiveConfDir, "hive-site.xml").toAbsolutePath.toFile.getAbsolutePath))
    new conf.HiveConf(hiveConf, classOf[Driver])
  }


  def msDurationToString(ms: Long): String = {
    val second = 1000
    val minute = 60 * second
    val hour = 60 * minute
    ms match {
      case t if t < second =>
        "%d ms".format(t)
      case t if t < minute =>
        "%.1f s".format(t.toFloat / second)
      case t if t < hour =>
        "%.1f m".format(t.toFloat / minute)
      case t =>
        "%.2f h".format(t.toFloat / hour)
    }
  }

  def main(args: Array[String]): Unit = {
    jarOfClass(classOf[Driver]).foreach(println)
  }
}
