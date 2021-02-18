package com.yjiu.service;

public interface TranService {
	/**
	 * 总结:1和2，外围无事务，哪个方法报错，哪个回滚
	 * 1、外围无事务有异常，里面有两个添加方法，可以添加成功
	 */
	void notran_exception_required_required();
	/**
	 * 2、外围无事务无异常，里面有两个添加方法，其中一个事务方法内部异常，导致回滚
	 */
	void notran_required_required_exception();
	/**
	 * 3、外围有事务且有异常，里面有两个添加方法，不论外围有异常，还是其他方法有异常，全都回滚
	 */
	void exception_required_required() throws Exception;
	/**
	 * 4、外围有事务且有异常，里面有两个添加方法，不论外围有异常，还是其他方法有异常，全都回滚
	 */
	void required_requiredNew_requiredNewException();

	/**
	 * 4.1、
	 */
	void required_requiredNewException();
	void required_tryRequiredNewException();
	/**
	 * 5、外围有事务且有异常，里面有两个添加方法，不论外围有异常，还是其他方法有异常，全都回滚
	 */
	void required_required_exception_try();
}
