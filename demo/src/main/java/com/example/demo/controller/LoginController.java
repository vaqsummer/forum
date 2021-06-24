package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	private String message;

	@ResponseBody
	@PostMapping("/login")
	public String getUser(String userName,String userPassword,Model model) {
		User user = userService.getUserByName(userName);
		if (user==null) {
			message="用户名错误，请注册！";
			return message;
		}else {
			if (user.getUserPassword().equals(userPassword)) {
				return "yes";
			}else {
				message="密码错误，请重新输入！";
				return message;
			}
		}
	}



	@ResponseBody
	@PostMapping("/checkName")
	public int getUser(String userName) {
		User user = userService.getUserByName(userName);
		if (user==null) {
			return 0;
		}else {
			return 1;
		}
	}




	@RequestMapping("")
	public String come() {
		return "login";
	}

}
