package com.yjiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjiu.pojo.Users;
import com.yjiu.service.TranService;
import com.yjiu.service.UsersService;
@Service
public class TranServiceImpl implements TranService {
	@Autowired
	private UsersService userService;
	@Override
	public void notran_exception_required_required() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequired(user2);
		//张三、李四添加时，都没有报错，外围报错，但无影响
		throw new RuntimeException();
	}
	@Override
	public void notran_required_required_exception() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequiredException(user2);
	}
	@Override
	@Transactional
	public void exception_required_required() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequired(user2);
		//张三、李四添加时，都没有报错，外围报错，但无影响
		throw new RuntimeException();
	}
	@Override
	@Transactional
	public void required_requiredNew_requiredNewException() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequiredNew(user2);
		
		Users user3 = new Users();
		user3.setName("王五");
		userService.addRequiredNewException(user3);
	}
	@Override
	@Transactional
	public void required_required_exception_try() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
		Users user2 = new Users();
		user2.setName("李四");
		try {
			userService.addRequiredException(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
