package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client02 {
	public static void main(String[] args) {
		try {
			// 创建Socket客户端
			System.out.println("客户端正在连接...");
			Socket socket01 = new Socket("localhost",8686);//127.0.0.1
			System.out.println("可以传输数据了");
			// 创建流对象，与服务器进行交互
			OutputStream os01 = socket01.getOutputStream();
			InputStream is01 = socket01.getInputStream();
			// 发消息
			String str = "用户名:admin+aas02,密码:password+hello02";
			os01.write(str.getBytes());
			System.out.println("发消息-->over");
			socket01.shutdownOutput();
			
			//接收消息
			int len = is01.available();
			while(len == 0) {
				len = is01.available();
			}
			byte[] bs = new byte[is01.available()];
			is01.read(bs);
			System.out.println("接收服务器消息:"+new String(bs));
			socket01.shutdownInput();
			
			is01.close();
			os01.flush();
			os01.close();
			socket01.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
