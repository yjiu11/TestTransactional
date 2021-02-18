package com.atguigu.mp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yjiu.App;
import com.yjiu.service.TranService;


@RunWith(SpringJUnit4ClassRunner.class) // 让junit与spring环境进行整合
@SpringBootTest(classes = { App.class }) // 自动加载spring相关的配置文件
public class TestTran {
	@Autowired
	private TranService tranSrvice;
	/**1、外围无事务有异常，里面有两个添加方法，可以添加成功*/
	@Test
	public void t1() {
		tranSrvice.notran_exception_required_required();
	}
	/**2、外围无事务无异常，里面有两个添加方法，其中一个事务方法内部异常，导致回滚*/
	@Test
	public void t2() {
		tranSrvice.notran_required_required_exception();
	}
	/**3、外围有事务且有异常，里面有两个添加方法*/
	@Test
	public void t3() throws Exception {
		tranSrvice.exception_required_required();
	}
	
	/**4、外围有事务，里面有三个添加方法，两个是requirednew，其中一个还有异常required_required_exception_try*/
	@Test
	public void t4() {
		tranSrvice.required_requiredNew_requiredNewException();
	}
	@Test
	public void t4_1(){
		tranSrvice.required_requiredNewException();
	}
	@Test
	public void t4_2(){
		tranSrvice.required_tryRequiredNewException();
	}
	/**5、*/
	@Test
	public void t5() {
		tranSrvice.required_required_exception_try();
	}
}
