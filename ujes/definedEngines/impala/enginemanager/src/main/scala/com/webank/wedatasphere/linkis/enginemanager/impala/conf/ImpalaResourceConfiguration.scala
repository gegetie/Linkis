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

package com.webank.wedatasphere.linkis.enginemanager.impala.conf

import com.webank.wedatasphere.linkis.common.conf.{ByteType, CommonVars}

/**
  * created by cooperyang on 2019/1/30
  * Description:
  */
object ImpalaResourceConfiguration {
  val IMPALA_ENGINE_REQUEST_MEMORY = CommonVars[ByteType]("impala.client.memory", new ByteType("4g"))
  val IMPALA_ENGINE_REQUEST_CORES = CommonVars[Int]("wds.linkis.impalaengine.cores.request", 2)
  val IMPALA_ENGINE_REQUEST_INSTANCE = CommonVars[Int]("wds.linkis.impalaengine.instance.request", 1)
}
