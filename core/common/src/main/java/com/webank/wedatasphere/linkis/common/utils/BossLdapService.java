package com.webank.wedatasphere.linkis.common.utils;


import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class BossLdapService extends JavaLog {
	
	public BossLdapService(String url, String basedn, String admin, String pwd) {
		super();
		this.url = url;
		this.basedn = basedn;
		this.admin = admin;
		this.pwd = pwd;
	}

	public BossLdapService(String url) {
		super();
		this.url = url;
	}
	
	public BossLdapService(String url,String basedn) {
		super();
		this.url = url;
		this.basedn = basedn;
	}
	
	public BossLdapService() {
		super();
	}
	
	//private String url = "ldap://ldap-inc.weizhipin.com/";
    private String url = "ldap://192.168.1.15/";
    private String basedn = "ou=people,dc=kanzhun,dc=org";
    private String admin = "uid=techwolfadmin";
    private String pwd = "Ph@xW18dYr";
    private final String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    private final Control[] connCtls = null;

    private LdapContext init() {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, FACTORY);
        env.put(Context.PROVIDER_URL, url + basedn);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, admin + "," + basedn);   // 管理员
        env.put(Context.SECURITY_CREDENTIALS, pwd);  // 管理员密码
        LdapContext ctx = null;
        try {
            ctx = new InitialLdapContext(env, connCtls);
        } catch (AuthenticationException e) {
            warn("LdapService.init error ",e);
        } catch (Exception e) {
        		warn("LdapService.init error " ,e);
        }
        return ctx;
    }

    private LdapUser getUserDN(LdapContext ctx, String uid) throws NamingException {
        String userDN = "";
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> en = ctx.search("", "uid=" + uid, constraints);
        if (en == null || !en.hasMoreElements()) {
        		warn("LdapUtil.getUserDN can't find user " + uid);
            return null;
        }
        LdapUser user = new LdapUser();
        while (en != null && en.hasMoreElements()) {
            Object obj = en.nextElement();
            if (obj instanceof SearchResult) {
                SearchResult si = (SearchResult) obj;
                user.setUserName(String.valueOf(si.getAttributes().get("displayName").get(0)));
                user.setUserEmail(String.valueOf(si.getAttributes().get("mail").get(0)));
                userDN += si.getName();
                userDN += "," + basedn;
            }
        }
        user.setUserDN(userDN);
        return user;
    }

    public LdapUser authenricate(String uid, String password) {
        LdapContext ctx = init();
        if (null == ctx) {
            return new LdapUser();
        }
        LdapUser user = null;
        try {
            user = getUserDN(ctx, uid);
            if (null == user || null == user.getUserDN()) {
                return user;
            }
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, user.getUserDN());
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
            ctx.reconnect(connCtls);
            user.setValid(true);
        } catch (AuthenticationException e) {
        		warn("LdapService.authenricate error, uid = " + uid + ", pwd = " + password + ", " ,e);
        } catch (NamingException e) {
        		warn("LdapService.authenricate error, uid = " + uid + ", pwd = " + password + ", " ,e);
        } finally {
            if (null != ctx) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                }
            }
        }
        return user;
    }

    public static void main(String[] args) {
        BossLdapService ldap = new BossLdapService();
        if (ldap.authenricate("zhuhui@kanzhun.com", "").isValid()) {
            System.out.println("该用户认证成功");
        }
    }

}