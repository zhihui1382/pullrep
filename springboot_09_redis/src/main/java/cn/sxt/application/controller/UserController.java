package cn.sxt.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sxt.application.pojo.User;
import cn.sxt.application.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/***
	 * 处理加载用户列表的请求
	 * @return
	 */
	@GetMapping("/users")
	public List<User> loadUserList(){
		return userService.loadUserListService();
	}
	
}
