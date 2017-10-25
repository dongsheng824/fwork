package com.hhlike.fwork.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.hhlike.fwork.vo.ContentItemVo;

public interface TestDao {
	
	@Cacheable(value = "user", key = "'selectUser_' + #p0")
	List<ContentItemVo> selectUser(Long id);
}
