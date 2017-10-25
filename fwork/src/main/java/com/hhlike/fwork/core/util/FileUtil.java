package com.hhlike.fwork.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileUtil {

	/**
	 * 创建文件夹
	 * 
	 * @param folderPath
	 * @throws Exception
	 */
	public static void newFolder(String folderPath) throws Exception {
		File myFilePath = new File(folderPath);
		if (!myFilePath.exists()) {
			myFilePath.mkdir();
		}
	}

	/**
	 * 创建空文件
	 * 
	 * @param filePathAndName
	 * @throws Exception
	 */
	public static void newFile(String filePathAndName) throws Exception {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			throw new Exception("No such file or directory[" + filePathAndName + "]", e);
		}
	}

	/**
	 * 创建文件，并写入文件内容，string类型
	 * 
	 * @param filePathAndName
	 * @param fileContent
	 *            文件内容
	 * @throws Exception
	 */
	public static void writeFile(String filePathAndName, String fileContent) throws Exception {
		File file = new File(filePathAndName);
		if (!file.exists()) {
			file.createNewFile();
		}
		try (FileWriter fileWriter = new FileWriter(file); PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(fileContent);
		}
	}

	/**
	 * 创建文件，并写入文件内容，byte[]格式内容
	 * 
	 * @param filePathAndName
	 * @param fileContent
	 * @throws Exception
	 */
	public static void writeFile(String filePathAndName, byte[] fileContent) throws Exception {
		File file = new File(filePathAndName);
		if (!file.exists()) {
			file.createNewFile();
		}
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(fileContent);
		}
	}

	/**
	 * 创建文件，并写入文件内容，InputStream格式内容
	 * 
	 * @param filePathAndName
	 * @param inputStream
	 * @throws Exception
	 */
	public static void writeFile(String filePathAndName, InputStream inputStream) throws Exception {
		File file = null;
		file = new File(filePathAndName);
		if (!file.exists()) {
			file.createNewFile();
		}
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			byte[] buffer = new byte[1024];
			while (inputStream.read(buffer) != -1) {
				outputStream.write(buffer);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param filePathAndName
	 * @throws Exception
	 */
	public static void delFile(String filePathAndName) throws Exception {
		File file = new File(filePathAndName);
		file.delete();
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
		}
	}

	/**
	 * 删除文件夹下所有文件
	 * 
	 * @param path
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
			}
		}
	}

}
