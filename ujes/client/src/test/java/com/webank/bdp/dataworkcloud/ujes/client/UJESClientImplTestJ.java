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

package com.webank.bdp.dataworkcloud.ujes.client;

import com.webank.wedatasphere.linkis.common.utils.Utils;
import com.webank.wedatasphere.linkis.httpclient.authentication.AuthenticationStrategy;
import com.webank.wedatasphere.linkis.httpclient.dws.authentication.TokenAuthenticationStrategy;
import com.webank.wedatasphere.linkis.httpclient.dws.config.DWSClientConfig;
import com.webank.wedatasphere.linkis.httpclient.dws.config.DWSClientConfigBuilder;
import com.webank.wedatasphere.linkis.ujes.client.UJESClient;
import com.webank.wedatasphere.linkis.ujes.client.UJESClientImpl;
import com.webank.wedatasphere.linkis.ujes.client.request.JobExecuteAction;
import com.webank.wedatasphere.linkis.ujes.client.request.ResultSetAction;
import com.webank.wedatasphere.linkis.ujes.client.response.JobExecuteResult;
import com.webank.wedatasphere.linkis.ujes.client.response.JobInfoResult;
import com.webank.wedatasphere.linkis.ujes.client.response.JobProgressResult;
import com.webank.wedatasphere.linkis.ujes.client.response.JobStatusResult;
import com.webank.wedatasphere.linkis.ujes.client.response.ResultSetResult;

import org.apache.commons.io.IOUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
 

public class UJESClientImplTestJ{
	//http://datanode-03:9001/api/rest_j/v1/gateway/heartbeat
	
    public static void main(String[] args){
        DWSClientConfig clientConfig = ((DWSClientConfigBuilder) (DWSClientConfigBuilder.newBuilder().addUJESServerUrl("http://datanode-03:9001")
                .connectionTimeout(30000).discoveryEnabled(false)
                .discoveryFrequency(1, TimeUnit.MINUTES)
                .loadbalancerEnabled(true).maxConnectionSize(5)
                .retryEnabled(false).readTimeout(30000)
                .setAuthenticationStrategy(new TokenAuthenticationStrategy()).setAuthTokenKey("1111111")
                .setAuthTokenValue("testtoken"))).setDWSVersion("v1").build();
       
        UJESClient client = new UJESClientImpl(clientConfig);
        
        JobExecuteResult jobExecuteResult = client.execute(JobExecuteAction.builder().setCreator("UJESClient-Test")
                .addExecuteCode("select * from dm_boss_dap_woody.base_person limit 100;")
                .setEngineType(JobExecuteAction.EngineType$.MODULE$.HIVE()).setUser("athena").setUmUser("athena").build());
        System.out.println("execId: " + jobExecuteResult.getExecID() + ", taskId: " + jobExecuteResult.taskID());
        JobStatusResult status = client.status(jobExecuteResult);
        while(!status.isCompleted()) {
            JobProgressResult progress = client.progress(jobExecuteResult);
            Utils.sleepQuietly(500);
            status = client.status(jobExecuteResult);
        }
         
        JobInfoResult jobInfo = client.getJobInfo(jobExecuteResult);
        
        String resultSet = jobInfo.getResultSetList(client)[0];
        System.out.println("数据hdfs结果集路径：resultSet: " + resultSet);
        ResultSetResult resultSetResult  = client.resultSet(ResultSetAction.builder().setPath(resultSet).setPageSize(1).setUser("athena").setUmUser("athena").build());        
        List<String> metaData = (List<String>) resultSetResult.getMetadata();
        System.out.println("数据表头：metaData: " + metaData.toString());
        Object fileContents = resultSetResult.getFileContent();
        System.out.println("数据内容：fileContents: " + fileContents);
        IOUtils.closeQuietly(client);
    }
    

}