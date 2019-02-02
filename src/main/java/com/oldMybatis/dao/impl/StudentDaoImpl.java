package com.oldMybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oldMybatis.dao.StudentDao;
import com.oldMybatis.entity.SearchStu;
import com.oldMybatis.entity.Student;
import com.oldMybatis.util.MyBatisUtil;

public class StudentDaoImpl implements StudentDao {
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = null;
		list = MyBatisUtil.getSession().selectList("com.oldMybatis.dao.StudentDao.getAllStudent");
		return list;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		SqlSession sqlSession;
		try{
			sqlSession = MyBatisUtil.getSession() ;
			return  sqlSession.selectList("com.oldMybatis.dao.StudentDao.getStudentByName", name);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSession();
		}
		return null;
	}

	@Override
	public List<Student> getStudent(SearchStu s) {
		return MyBatisUtil.getSession().selectList("com.oldMybatis.dao.StudentDao.getStudent", s);
	}

	@Override
	public int delStudent(int[] delids) {
		return MyBatisUtil.getSession().delete("com.oldMybatis.dao.StudentDao.delStudent",delids);
	}
}
