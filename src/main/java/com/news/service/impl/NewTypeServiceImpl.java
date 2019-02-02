package com.news.service.impl;

import java.util.List;

import com.news.dao.NewTypeDao;
import com.news.dao.impl.NewInfoDaoImpl;
import com.news.dao.impl.NewTypeDaoImpl;
import com.news.entity.NewType;
import com.news.service.NewTypeService;

public class NewTypeServiceImpl implements NewTypeService {
	NewTypeDao newTypeDao = new NewTypeDaoImpl();
	@Override
	public int addNewType(NewType nt) {
		return newTypeDao.addNewType(nt);
	}
	@Override
	public List<NewType> queryNewType() {
		return newTypeDao.queryNewType();
	}
	@Override
	public int delNewType(int t_id) {
		return newTypeDao.delNewType(t_id);
	}
	@Override
	public NewType getNewType(int t_id) {
		return newTypeDao.getNewType(t_id);
	}
	@Override
	public int updateNewType(NewType nt) {
		return newTypeDao.updateNewType(nt);
	}
	@Override
	public List<NewType> queryNewType(int page, int pageSize) {
		return newTypeDao.queryNewType(page, pageSize);
	}
	@Override
	public int queryNewTypePage(int pageSize) {
		return newTypeDao.queryNewTypePage(pageSize);
	}
	@Override
	public List<NewType> queryNewInfosBlongNewType() {
		List<NewType> list = newTypeDao.queryNewType();
		for (int i = 0; i < list.size(); i++) {
			NewType newType = list.get(i);
			newType.setNewInfos(new NewInfoDaoImpl().queryNewInfos(newType.gettId()));
		}
		return list;
	}

}
