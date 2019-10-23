package com.webank.wedatasphere.linkis.engine.impala.executor

import java.io.PrintStream
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import com.webank.wedatasphere.linkis.engine.execute.{ EngineExecutor, EngineExecutorFactory }
import com.webank.wedatasphere.linkis.engine.impala.common.ImpalaUtils
import com.webank.wedatasphere.linkis.engine.impala.exception.ImpalaSessionStartFailedException
import com.webank.wedatasphere.linkis.server.JMap
import org.apache.hadoop.security.UserGroupInformation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.apache.commons.lang.StringUtils
import com.webank.wedatasphere.linkis.common.conf.CommonVars
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;

import javax.net.SocketFactory
import javax.net.ssl.SSLSocketFactory
import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler
import javax.security.auth.callback.NameCallback
import javax.security.auth.callback.PasswordCallback
import javax.security.auth.callback.UnsupportedCallbackException
import com.webank.wedatasphere.linkis.engine.impala.configuration.ImpalaConfiguration
import cn.techwolf.dap.impala.client.exception.SubmitException
import cn.techwolf.dap.impala.client.exception.TransportException
import cn.techwolf.dap.impala.client.factory.ImpalaClientFactory
import cn.techwolf.dap.impala.client.factory.ImpalaClientFactory.Protocol
import cn.techwolf.dap.impala.client.factory.ImpalaClientFactory.Transport
import cn.techwolf.dap.impala.client.protocol.ExecProgress
import cn.techwolf.dap.impala.client.protocol.ExecStatus
import cn.techwolf.dap.impala.client.ImpalaClient



@Component
class ImpalaEngineExecutorFactory extends EngineExecutorFactory {
  private val logger = LoggerFactory.getLogger(getClass)
  
  private val BDP_QUEUE_NAME: String = "wds.linkis.yarnqueue"

  override def createExecutor(options: JMap[String, String]): EngineExecutor = {
    import scala.collection.JavaConversions._
    options.foreach { case (k, v) => logger.info(s"key is $k, value is $v") }
    val ugi = UserGroupInformation.getCurrentUser
    var queueName =  getImpalaQueue(options.getOrDefault(BDP_QUEUE_NAME, ImpalaConfiguration.IMPALA_JOB_DEFALUT_QUEUE.getValue))
    logger.info("QueueName  is "+ queueName)
    var impalaClient = ImpalaClientFactory.builder().withProtocol(Protocol.Thrift).withTransport(Transport.HiveServer2)
      .withCoordinator(getCoordinator(ImpalaConfiguration.IMPALA_COORDINATOR_HOSTS.getValue.split("\\,")), ImpalaConfiguration.IMPALA_COORDINATOR_PORT.getValue)
      .withSSL(ImpalaConfiguration.IMPALA_SSL.getValue)
      .withTrustStore(ImpalaConfiguration.IMPALA_TRUST_FILEPATH.getValue, ImpalaConfiguration.IMPALA_TRUST_PASSWORD.getValue)
      .withLoginTicket(ImpalaConfiguration.IMPALA_LOGINTICKET.getValue.asInstanceOf[Boolean])
      .withParallelLimit(ImpalaConfiguration.IMPALA_PARALLELLIMIT.getValue)
      .withHeartBeatsInSecond(2)
      .withSubmitQueue(queueName)
      .build();
     logger.info("Success to create Impala client Executor," + impalaClient.getExecutionCount)
     new ImpalaEngineExecutor(5000, impalaClient, ugi)
  }

  
  
  /**
   * 随机去取一个地址；
   */
  def getCoordinator(ipList: Array[String]): String = Random.shuffle(ipList.toList).head
  
   /**
   * yarn 队列转为impala队列，例如： root.boss.arc.one.default 转变为  root.boss_dac
   */
  def getImpalaQueue(yarnQueue: String): String = {
    var queueArray = yarnQueue.split("\\.").toBuffer
    if(queueArray.length>=2){
      queueArray = queueArray.take(2)
      return "root"+"."+queueArray(0)+"_"+queueArray(1)
    }
    yarnQueue
  }
}