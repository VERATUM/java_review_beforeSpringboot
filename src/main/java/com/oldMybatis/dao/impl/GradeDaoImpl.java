package com.oldMybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oldMybatis.dao.GradeDao;
import com.oldMybatis.entity.Grade;
import com.oldMybatis.util.MyBatisUtil;

public class GradeDaoImpl implements GradeDao {
	SqlSession sqlSession = null;
	@Override
	public List<Grade> getAllGrade() {
		List<Grade> list = null;
		try {
			sqlSession = MyBatisUtil.getSession();
			list = sqlSession.selectList("com.oldMybatis.dao.GradeDao.getAllGrade");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return list;
		/*try {
			// 1. 读取配置文件
			reader = Resources.getResourceAsReader("oldMybatis/mybatis-config.xml");
			// 2. 获取SqlSessionFactory 
			ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(reader);
			// 3. 获取SqlSession 
			sqlSession = ssf.openSession();
			// 4. 使用sqlSession对象,给定id
			list = sqlSession.selectList("com.oldMybatis.dao.GradeDao.getAllGrade");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5. 关闭
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}*/
	}

	@Override
	public int addGrade(Grade grade) {
		int row = -1;
		try {
			sqlSession = MyBatisUtil.getSession();
			row = sqlSession.insert("com.oldMybatis.dao.GradeDao.addGrade", grade);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return row;
	}

	@Override
	public int delGrade(Grade grade) {
		int row = -1;
		try {
			sqlSession = MyBatisUtil.getSession();
			row = sqlSession.delete("com.oldMybatis.dao.GradeDao.delGrade", grade);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return row;
	}

	@Override
	public int delGrade(Integer gid) {
		int row = -1;
		try {
			sqlSession = MyBatisUtil.getSession();
			row = sqlSession.delete("com.oldMybatis.dao.GradeDao.delGrade", gid);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return row;
	}

	@Override
	public int updateGrade(Grade grade) {
		int row = -1;
		try {
			sqlSession = MyBatisUtil.getSession();
			row = sqlSession.update("com.oldMybatis.dao.GradeDao.updateGrade", grade);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return row;
	}

	@Override
	public Grade getGrade(Integer gid) {
		Grade grade = null;
		// 使用配置包
		try {
			sqlSession = MyBatisUtil.getSession();
			grade = sqlSession.selectOne("com.oldMybatis.dao.GradeDao.getGrade", gid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return grade;
	}

}
