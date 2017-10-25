package com.hhlike.fwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhlike.fwork.core.ResultData;
import com.hhlike.fwork.service.UserService;

@Controller
@RequestMapping("/web/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	 
	@RequestMapping(value = "/queryUser.do", method = RequestMethod.GET)
	public @ResponseBody ResultData queryUser(
			@RequestParam(value = "userId", required = false) Long userId
			){
		return userService.queryUser(userId);
	}
	
	@RequestMapping(value = "/clearUserCache.do", method = RequestMethod.GET)
	public @ResponseBody ResultData clearUserCache(
			@RequestHeader("token") String token,
			@RequestParam(value = "userId", required = false) Long userId
			){
		return userService.clearUserCache(userId);
	}
	
}
