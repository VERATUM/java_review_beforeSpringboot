package com.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
	public static void main(String[] args) {
		ServerSocket severSocket1 = null;
		try {
			// 创建服务器对象
			severSocket1 = new ServerSocket(8686);
			System.out.println("服务器正在连接...");
			//等待客服端连接
			while(true) {
				Socket socket1 = severSocket1.accept();
				// 多线程
				ChatThread chat = new ChatThread(socket1);
				chat.start();
				System.out.println(chat.getName()+"已接通...");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
