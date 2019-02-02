package com.oldMybatis.dao;

import java.util.List;

import com.oldMybatis.entity.SearchStu;
import com.oldMybatis.entity.Student;

public interface StudentDao {
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> getAllStudent();

	/**
	 * 通过姓名查找
	 * @param name
	 * @return
	 */
	public List<Student> getStudentByName(String name);

	/**
	 * 条件查询
	 * @param serchStu
	 * @return
	 */
	public List<Student> getStudent(SearchStu serchStu);

	/**
	 * 多项删除
	 * @param delids
	 * @return
	 */
	public int delStudent(int[] delids);
}
