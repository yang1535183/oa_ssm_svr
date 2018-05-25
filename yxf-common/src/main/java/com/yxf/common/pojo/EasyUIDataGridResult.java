package com.yxf.common.pojo;

import java.util.List;

/** 
* @ClassName: EasyUIDataGridResult 
* @Description: EasyUI DataGrid的返回值类型 
* @author  donhuexu
* @date 2018年5月8日 下午3:04:03 
*  
*/
public class EasyUIDataGridResult {

	private long total;
	private List<?> rows;
	
	public EasyUIDataGridResult(long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
