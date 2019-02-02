package com.oldMybatis.entity;

public class SearchStu {
	// 搜索条件
	private String name;
	private Integer startAge;
	private Integer endAge;

	public SearchStu(String name, Integer startAge, Integer endAge) {
		this.name = name;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	public SearchStu() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}
}
