package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) {
		try {
			// 创建服务器对象
			ServerSocket severSocket1 = new ServerSocket(8686);
			System.out.println("服务器正在连接...");
			//等待客服端连接
				Socket socket1 = severSocket1.accept();
				System.out.println("已接通...");
			// 收消息-发消息
			InputStream is01 = socket1.getInputStream();
			OutputStream os01 = socket1.getOutputStream();
			int len = is01.available();
			while(len == 0) {
				len = is01.available();
			}
			byte[] bs = new byte[is01.available()];
			is01.read(bs);
			System.out.println("接收消息:"+new String(bs));
			// 发消息给客户端
			os01.write("登入成功。。。".getBytes());
			
			os01.close();
			is01.close();
			socket1.close();
			severSocket1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
