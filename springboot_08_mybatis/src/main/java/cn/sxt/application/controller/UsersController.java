package cn.sxt.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.sxt.application.pojo.Users;
import cn.sxt.application.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	/***
	 * 处理加载用户列表的请求
	 * @param model
	 * @return
	 */
	@GetMapping("/users")
	public String loadUsersList(Model model) {
		
		List<Users> list = usersService.loadUsersListService();
		model.addAttribute("userList", list);
	
		return "list";
	}
	
	/***
	 * 处理用户删除请求
	 */
	@GetMapping("/users/{uid}")
	public String deleteUsers(@PathVariable Integer uid) {
		
		usersService.deleteUsersService(uid);
		
		return "redirect:../users";
	}
}
