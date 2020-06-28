package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:10
 * @since
 **/
public class SAXOperation implements XMLOperation<Student> {
    private static final Logger log = LoggerFactory.getLogger(SAXOperation.class);
    private static final String PATH = "src/main/resources/student.tld";
    private static final String STUDENT="student";
    //封装document
    public Document getDocument() {
        //1、创建解析器
        SAXReader saxReader = new SAXReader();
        try {
            //下面是添加的代码
            saxReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            return saxReader.read(new File(PATH));
        } catch (Exception e) {
            log.error("xml文件解析失败：{}", e);
        }
        return null;
    }

    //刷写到xml
    public void flushXML(Document document) {
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(PATH)), outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            log.error("xml文件刷写失败：{}", e);
        }
    }

    /**
     * 新建
     *
     * @param object
     * @return
     */
    @Override
    public boolean create(Student object) {
        if (object != null) {
            Document document = getDocument();
            Element rootElement = document.getRootElement();
            Element student = rootElement.addElement(STUDENT);
            //添加
            student.addAttribute("id", object.getId().toString());
            student.addElement("name").setText(object.getName());
            student.addElement("age").setText(object.getAge().toString());
            //写入到xml
            flushXML(document);
            return true;
        }
        return false;
    }

    /**
     * 按照id进行删除吧
     *
     * @param object
     * @return
     */
    @Override
    public boolean remove(Student object) {
        Integer userId = object.getId();
        if (userId != null) {
            Document document = getDocument();
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator(STUDENT);
            while (iterator.hasNext()) {
                Element student = iterator.next();
                String id = student.attribute("id").getText();
                if (userId.equals(Integer.parseInt(id))) {
                    iterator.remove();
                    //刷写到xml
                    flushXML(document);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据id 更新假定id没有重复
     *
     * @param object
     * @return
     */
    @Override
    public boolean update(Student object) {
        Integer userId = object.getId();
        if (userId != null) {
            Document document = getDocument();
            Element rootElement = document.getRootElement();
            List<Element> students = rootElement.elements(STUDENT);
            for (Element student : students) {
                String id = student.attribute("id").getText();
                if (userId.equals(Integer.parseInt(id))) {
                    student.element("name").setText(object.getName());
                    student.element("age").setText(object.getAge().toString());
                    //刷写到xml
                    flushXML(document);
                    return true;
                }
            }


        }
        return false;
    }

    /**
     * 假设按照封装的id查询，没有返回null
     *
     * @param object
     * @return
     */
    @Override
    public Student query(Student object) {
        Integer userId = object.getId();
        if (userId != null) {
            // 拿到document
            Document document = getDocument();
            //拿到根节点
            Element rootElement = document.getRootElement();
            //所有学生标签
            List<Element> students = rootElement.elements(STUDENT);
            for (Element student : students) {
                String id = student.attribute("id").getText();
                if (userId.equals(Integer.parseInt(id))) {
                    // 也可以使用elementText直接获取值
                    String name = student.element("name").getTextTrim();
                    String age = student.element("age").getTextTrim();
                    object.setName(name);
                    object.setAge(Integer.parseInt(age));
                    log.info("查询出的student:{}", object);
                    return object;
                }
            }
        }
        return null;
    }
}
