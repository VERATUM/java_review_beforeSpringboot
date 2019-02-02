package com.news.dao;

import java.util.List;

import com.news.entity.NewType;
import com.news.util.PageInfo;

public interface NewTypeDao {
	/**
	 * 添加
	 * @param nt
	 * @return
	 */
	public int addNewType(NewType nt);
	/**
	 * 查询所有
	 * @return
	 */
	public List<NewType> queryNewType();
	/**
	 * 删除单个
	 * @param t_id
	 * @return
	 */
	public int delNewType(int t_id);
	/**
	 * 得到一个查询结果
	 * @return
	 */
	public NewType getNewType(int t_id);
	/**
	 * 修改一个值
	 * @param t_id
	 * @return
	 */
	public int updateNewType(NewType nt);
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<NewType> queryNewType(int page,int pageSize);
	/**
	 * 根据页大小，查询总的页数
	 * @param pageSize
	 * @return
	 */
	public int queryNewTypePage(int pageSize);
	
	public PageInfo<NewType> queryNewType(PageInfo<NewType> pageInfo);
}
