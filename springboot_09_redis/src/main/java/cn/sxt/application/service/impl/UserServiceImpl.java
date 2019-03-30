package cn.sxt.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.sxt.application.pojo.User;
import cn.sxt.application.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	/***
	 * 缓存方法的返回值
	 */
	@Cacheable(cacheNames= {"users"},key="#root.method.name")
	@Override
	public List<User> loadUserListService() {
		System.out.println("--------loadUserListService--------");
		List<User> list=new ArrayList<>();
		
		User user=new User();
		user.setId(100);
		user.setUname("张三");
		user.setAddress("beijing");
		
		User user2=new User();
		user2.setId(100);
		user2.setUname("李四");
		user2.setAddress("beijing");
		
		User user3=new User();
		user3.setId(100);
		user3.setUname("zhangsan");
		user3.setAddress("beijing");
		
		list.add(user);
		list.add(user2);
		list.add(user3);
		
		
		return list;
	}

}
