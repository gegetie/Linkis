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

package com.webank.wedatasphere.linkis.common.utils

import java.util.Hashtable
import javax.naming.NamingException
import javax.naming.Context
import javax.naming.ldap.InitialLdapContext

import com.webank.wedatasphere.linkis.common.conf.CommonVars
/**
 * Created by enjoyyin on 8/30/17.
 */
object BossLDAPUtils extends Logging {

  val url = CommonVars("wds.linkis.ldap.proxy.url", "").getValue
  val baseDN = CommonVars("wds.linkis.ldap.proxy.baseDN", "").getValue
  def login(userID: String, password: String): Unit = {
    info(s"wds.linkis.ldap.proxy.url: $url")
    var bossLdapService = new BossLdapService(url, baseDN)
    if (!bossLdapService.authenricate(userID, password).isValid()) {
      throw new NamingException(s"user $userID login fail.");
    }
    info(s"user $userID login success.")
  }
}

