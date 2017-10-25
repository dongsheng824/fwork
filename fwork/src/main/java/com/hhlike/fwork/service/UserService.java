package com.hhlike.fwork.service;

import com.hhlike.fwork.core.ResultData;

public interface UserService {

	ResultData queryUser(Long userId);
	ResultData clearUserCache(Long userId);
}
