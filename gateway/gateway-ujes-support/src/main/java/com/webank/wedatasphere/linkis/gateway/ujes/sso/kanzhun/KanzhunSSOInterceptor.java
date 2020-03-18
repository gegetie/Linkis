package com.webank.wedatasphere.linkis.gateway.ujes.sso.kanzhun;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.webank.wedatasphere.linkis.common.utils.JavaLog;
import com.webank.wedatasphere.linkis.gateway.http.GatewayContext;
import com.webank.wedatasphere.linkis.gateway.security.sso.SSOInterceptor;
import com.webank.wedatasphere.linkis.gateway.springcloud.http.SpringCloudGatewayHttpResponse;
import cn.techwolf.boss.internaluc.model.dubbo.UcUserInfo;
import cn.techwolf.boss.internaluc.service.dubbo.UcPassportDubboService;
import com.webank.wedatasphere.linkis.DataWorkCloudApplication;
import com.webank.wedatasphere.linkis.DataWorkCloudApplication;
import com.webank.wedatasphere.linkis.common.utils.ClassUtils;
import com.webank.wedatasphere.linkis.gateway.config.GatewayConfiguration;
import com.webank.wedatasphere.linkis.gateway.http.GatewayContext;

@Component
class KanzhunSSOInterceptor extends JavaLog implements SSOInterceptor {

	private final static String TICKET_PATTEN = "t_";

	private String systemToken = "datastar";

	private String passportUrl = "http://innerauth.weizhipin.com/iuc/user/login";

 
	@Autowired
	private UcPassportDubboService ucPassportDubboService;
	
	@Override
	public String getUser(GatewayContext gatewayContext) {
		if(null==gatewayContext.getRequest().getCookies().get("t_datastar")) {
			info("-------------未登陆----t_datastar is null-----");
			((SpringCloudGatewayHttpResponse) gatewayContext.getResponse()).addCookie(this.createCookie(TICKET_PATTEN + systemToken, null, -1, "/", null));
			return null;
		}
		String ticket = gatewayContext.getRequest().getCookies().get("t_datastar")[0].getValue();
		info("t_datastar:"+ticket);
 		if (StringUtils.isBlank(ticket)) {
			info("-------------未登陆---ticket is null------");
			return null;
		}
		info("get user by ticket,ticket:"+ticket+ " systemToken:"+this.systemToken);
		UcUserInfo user = ucPassportDubboService.getUserByTicket(ticket, this.systemToken);
		if (null != user) {
			info("get user by ticket,user:"+user.toString());
			return user.getEmail().split("@")[0];
		}
		return null;
	}

	@Override
	public String redirectTo(URI requestUrl) {
		//String[] refererArry = gatewayContext.getRequest().getHeaders().get("Referer");
		//String referer=null;
		//if(null!=refererArry) {
		//	referer = refererArry[0];
		//}else {
		//	referer = gatewayContext.getRequest().getURI().getHost();
		//}
 		String callBack = String.format(this.passportUrl + "?token=%s&callback=%s", this.systemToken,
				this.encodeUrl(this.getUrl(requestUrl.toString())));
		return callBack;
	}
	

	@Override
	public void logout(GatewayContext gatewayContext) {
	}

	private Cookie createCookie(String key, String value, int second, String path, String domain) {
		value = StringUtils.remove(value, '\n');
		value = StringUtils.remove(value, '\r');
		Cookie cookie = new Cookie(key, value);
		if (StringUtils.isNotBlank(path)) {
			cookie.setPath(path);
		}
		cookie.setMaxAge(second);
		if (StringUtils.isNotBlank(domain)) {
			if (!StringUtils.startsWith(domain, ".")) {
				domain = "." + domain;
			}
			cookie.setDomain(domain);
		}
		return cookie;
	}

	/**
	 * 获取url
	 * @param request
	 * @return url
	 */
	private String getUrl(String url) {
		url = StringUtils.substringBefore(url, "&t_uc=");
		url = StringUtils.substringBefore(url, "?t_uc=");
		return url;
	}
	
	

	/**
	 * url encode
	 * @param url
	 * @return encode的url
	 */
	private String encodeUrl(String url) {
		try {
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException var3) {
			return null;
		}

	}

}