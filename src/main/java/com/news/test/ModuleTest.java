package com.news.test;

import java.util.List;

import org.junit.Test;

import com.news.dao.NewTypeDao;
import com.news.dao.impl.NewTypeDaoImpl;
import com.news.entity.NewType;
import com.news.service.NewTypeService;
import com.news.service.impl.NewTypeServiceImpl;

public class ModuleTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	@Test
	public void test1() {
		NewTypeDao n = new NewTypeDaoImpl();
		List<NewType> li = n.queryNewType(1, 5);
		for (NewType newType : li) {
			System.out.println(newType);
		}
	}
	@Test
	public void test2() {
		NewTypeService n = new NewTypeServiceImpl();
		List<NewType> li = n.queryNewType(1, 10);
		for (NewType newType : li) {
			System.out.println(newType);
		}
	}
}
