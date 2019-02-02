package com.trainSys.dao.impl;

import java.util.List;

import com.trainSys.dao.BaseDao;
import com.trainSys.dao.TrainInfoDao;
import com.trainSys.entity.TrainInfo;

public class TrainInfoDaoImpl implements TrainInfoDao {

	@Override
	public List<TrainInfo> getAllTrain() {
		String sql = "select * from trainInfo";
		return BaseDao.selectDemos(sql, TrainInfo.class);
	}

	@Override
	public TrainInfo finTrain(int train_no) {
		String sql = "select * from trainInfo where train_no = ?";
		return BaseDao.selectDemo(sql, TrainInfo.class, train_no);
	}

	@Override
	public int delTrain(int train_no) {
		String sql = "delete from trainInfo where train_no = ?";
		return BaseDao.updateDemo(sql, train_no);
	}

}
