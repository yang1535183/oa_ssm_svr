package com.yxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxf.common.pojo.JsonResult;
import com.yxf.pojo.User;
import com.yxf.service.IUserService;

/**
 * @ClassName: UserController
 * @Description: 用户的Controller
 * @author donhuexu
 * @date 2018年5月8日 下午3:17:04
 * 
 */
@Controller
@RequestMapping("/user") // 窄化请求映射
public class UserController {

	// 注入Service层
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult login(User user) throws Exception {
		User loginInfo = userService.login(user.getUsername(), user.getPassword());
		if (loginInfo != null)
			return JsonResult.build(200, "登陆成功", loginInfo);
		return JsonResult.build(400, "登陆失败");
	}

}
