package com.test.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MyFreemarkerUtil {

    private Configuration cfg;

    public MyFreemarkerUtil() {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("utf-8");
    }

    public void init(Class<?> cls, String basePackagePath) {
        cfg.setClassForTemplateLoading(cls, basePackagePath);
    }

    public void init(ClassLoader classLoader, String basePackagePath) {
        cfg.setClassLoaderForTemplateLoading(classLoader, basePackagePath);
    }

    public void init(String path) throws Exception {
        cfg.setDirectoryForTemplateLoading(new File(path));
    }

    public void init(ServletContext servletContext, String basePackagePath) {
        cfg.setServletContextForTemplateLoading(servletContext, basePackagePath);
    }

    public void write(String name, Map<String, Object> map, OutputStream out) throws Exception {
        Template temp = cfg.getTemplate(name);
        temp.process(map, new OutputStreamWriter(out, "utf-8"));
    }

    public void write(String name, Map<String, Object> map, Writer out) throws Exception {
        Template temp = cfg.getTemplate(name);
        temp.process(map, out);
    }

    public void write(String name, Map<String, Object> map) throws Exception {
        write(name, map, System.out);
    }

    public void write(String name, Map<String, Object> map, File file) throws Exception {
        Writer out = null;
        try {
            out = new FileWriter(file);
            write(name, map, out);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
