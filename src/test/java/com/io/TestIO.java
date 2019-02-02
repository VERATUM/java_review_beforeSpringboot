package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestIO {
	private Logger logger = LogManager.getLogger(TestIO.class);
	private String sys = System.getProperty("user.dir");
	//sys 是项目的系统路径F:\eclipse_workspace\java_review_beforeSpringboot
	@Test
	public void tio() {
		System.out.println(sys);
		String path = sys+"/logs/app1.log";
		FileInputStream fis =null;
		// 使用字符流封装读取，解决乱码
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(path);
			isr = new InputStreamReader(fis);// 可以指定读取编码(fis, "UTF-8")
			br = new BufferedReader(isr);
			
			System.out.println("start read:app.log");
			/*
			 int temp;
			 while ((temp = fis.read()) != -1) {
				System.out.print((char) temp);
			}
			读取中文会乱码
			*/
			String line;
			while((line = br.readLine()) != null) 
				System.out.println(line);
			System.out.println("end read!");
			
			br.close();
			isr.close();
		} catch (Exception e) {
			logger.info("TestIO出现异常:"+e);
		} finally {
				try {
					if (fis != null)
						fis.close();
				} catch (IOException e) {
					logger.info("TestIO出现异常:"+e);
				}
		}
	}
	@Test
	public void tio2() {
		String path = sys+"/src/main/webapp/testFile/tio2.txt";
		File file = new File(path);
		if (file.exists()) {
//			file.delete();
			System.out.println("文件存在");
		}else {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			System.out.println("文件创建成功:"+path);
		}
	}
	@Test
	public void tio3() {
		SimpleDateFormat type1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		File file = new File(sys);//创建文件
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println("|--start--|");
			System.out.print("名称:"+f.getName());
			System.out.print(" |大小:"+f.length());
			System.out.print(" |时间:"+type1.format(new Date(f.lastModified())));
			System.out.print(" |路径："+f.getAbsoluteFile());
			if (f.isFile()) {
				System.out.println(" |<文件>");
			}else {
				System.out.println(" |<文件夹>");
			}
			System.out.println("|--end--|\n");
		}
	}
	@Test
	public void tis4() {
		// 复制图片
		// 先读文件，后写入文件
		// 使用字符流
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		String rpath = sys + "/src/main/webapp/upload/Fri_z 01.jpg";
		String wpath = sys + "/src/main/webapp/testFile/Fri_z 01_copy.jpg";
		try {
			// read
			fr = new FileReader(rpath);
			br = new BufferedReader(fr);
			// write
			fw = new FileWriter(wpath);
			bw = new BufferedWriter(fw);
			// 按行读取
			String line;
			while((line = br.readLine()) != null) {
				bw.write(line);
				line = br.readLine();
			}
			System.out.println("copy成功");
		} catch (FileNotFoundException e) {
			logger.debug("出现异常:"+e.getMessage());
		} catch (IOException e) {
			logger.debug("出现异常:"+e.getMessage());
		}finally {
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				logger.debug("出现异常:"+e.getMessage());
			}
		}
	}
	@Test
	public void tio5() {
		// 复制图片
		// 先读文件，后写入文件
		// 使用字节流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String rpath = sys + "/src/main/webapp/upload/Contra1.gif";
		String wpath = sys + "/src/main/webapp/testFile/Contra1_copy.gif";
		try {
			fis = new FileInputStream(rpath);
			fos = new FileOutputStream(wpath);
			// 实现拷贝
			byte[] bs = new byte[fis.available()];
			fis.read(bs);
			
			fos.write(bs);
			System.out.println("copy成功");
		} catch (FileNotFoundException e) {
			logger.debug("出现异常:"+e.getMessage());
		} catch (IOException e) {
			logger.debug("出现异常:"+e.getMessage());
		}finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				logger.debug("出现异常:"+e.getMessage());
			}
		}
	}
	@Test
	public void tio6() {
		String str ="\nHello World11!";
		String path = sys+"/src/main/webapp/testFile/tio2.txt";
		try {
			// 创建字符流对象，输出流
			// true表示追加
			FileOutputStream fop = new FileOutputStream(path,true);
			// 写入文件
			fop.write(str.getBytes());
			System.out.println("wirte down");
			// 关闭流
			fop.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Test
	public void tio7() {
		// 输出流对象
		ObjectOutputStream oos = null;
		String path = sys+"/src/main/webapp/testFile/tio7.txt";
		try {
			// 创建流对象
			oos = new ObjectOutputStream(new FileOutputStream(path));
			// 创建学生对象并初始化
			Student stu = new Student("VER","25","男");
			Student stu1 = new Student("atum","18","男");
			List<Student> list = new ArrayList<Student>();
			list.add(stu);
			list.add(stu1);
			
			oos.writeObject(list);
			System.out.println("写入成功");
		} catch (IOException e) {
			logger.debug("出现异常:"+e.getMessage());
		}finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					logger.debug("出现异常:"+e.getMessage());
				}
			}
		}
	}
	@Test
	public void tio8() {
		ObjectInputStream ois = null;
		String path = sys+"/src/main/webapp/testFile/tio7.txt";
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			
			@SuppressWarnings("unchecked")
			List<Student> list = (List<Student>) ois.readObject();
			System.out.println("读取完成");
			
			for (int i = 0; i < list.size(); i++) {
				Student stu = list.get(i);
				System.out.println(stu);
			}
		} catch (IOException e) {
			logger.debug("出现异常:"+e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.debug("出现异常:"+e.getMessage());
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					logger.debug("出现异常:"+e.getMessage());
				}
			}
		}
	}
	@Test
	public void tio9() {
		NameOfStudentManageSystem nms = new NameOfStudentManageSystem();
		nms.menu();
	}
	@Test
	public void tio10() {
		String path = sys+"/src/main/webapp/testFile/tio10.txt";
		try {
			// 目标不存在则自动创建tio10.txt
			FileWriter fw = new FileWriter(path,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("101,ver,23");// 转义符会读取
			bw.newLine();//换行
			bw.write("102,ter,21");
			bw.newLine();
			System.out.println("write ok!");
			// 关闭
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void tio11() {
		String path = sys+"/src/main/webapp/testFile/tio10.txt";
		try {
			// path下的tio10.txt不存在，会报异常java.io.FileNotFoundException
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ( (str = br.readLine())!=null) {
				System.out.println(str);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
