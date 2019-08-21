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

package com.webank.wedatasphere.linkis.gateway.ujes;

import com.webank.wedatasphere.linkis.DataWorkCloudApplication;
import com.webank.wedatasphere.linkis.server.conf.DataWorkCloudCustomExcludeFilter;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
 
 
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@ComponentScan(basePackages = "com.webank.wedatasphere.linkis",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {DataWorkCloudCustomExcludeFilter.class}))
@ImportResource({"classpath:spring/applicationContext-boss-iuc-consumer.xml"})
public class GatewayDataWorkCloudApplication extends DataWorkCloudApplication {
 
	 
}
