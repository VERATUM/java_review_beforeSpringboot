package com.trainSys.dao;

import java.util.List;

import com.trainSys.entity.TrainInfo;

public interface TrainInfoDao {
	/**
	 * 查询所有
	 * @return
	 */
	public List<TrainInfo> getAllTrain();
	/**
	 * 查单条
	 * @param train_no
	 * @return
	 */
	public TrainInfo finTrain(int train_no);
	/**
	 * 删除单条
	 * @param id
	 * @return
	 */
	public int delTrain(int train_no);
}
