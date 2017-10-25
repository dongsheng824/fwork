package com.hhlike.fwork.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

	@CacheEvict(value = "user", key = "'selectUser_' + #p0")
	public void clearUserCache(Long id) {
		System.out.println("user cache cleared！" + id);
	}

}
