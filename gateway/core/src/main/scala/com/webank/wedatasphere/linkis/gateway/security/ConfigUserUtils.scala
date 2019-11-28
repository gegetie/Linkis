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

package com.webank.wedatasphere.linkis.gateway.security

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.webank.wedatasphere.linkis.common.utils.{Logging, Utils}
import com.webank.wedatasphere.linkis.gateway.config.GatewayConfiguration._
import org.apache.commons.lang.StringUtils

object ConfigUserUtils extends Logging {

  private val adminProps = new Properties
  
  Utils.defaultScheduler.scheduleAtFixedRate(new Runnable {
      override def run(): Unit = {
        val newProps = new Properties
        newProps.load(this.getClass.getResourceAsStream(ADMIN_USER_CONFIG.getValue))
        adminProps.clear()
        adminProps.putAll(newProps)
      }
    }, 0, ADMIN_USER_SCAN_INTERVAL.getValue, TimeUnit.MILLISECONDS)
  
   def getAdminUser(adminUser: String): String =  {
    return adminProps.getProperty(adminUser)
  }  
}
