package com.oldMybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.oldMybatis.dao.GradeDao;
import com.oldMybatis.entity.Grade;
import com.oldMybatis.util.MyBatisUtil;

public class Grade1 {
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		GradeDao gradeDao = session.getMapper(GradeDao.class);
		List<Grade> allGrade = gradeDao.getAllGrade();
		for (Grade grade : allGrade) {
			System.out.println(new Gson().toJson(grade));
		}
	}
}

