package com.webtest.test;

import java.io.File;
import java.util.Date;

import com.webtest.core.buildZip;

public class setZip {
	public static void main(String[] args) {
		//�ļ�����
		String file = "D:\\g3softwaretesting\\practical_training\\test-output\\html";//Ҳ�������ļ���·��
		//�����ɵ�zip����
		String zipName = "setZip";
		//�����ɵ�zip����·��
		String zipFilePath = "D:\\";
		//ѹ��
		buildZip.fileToZip(file , zipFilePath , zipName);
		
	} 
}
