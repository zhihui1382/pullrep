package cn.sxt.application.service;

import java.util.List;

import cn.sxt.application.pojo.User;

public interface UserService {
	
	/***
	 * 加载用户列表
	 * @return
	 */
	public List<User> loadUserListService();
}
