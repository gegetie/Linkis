package com.webank.wedatasphere.linkis.engine.impala.client.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务信息
 * @author dingqihuang
 * @version Sep 20, 2019
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class ExecSummary {
	private ExecStatus status;
	private ExecProgress progress;
	private int nodeNum;
}
