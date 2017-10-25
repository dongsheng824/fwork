package com.hhlike.fwork.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hhlike.fwork.core.ResultData;
import com.hhlike.fwork.core.exceptions.BusiException;
import com.hhlike.fwork.core.status.ExceptionStatus;
import com.hhlike.fwork.core.status.ResultStatus;
import com.hhlike.fwork.core.util.FileUtil;
import com.hhlike.fwork.core.util.NullUtil;
import com.hhlike.fwork.mapper.FileInfoMapper;
import com.hhlike.fwork.model.FileInfo;
import com.hhlike.fwork.model.FileInfoExample;

import sun.misc.BASE64Decoder;
@Service
@SuppressWarnings("restriction")
public class PictureServiceImpl implements PictureService {

	@Autowired
	private FileInfoMapper fileInfoMapper;
	/**
	 * 上传图片
	 */
	@Override
	public ResultData uploadPicture(String img) throws Exception {
		String fileName = UUID.randomUUID().toString() + ".jpg";
		String baseFilePath = "c://";
		String subFilePath = "result//";
		//存储文件
		byte[] imgContent = translateImgContent(img);
		String md5Code = DigestUtils.md5DigestAsHex(imgContent);
		//如果已经存在图片了，不用保存到文件，直接返回图片路径
		FileInfoExample example = new FileInfoExample();
		example.createCriteria().andMd5CodeEqualTo(md5Code);
		List<FileInfo> fileInfoList = fileInfoMapper.selectByExample(example);
		if (NullUtil.isEmpty(fileInfoList)) {
			ResultData result = new ResultData(ResultStatus.OK);
			result.addData("picUrl", fileInfoList.get(0).getSubFolder() + fileInfoList.get(0).getFileName());
			return result;
		}
		//保存文件
		FileUtil.writeFile(baseFilePath + subFilePath + fileName, imgContent);
		//记录数据库表
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(fileName);
		fileInfo.setMd5Code(md5Code);
		fileInfo.setSubFolder(baseFilePath + subFilePath);
		fileInfo.setCreateTime(new Date());
		fileInfoMapper.insert(fileInfo);
		ResultData result = new ResultData(ResultStatus.OK);
		result.addData("picUrl", baseFilePath + subFilePath + fileName);
		return result;
	}

	private byte[] translateImgContent(String img) {
		String imgHead = img.substring(0, 28);
		if (imgHead.contains("data:image/")) {
			throw new BusiException(ExceptionStatus.PIC_FORMAT_ERROR);
		}
		String pureImg = StringUtils.substringAfter(img, ";base64,");
		// 图片base64解析转换成bytes
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = null;
		try {
			bytes = decoder.decodeBuffer(pureImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < bytes.length; ++i) {
			if (bytes[i] < 0) {// 调整异常数据
				bytes[i] += 256;
			}
		}
		return bytes;
	}
}
