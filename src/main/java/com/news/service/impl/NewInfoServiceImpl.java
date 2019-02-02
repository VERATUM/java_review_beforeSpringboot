package com.news.service.impl;

import java.util.List;

import com.news.dao.NewInfoDao;
import com.news.dao.impl.NewInfoDaoImpl;
import com.news.entity.NewInfo;
import com.news.service.NewInfoService;

public class NewInfoServiceImpl implements NewInfoService {
	private NewInfoDao newInfoDao = new NewInfoDaoImpl();
	@Override
	public List<NewInfo> queryNewInfo() {
		return newInfoDao.queryNewInfo();
	}
	@Override
	public List<NewInfo> queryNewInfos(int t_id) {
		return newInfoDao.queryNewInfos(t_id);
	}
	@Override
	public NewInfo queryNewInfo(int n_id) {
		return newInfoDao.queryNewInfo(n_id);
	}
	@Override
	public List<NewInfo> queryNewInfoLimit(int page, int pageSize) {
		return newInfoDao.queryNewInfoLimit(page, pageSize);
	}
	@Override
	public int queryNewInfoPage(int pageSize) {
		return newInfoDao.queryNewInfoPage(pageSize);
	}
	@Override
	public int addNewInfo(NewInfo newInfo) {
		return newInfoDao.addNewInfo(newInfo);
	}
	@Override
	public int delNewInfo(int n_id) {
		return newInfoDao.delNewInfo(n_id);
	}

}
