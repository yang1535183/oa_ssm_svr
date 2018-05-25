package com.yxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yxf.mapper.UserMapper;
import com.yxf.pojo.User;
import com.yxf.pojo.UserExample;
import com.yxf.pojo.UserExample.Criteria;
import com.yxf.service.IUserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author donhuexu
 * @date 2018年5月8日 下午3:12:30
 * 
 */
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String userName, String password) throws Exception {
		UserExample userExample = new UserExample();

		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andUsernameEqualTo(userName).andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(userExample);
		if (userList != null && userList.size() > 0) {
			User user = userList.get(0);
			user.setPassword(null);
			return user;
		}
		return null;
	}

}
