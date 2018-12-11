package com.webtest.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;



public class freemarker {
	public static void main(String[] args) throws IOException, TemplateException {
        //1.0 �������ö���
        //����Configurationʵ����ָ��FreeMarker�İ汾
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //ָ��ģ�����ڵ�Ŀ¼
        /*ClassLoader classLoader = com.webtest.test.freemarker.class.getClassLoader();
        URL resource = classLoader.getResource("templates");
        System.out.println(resource);*/
        File templatesDir = new File("D:\\g3softwaretesting\\practical_training\\src\\com\\webtest\\test");
        cfg.setDirectoryForTemplateLoading(templatesDir);
        //����Ĭ���ַ���
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.name());
        //���ó����쳣����ķ�ʽ�������׶ο�������ΪHTML_DEBUG_HANDLER
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        //2.0 ��������ģ��
        Map<String, Object> root = new HashMap<>();
        root.put("user", "sheTing");
        Product latest = new Product();
        latest.setUrl("https://en.so.com/");
        latest.setName("360 Ӣ��");
        root.put("latestProduct", latest);

        //3.0 ��ȡģ��
        Template template = cfg.getTemplate("test.ftlh");

        //4.0 ��ģ�������ģ��
//       
        template.process(root,new FileWriter("D:\\abc.html"));
//        template.process(root, out);

    }


}
