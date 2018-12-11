package com.webtest.test;

import java.io.File;
import java.util.Date;

import com.webtest.core.buildZip;

public class setZip {
	public static void main(String[] args) {
		//文件对象
		String file = "D:\\g3softwaretesting\\practical_training\\test-output\\html";//也可以是文件夹路径
		//待生成的zip包名
		String zipName = "setZip";
		//待生成的zip保存路径
		String zipFilePath = "D:\\";
		//压缩
		buildZip.fileToZip(file , zipFilePath , zipName);
		
	} 
}
