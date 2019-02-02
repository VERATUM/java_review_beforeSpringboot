package com.oldMybatis.test;

import java.util.List;

import com.oldMybatis.dao.StudentDao;
import com.oldMybatis.dao.impl.StudentDaoImpl;
import com.oldMybatis.entity.Student;

public class TestStudent {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.getAllStudent();
		
		list.forEach(s->{
			System.out.println(s);
		});
	}
}
