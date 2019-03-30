package cn.sxt.application.service;

import java.util.List;

import cn.sxt.application.pojo.Users;

public interface UsersService {
	
	/***
	 * 加载所有用户信息
	 * @return
	 */
	public List<Users> loadUsersListService();
	
	/***
	 * 删除用户信息
	 */
	public void deleteUsersService(Integer uid);
}
