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
	/**外围无事务，张三、李四无事务，但李四添加时有RuntimeException*/
	@Override
	public void notran_required_required_exception() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);//添加成功
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequiredException(user2);//添加失败
	}
	/**外围有事务，张三、李四都无事务，添加时，都没有报错，外围报错Exception，不回滚*/
	@Override
	@Transactional
	public void exception_required_required() throws Exception {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);//添加成功
		
		Users user2 = new Users();
		user2.setName("李四");
		userService.addRequired(user2);//添加成功
		throw new RuntimeException();//会回滚
//		throw new Exception("拖错了");//不会回滚
	}

	/**外围有事务，*/
	@Override
	@Transactional
	public void required_requiredNew_requiredNewException() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);
		
//		Users user2 = new Users();
//		user2.setName("李四");
//		userService.addRequiredNew(user2);
		
		Users user3 = new Users();
		user3.setName("王五");
		userService.addRequiredNewException(user3);
	}
	/**外围有事务，张三无事务，王五requiredNew事务，王五添加有异常，全部回滚   再有try catch呢，全部成功？*/
	@Override
	@Transactional
	public void required_requiredNewException() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);//添加失败
		Users user3 = new Users();
		user3.setName("王五");
		userService.addRequiredNewException(user3);//添加失败
	}
	/**外围有事务，张三无事务，王五requiredNew事务，王五添加有异常，全部回滚   再有try catch呢，全部成功？*/
	@Override
	@Transactional
	public void required_tryRequiredNewException() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);//添加失败
		Users user3 = new Users();
		user3.setName("王五");
		try {
			userService.addRequiredNewException(user3);//添加失败
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**外围有事务，张三无事务，李四捕获了异常，catch不被外围事务感知*/
	@Override
	@Transactional
	public void required_required_exception_try() {
		Users user = new Users();
		user.setName("张三");
		userService.addRequired(user);//添加成功
		
		Users user2 = new Users();
		user2.setName("李四");
		try {
			userService.addRequiredException(user2);//添加失败
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
