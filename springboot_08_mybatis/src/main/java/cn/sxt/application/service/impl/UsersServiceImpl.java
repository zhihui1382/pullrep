package cn.sxt.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sxt.application.mapper.UsersMapper;
import cn.sxt.application.pojo.Users;
import cn.sxt.application.service.UsersService;

@Service
//@Transactional  // 该注解进行事务控制，可以用在类或者方法
public class UsersServiceImpl implements UsersService {

	//注入mapper代理对象
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public List<Users> loadUsersListService() {
		// TODO Auto-generated method stub
		return usersMapper.loadUsersList();
	}
	@Override
	public void deleteUsersService(Integer uid) {
		// TODO Auto-generated method stub
		usersMapper.deletUsers(uid);
		int x=10/0;
		
	}

}
