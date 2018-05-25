package com.yxf.service;

import com.yxf.pojo.User;

/**
 * @ClassName: IUserService
 * @Description: 用户相关的service
 * @author donhuexu
 * @date 2018年5月8日 下午3:10:29
 */

public interface IUserService {

	/** 
	* @Title: login 
	* @Description: 用户登录的接口 
	* @param @param userName
	* @param @param password
	* @param @return
	* @param @throws Exception     
	* @return JsonResult 
	* @throws 
	*/
	User login(String userName, String password) throws Exception;

}
