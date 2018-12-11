package testHelloWorld;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
/*���smtp=smtp.163.com
senderMail=15511466887@163.com
recieverMail=517328263@qq.com
Mail_code=522506zfy*/
import javax.mail.internet.MimeMultipart;

public class SendMailHtml {
	//�����˵�ַ
    public static String senderAddress = "15511466887@163.com";
    //�ռ��˵�ַ
    public static String recipientAddress = "517328263@qq.com";
    //�������˻���
    public static String senderAccount = "15511466887@163.com";
    //�������˻�����
    public static String senderPassword = "522506zfy";
    public static void main(String[] args) throws Exception {
        //1�������ʼ��������Ĳ�������
        Properties props = new Properties();
        //�����û�����֤��ʽ
        props.setProperty("mail.smtp.auth", "true");
        //���ô���Э��
        props.setProperty("mail.transport.protocol", "smtp");
        //���÷����˵�SMTP��������ַ
        props.setProperty("mail.smtp.host", "smtp.yeah.net");
        //2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(props);
        //���õ�����Ϣ�ڿ���̨��ӡ����
        session.setDebug(true);
        //3�������ʼ���ʵ������
        Message msg = getMimeMessage(session);
        //4������session�����ȡ�ʼ��������Transport
        Transport transport = session.getTransport();
        //���÷����˵��˻���������
        transport.connect("smtp.163.com",senderAccount, senderPassword);
        //�����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(msg,msg.getAllRecipients());
         
        //���ֻ�뷢�͸�ָ�����ˣ���������д��
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
         
        //5���ر��ʼ�����
        transport.close();
    }
    /**
     * ��ô���һ���ʼ���ʵ������
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public static MimeMessage getMimeMessage(Session session) throws Exception{
        //����һ���ʼ���ʵ������
        MimeMessage msg = new MimeMessage(session);
//        Message msg = new MimeMessage(session, new FileInputStream(new File("C:/Users/H__D/Desktop/demo.eml")));
        //���÷����˵�ַ
        msg.setFrom(new InternetAddress(senderAddress));
        /**
         * �����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
         * MimeMessage.RecipientType.TO:����
         * MimeMessage.RecipientType.CC������
         * MimeMessage.RecipientType.BCC������
         */
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
        //�����ʼ�����
        msg.setSubject("�ʼ�����","UTF-8");
        //�����ʼ�����
        Multipart m = new MimeMultipart();
        BodyPart body = new MimeBodyPart();
        DataSource source = new FileDataSource(new File("D:\\g3softwaretesting\\practical_training\\test-output\\html\\suite1_test1_results.html"));
        body.setDataHandler(new DataHandler(source));
        m.addBodyPart(body);
        msg.setContent(m, "file");
//        msg.setContent("�򵥵Ĵ��ı��ʼ���HelloWorld", "text/html;charset=UTF-8");
        //�����ʼ��ķ���ʱ��,Ĭ����������
        msg.setSentDate(new Date());
        return msg;
    }
}
