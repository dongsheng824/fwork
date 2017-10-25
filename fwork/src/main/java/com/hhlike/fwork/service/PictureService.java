package com.hhlike.fwork.service;

import com.hhlike.fwork.core.ResultData;

public interface PictureService {

	/**
	 * 上传字符格式的图片
	 * 
	 * @param img
	 * @return
	 * @throws Exception 
	 */
	ResultData uploadPicture(String img) throws Exception;

}