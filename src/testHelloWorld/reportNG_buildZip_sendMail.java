package testHelloWorld;

import com.webtest.core.buildZip;
import com.webtest.core.sendMail;

public class reportNG_buildZip_sendMail {
	public static void main(String[] args) throws Exception{
		//ѹ��ָ���ļ�����
				String file = "D:\\g3softwaretesting\\practical_training\\test-output\\html";//Ҳ�������ļ���·��
				//�����ɵ�zip����
				String zipName = "setZip124";
				//�����ɵ�zip����·��
				String zipFilePath = "D:\\";
				//ѹ��
				buildZip.fileToZip(file , zipFilePath , zipName);
		//������ļ���Ϊ���������ʼ���
				sendMail s1 = new sendMail();
				s1.setTitle_body("����","����");
				s1.Mail();
		
	}
}
