package cn.sxt.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sxt.application.pojo.Users;

@Mapper  //扫描mapper接口，产生mapper接口的代理对象
public interface UsersMapper {
	
	/***
	 * 加载用户列表
	 */
	public List<Users> loadUsersList();
	
	/***
	 * 删除用户信息
	 */
	public void deletUsers(Integer uid);
}
