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
        //1.0 创建配置对象
        //创建Configuration实例，指定FreeMarker的版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //指定模板所在的目录
        /*ClassLoader classLoader = com.webtest.test.freemarker.class.getClassLoader();
        URL resource = classLoader.getResource("templates");
        System.out.println(resource);*/
        File templatesDir = new File("D:\\g3softwaretesting\\practical_training\\src\\com\\webtest\\test");
        cfg.setDirectoryForTemplateLoading(templatesDir);
        //设置默认字符集
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.name());
        //设置出现异常处理的方式，开发阶段可以设置为HTML_DEBUG_HANDLER
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        //2.0 创建数据模型
        Map<String, Object> root = new HashMap<>();
        root.put("user", "sheTing");
        Product latest = new Product();
        latest.setUrl("https://en.so.com/");
        latest.setName("360 英文");
        root.put("latestProduct", latest);

        //3.0 获取模板
        Template template = cfg.getTemplate("test.ftlh");

        //4.0 给模板绑定数据模型
//       
        template.process(root,new FileWriter("D:\\abc.html"));
//        template.process(root, out);

    }


}
