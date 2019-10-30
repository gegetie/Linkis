package com.webank.wedatasphere.linkis.engine.impala.client.protocol;

import com.webank.wedatasphere.linkis.engine.impala.client.ResultListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 执行任务句柄
 * @author dingqihuang
 * @version Sep 20, 2019
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class ExecHandler {
	private String queryId;
	private Object handler;
	private ResultListener resultListener;
	private int errors;
	
	@Setter
	private boolean isQueued;
	
	public int markError() {
		return ++errors;
	}
}

