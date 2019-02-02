package com.oldMybatis.dao;

import java.util.List;

import com.oldMybatis.entity.Grade;

public interface GradeDao {
	/**
	 * 查询所有年级
	 * @return
	 */
	public List<Grade> getAllGrade();

	/**
	 * 添加单个年纪
	 * @param grade
	 * @return
	 */
	public int addGrade(Grade grade);

	/**
	 * 删除单个年纪
	 * @param grade
	 * @return
	 */
	public int delGrade(Grade grade);
	public int delGrade(Integer gid);

	/**
	 * 修改单个年纪
	 * @param grade
	 * @return
	 */
	public int updateGrade(Grade grade);

	/**
	 * 查询单个年纪
	 * @param gid
	 * @return
	 */
	public Grade getGrade(Integer gid);
}
