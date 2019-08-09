
package com.webank.wedatasphere.linkis.gateway.ujes.route

import com.webank.wedatasphere.linkis.gateway.security.ProxyUserUtils

object Test {
    def main(args:Array[String]) {  
        println(ProxyUserUtils.getProxyUser("zhuhui@kanzhun.com"))  
    } 
}