package com.webank.wedatasphere.linkis.engine.impala.client;

import java.util.List;

import com.webank.wedatasphere.linkis.engine.impala.client.protocol.ExecProgress;
import com.webank.wedatasphere.linkis.engine.impala.client.protocol.ExecStatus;

/**
 * 查询监听器
 * @author dingqihuang
 * @version Sep 20, 2019
 */
public interface ResultListener {
	
 
	void setJobId(String jobId);
	
	
	/**
	 * 查询成功
	 * @param resultSet
	 */
	void success(ImpalaResultSet resultSet);
	
	/**
	 * 查询失败
	 * @param status 任务状态
	 */
	void error(ExecStatus status);
	
	/**
	 * 进度提示，每隔固定时间返回执行进度
	 * @param progress 进度信息，进度数值小于零表示队列已满，任务正在等待执行
	 */
	void progress(ExecProgress progress);
	
	/**
	 * 提示信息
	 * @param message 提示信息
	 */
	void message(List<String> message);
}
