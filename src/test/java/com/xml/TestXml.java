package com.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestXml {
	// 读取xml文件的路径
	private String path = System.getProperty("user.dir");
	private String filePath = path+"/src/main/webapp/testFile/saveStudent.xml";
	@Test
	public void tx() {
		// DOM4J的jar包使用
		try {
			// 使用SAXReader创建xml的document对象
			SAXReader saxReader= new SAXReader();
			Document document = saxReader.read(filePath);
			
			// 获取文档根元素
			Element eroot = document.getRootElement();
			System.out.println("根元素名字:"+eroot.getName());
			// 获取对应的元素内容
			System.out.println("根元素getPath:"+eroot.getPath());
			System.out.println("根元素getNamespacePrefix:"+eroot.getNamespacePrefix());
			System.out.println("根元素getNamespaceURI:"+eroot.getNamespaceURI());
			System.out.println("根元素getNodeType:"+eroot.getNodeType());
			System.out.println("根元素getNodeTypeName:"+eroot.getNodeTypeName());
			System.out.println("根元素getQualifiedName:"+eroot.getQualifiedName());
			System.out.println("根元素getStringValue:"+eroot.getStringValue());
			System.out.println("根元素getTextTrim:"+eroot.getTextTrim());
			System.out.println("根元素getUniquePath:"+eroot.getUniquePath());
			System.out.println("根元素getData:"+eroot.getData());
			System.out.println("根元素getDocument:"+eroot.getDocument());
			// 获取所有子标签
			List<Element> kidroot = eroot.elements();
			for (Element ele : kidroot) {
				// 获取子标签的子标签
				List<Element> infos = ele.elements();
				// 获取相应标签的元素内容.getText()
				System.out.println(ele.getName());
				System.out.print("姓名："+infos.get(0).getText());
				System.out.print("，年龄："+infos.get(1).getText());
				System.out.print("，地址："+infos.get(2).getText());
				// 获取元素属性
				// 获取元素的所有属性
				List<org.dom4j.Attribute> attris = ele.attributes();
				System.out.println("，学号:"+attris.get(0).getValue());

				// 通过属性的名字来获取对应的值
				//String v = ele.attributeValue("xh");
				//System.out.println("，学号:"+v);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void tx2() {
		// DOM4J的jar包使用
		try {			
			// 2.使用SAXReader创建xml的document对象
			SAXReader saxReader= new SAXReader();
			Document document = saxReader.read(filePath);
			
			// 3.获取文档根元素
			Element eroot = document.getRootElement();
			System.out.println("根元素名字:"+eroot.getName());
			
			// 4.添加节点
			Element addstu = eroot.addElement("student");
			// 添加子标签的属性
			addstu.addAttribute("xh", "102");
			//添加子标签的子标签,并给相应元素设置内容
			addstu.addElement("name").setText("我是谁");
			addstu.addElement("age").setText("25");
			addstu.addElement("address").setText("ver@dd");
			
			// 5.保存document文件到xml中
			FileWriter fw = new FileWriter(filePath);
			OutputFormat opf = OutputFormat.createPrettyPrint();// xml格式设置
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(fw, opf);
			xw.write(document);
			
			xw.close();
			System.out.println("添加成功");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void tx3() {
		// DOM4J的jar包使用
		String xh = "102";
		try {
			// 2.使用SAXReader创建xml的document对象
			SAXReader saxReader= new SAXReader();
			Document document = saxReader.read(filePath);
			
			// 3.获取文档根元素
			Element eroot = document.getRootElement();
			System.out.println("根元素名字:"+eroot.getName());
			
			// 4.删除子标签
			// 4.1 获取子标签
			List<Element> kidroot = eroot.elements();
			// 4.2 通过子标签的属性来删除子标签
			for (Element element : kidroot) {
				if (element.attributeValue("xh").equals(xh))
					//通过找到子标签的父标签来删除子标签自身
					element.getParent().remove(element);
			}
			
			// 5.保存document文件到xml中
			FileWriter fw = new FileWriter(filePath);
			OutputFormat opf = OutputFormat.createPrettyPrint();// xml格式设置
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(fw, opf);
			xw.write(document);
			
			xw.close();
			System.out.println("所有子标签属性:xh="+xh+"，删除成功");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void tx4() {
		// 留言测试
		LeaveAMessage lam = new LeaveAMessage();
		lam.menu();
	}
}
