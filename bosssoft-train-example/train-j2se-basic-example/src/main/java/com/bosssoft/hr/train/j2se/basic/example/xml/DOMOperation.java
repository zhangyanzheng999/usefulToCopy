package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:13
 * @since
 **/
public class DOMOperation implements XMLOperation<Student> {
    private static final Logger log = LoggerFactory.getLogger(DOMOperation.class);
    private static final String PATH = "src/main/resources/student.tld";
    private static final String STUDENT = "student";
    private static Document document;

    /**
     * 由于增删改查都需要获取到xml 所以提取出一个方法
     * 但是采用w3c解析的话会把回车也当做一个子节点解析出 #text
     *
     * @return
     */
    static {
        try {
            //1.创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
            factory.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // 2.通过解析器工厂创建解析器对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 3.解析xml文件，得到Document对象
            // 拿到路径
            document = builder.parse(PATH);
        } catch (IllegalArgumentException | ParserConfigurationException | SAXException | IOException e) {
            log.error("xml文件解析失败：{}", e);
        }
    }


    /**
     * 刷写到xml文件 用于增删改
     *
     * @param document
     */
    public void flushXML(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, ""); // Compliant
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(PATH));
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            log.error("xml文件刷写失败：{}", e);
        }


    }

    @Override
    public boolean create(Student object) {
        Integer userId = object.getId();
        if (userId != null) {
            Element element = document.createElement(STUDENT);
            element.setAttribute("id", userId.toString());

            Element name = document.createElement("name");
            name.setTextContent(object.getName());
            Element age = document.createElement("age");
            age.setTextContent(object.getAge().toString());
            //注意不能连续追加
            element.appendChild(name);
            element.appendChild(age);

            document.getFirstChild().appendChild(element);

            //刷写
            flushXML(document);
            return true;
        }
        return false;
    }

    /**
     * 删除 按照id删除吧
     *
     * @param object
     * @return
     */
    @Override
    public boolean remove(Student object) {
        Integer userId = object.getId();
        if (userId != null) {
            NodeList students = document.getElementsByTagName(STUDENT);
            for (int i = 0; i < students.getLength(); i++) {
                Element item = (Element) students.item(i);
                if (userId.equals(Integer.parseInt(item.getAttribute("id")))) {
                    item.getParentNode().removeChild(item);
                    //刷新
                    flushXML(document);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 按照给定的Id 更新
     *
     * @param object
     * @return
     */
    @Override
    public boolean update(Student object) {
        NodeList students = document.getElementsByTagName(STUDENT);
        for (int i = 0; i < students.getLength(); i++) {
            Element item = (Element) students.item(i);
            if (object.getId().equals(Integer.parseInt(item.getAttribute("id")))) {
                item.getElementsByTagName("name").item(0).setTextContent(object.getName());
                item.getElementsByTagName("age").item(0).setTextContent(String.valueOf(object.getAge()));

                //需要将修改后的内存树保存到磁盘中--使用javax.xml.transform 中的transform类
                flushXML(document);
                return true;
            }
        }
        return false;

    }

    /**
     * 假设按照封装的id查 默认id不重复
     *
     * @param object
     * @return
     */
    @Override
    public Student query(Student object) {
        if (object.getId() != null) {
            NodeList nodeList = document.getElementsByTagName(STUDENT);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element item = (Element) nodeList.item(i);
                if (object.getId().equals(Integer.parseInt(item.getAttribute("id")))) {
                    //获取名字
                    NodeList nameList = item.getElementsByTagName("name");
                    String name = nameList.item(0).getTextContent();
                    object.setName(name);
                    //
                    NodeList ageList = item.getElementsByTagName("age");
                    String age = ageList.item(0).getTextContent();
                    object.setAge(Integer.parseInt(age));
                    //打印一下
                    log.info("the student is:{}", object);
                    return object;
                }
            }
        }
        return null;
    }


}
