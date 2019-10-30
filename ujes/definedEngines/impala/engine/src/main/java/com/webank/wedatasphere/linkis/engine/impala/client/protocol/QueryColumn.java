package com.webank.wedatasphere.linkis.engine.impala.client.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 查询的列名
 * @author dingqihuang
 * @version Sep 20, 2019
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class QueryColumn {
	private String label;
	private int index;
}
