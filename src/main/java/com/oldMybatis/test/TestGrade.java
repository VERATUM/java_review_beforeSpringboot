package com.oldMybatis.test;

import java.util.List;

import com.google.gson.Gson;
import com.oldMybatis.dao.GradeDao;
import com.oldMybatis.dao.impl.GradeDaoImpl;
import com.oldMybatis.entity.Grade;

public class TestGrade {
	public static void main(String[] args) {
		//region # 创建年级dao
		GradeDao gradeDao = new GradeDaoImpl();
		List<Grade> list = gradeDao.getAllGrade();
		//endregion
		for (Grade grade : list) {
			System.out.println(new Gson().toJson(grade));
		}
		/*Grade grade = new Grade(28,"ttaauu");*/
		// 添加
		/*int i = gradeDao.addGrade(grade);*/
		// 修改
		/*int i = gradeDao.updateGrade(grade);*/
		// 删除1
		/*int i = gradeDao.delGrade(grade);*/
		/*int i = gradeDao.delGrade(28);*/
		/*System.out.println(i);*/
		/*Grade grade1 = gradeDao.getGrade(gid);*/
		/*if(i > 0){
			System.out.println("操作"+i+"个成功,"+new Gson().toJson(grade));
		}else {
			System.out.println("操作失败");
		}*/
		/*System.out.println("操作成功,"+new Gson().toJson(grade1));*/
	}

}
