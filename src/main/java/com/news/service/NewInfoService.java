package com.news.service;

import java.util.List;

import com.news.entity.NewInfo;

public interface NewInfoService {
	public List<NewInfo> queryNewInfo();
	public List<NewInfo> queryNewInfos(int t_id);
	public NewInfo queryNewInfo(int n_id);
	/**
	 * 查询分页，按页大小、页码划分
	 * @param page 页码
	 * @param pageSize 页大小
	 * @return 返回新闻消息集合
	 */
	public List<NewInfo> queryNewInfoLimit(int page,int pageSize);
	/**
	 * 查询分页的页码总数
	 * @param pageSize 页大小
	 * @return 页码总数
	 */
	public int queryNewInfoPage(int pageSize);
	/**
	 * 添加单条新闻信息
	 * @param newInfo 新闻信息实体对象
	 * @return 返回影响行数
	 */
	public int addNewInfo(NewInfo newInfo);
	/**
	 * 删除单条信息
	 * @param n_id 新闻主键
	 * @return 影响行数
	 */
	public int delNewInfo(int n_id);
}
