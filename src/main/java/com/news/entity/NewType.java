package com.news.entity;

import java.util.List;

//新闻类别实体类
public class NewType {
	/**
	 * tId-类别编号，tName-名称
	 */
	private int tId;
	private String tName;
	// 新闻类别1：N新闻信息
	private List<NewInfo> newInfos;
	
	@Override
	public String toString() {
		return "NewType [tId=" + tId + ", tName=" + tName + ", newInfos=" + newInfos + "]";
	}
	public List<NewInfo> getNewInfos() {
		return newInfos;
	}
	public void setNewInfos(List<NewInfo> newInfos) {
		this.newInfos = newInfos;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}	
}
