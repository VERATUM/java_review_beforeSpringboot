package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatThread extends Thread{
	private Socket socket;
	public ChatThread() {}
	public ChatThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// 收消息-发消息
		InputStream is01 = null;
		OutputStream os01 = null;
		try {
			is01 = socket.getInputStream();
			os01 = socket.getOutputStream();
			int len = is01.available();
			while(len == 0) {
				len = is01.available();
			}
			byte[] bs = new byte[is01.available()];
			is01.read(bs);
			System.out.println("接收消息:"+new String(bs));
			// 发消息给客户端
			os01.write((new String(bs).substring(0, new String(bs).indexOf(","))+"=登入成功……").getBytes());	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os01.close();
				is01.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
