package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	private String message;

	@PostMapping("/login")
	public String getUser(String userName, String userPassword, Model model) {
		User user = userService.getUserByName(userName);
		if (user==null) {
			message="用户名错误，请注册！";
			model.addAttribute("message",message);
			return "login";
		}else {
			if (user.getUserPassword().equals(userPassword)) {
				model.addAttribute("userName",userName);
				return "menu";
			}else {
				message="密码错误，请重新输入！";
				model.addAttribute("message",message);
				return "login";
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
