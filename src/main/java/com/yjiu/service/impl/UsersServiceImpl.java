package com.yjiu.service.impl;

import com.yjiu.pojo.Users;
import com.yjiu.mapper.UsersMapper;
import com.yjiu.service.UsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjiu123
 * @since 2019-03-24
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

	@Override
	public void addRequired(Users user) {
		this.insert(user);
	}

	@Override
	public void addRequiredException(Users user) {
		int i =10/0;
		this.insert(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addRequiredNew(Users user) {
		this.insert(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addRequiredNewException(Users user) {
		int i =10/0;
		this.insert(user);
	}

}
