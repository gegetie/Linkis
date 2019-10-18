package com.webank.wedatasphere.linkis.engine.impala.executor

import java.io.PrintStream

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
    val impalaConf: Map[String, String] = ImpalaUtils.getImpalaConf
    import scala.collection.JavaConversions._
    options.foreach { case (k, v) => logger.info(s"key is $k, value is $v") }
   
    
    val ugi = UserGroupInformation.getCurrentUser
    var impalaClient = ImpalaClientFactory.builder().withProtocol(Protocol.Thrift).withTransport(Transport.HiveServer2)
      .withCoordinator("datanode-03", 21050)
      .withSSL(true)
      .withTrustStore("/opt/pems4cdh/ca.jks", "impala")
      //.withCredential("root", "hive2")
      .withLoginTicket(true)
      .withParallelLimit(20)
      .withHeartBeatsInSecond(1)
      //.withSubmitQueue("root.test")
      .build();
    
    logger.info("createExecutor ok getExecutionCount："+ impalaClient.getExecutionCount)
    var impalaEngineExecutor =  new ImpalaEngineExecutor(5000, impalaClient, ugi)
    return impalaEngineExecutor
  }

}