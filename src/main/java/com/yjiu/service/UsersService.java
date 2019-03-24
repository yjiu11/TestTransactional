package com.yjiu.service;

import com.yjiu.pojo.Users;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjiu123
 * @since 2019-03-24
 */
public interface UsersService extends IService<Users> {
	public void addRequired(Users user);
	public void addRequiredException(Users user);
	public void addRequiredNew(Users user);
	public void addRequiredNewException(Users user);
}
