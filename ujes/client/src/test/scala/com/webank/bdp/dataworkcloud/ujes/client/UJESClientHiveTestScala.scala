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

/*
 * created by cooperyang on 2019/07/24.
 */

package com.webank.bdp.dataworkcloud.ujes.client

import java.util.concurrent.TimeUnit
import com.webank.wedatasphere.linkis.common.utils.Utils
import com.webank.wedatasphere.linkis.httpclient.dws.authentication.TokenAuthenticationStrategy
import com.webank.wedatasphere.linkis.httpclient.dws.config.DWSClientConfigBuilder
import com.webank.wedatasphere.linkis.ujes.client.UJESClient
import com.webank.wedatasphere.linkis.ujes.client.request.JobExecuteAction.EngineType
import com.webank.wedatasphere.linkis.ujes.client.request.{JobExecuteAction, ResultSetAction}
import org.apache.commons.io.IOUtils
import com.webank.wedatasphere.linkis.httpclient.dws.annotation.DWSHttpMessageResult

/**
 * 
  * created by cooperyang on 2019/5/23.com.webank.wedatasphere.linkis.ujes.client.UJESClientImplTest
  */
object UJESClientHiveTestScala extends App {
  
  val clientConfig = DWSClientConfigBuilder.newBuilder().addUJESServerUrl("http://datanode-03:9001")
    .connectionTimeout(30000).discoveryEnabled(true)
    .discoveryFrequency(1, TimeUnit.MINUTES)
    .loadbalancerEnabled(true).maxConnectionSize(5)
    .retryEnabled(false).readTimeout(300000)
    .setAuthenticationStrategy(new TokenAuthenticationStrategy()).setAuthTokenKey("zhuhui@kanzhun.com")
    .setAuthTokenValue("Liangqilang1989").setDWSVersion("v1").build()
  val client = UJESClient(clientConfig)

  val jobExecuteResult = client.execute(JobExecuteAction.builder().setCreator("UJESClient-Test")
    .addExecuteCode("select count(1) from dm_boss_dap_woody.base_person limit 10;")
    .setEngineType(EngineType.HIVE).setUser("athena").setUmUser("athena").build())
  println("execId: " + jobExecuteResult.getExecID + ", taskId: " + jobExecuteResult.taskID)
 
  var status = client.status(jobExecuteResult)
  
  while(!status.isCompleted) {
    val progress = client.progress(jobExecuteResult)
    val progressInfo = if(progress.getProgressInfo != null) progress.getProgressInfo else List.empty
    println("progress: " + progress.getProgress + ", progressInfo: " + progressInfo)
    Utils.sleepQuietly(500)
    status = client.status(jobExecuteResult)
  }
  val jobInfo = client.getJobInfo(jobExecuteResult)
  
  val resultSet = jobInfo.getResultSetList(client).head
  
  val fileContents = client.resultSet(ResultSetAction.builder().setPath(resultSet).setPage(1).setPageSize(50).setUser(jobExecuteResult.getUser).setUmUser("athena").build()).getFileContent
  println("fileContents: " + fileContents)
  IOUtils.closeQuietly(client)
}
