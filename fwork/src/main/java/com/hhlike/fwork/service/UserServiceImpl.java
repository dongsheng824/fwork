package com.hhlike.fwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhlike.fwork.core.ResultData;
import com.hhlike.fwork.dao.TestDao;
//import com.hhlike.fwork.mapper.UserMapper;
import com.hhlike.fwork.vo.ContentItemVo;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

//	@Autowired
//	private UserMapper userMapper;
	@Autowired
	private TestDao testMapper;
	@Autowired
	private CacheService cacheService;
	
	public ResultData queryUser(Long userId) {
		ResultData result = new ResultData(200, "测试返回！");
//		UserExample userExample = new UserExample();
//		userExample.createCriteria();
//		List<User> users = userMapper.selectByExample(userExample);
//		result.addData("users", users);
		//
		List<ContentItemVo> contentList = testMapper.selectUser(userId);
		result.addData("contentList", contentList);
		//
		return result;
	}
	
	public ResultData clearUserCache(Long userId){
		cacheService.clearUserCache(userId);
		return new ResultData(200, "缓存清除完成！");
	}
	
}
