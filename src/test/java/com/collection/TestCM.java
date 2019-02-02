package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestCM {
	@Test
	public void tcm() {
		//list接口集合元素是有序的、可重复的
		// ArrayList为list接口下的一个实现类
		List<String> list = new ArrayList<String>();
		System.out.println(list.size());
		list.add("little");
		list.add("刘备");
		list.add("关羽");
		list.add("黄忠");
		list.add("赵子龙");
		System.out.println("list集合显示");
		System.out.println(list.get(1));		
		System.out.println("*** *** ***");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--- --- |origin --- ---");
		
		String remove = list.remove(0);
		System.out.println("remove="+remove+",get(0)="+list.get(0));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--- --- remove| --- ---");
		
		list.add(1, "孔明");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--- --- pos[1]-add --- ---");
		
		System.out.println(list.contains("赵子龙"));
		System.out.println(list.contains("wo"));
		System.out.println("*** iterator迭代器 ***");
		// 迭代器
		// 遍历集合中所有的元素
		// 增强型为foreach方法
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {//判断集合有没有下一个元素
			System.out.println(iterator.next());//获取访问集合下一个元素
		}
		System.out.println("***happy spilit line ***");
		
		// foreach方法，此处写作为for
		for (Object object : list) {
			System.out.println(object);
		}
	}
	@Test
	public void tcm2() {
		// map 接口下的实现类Hashmap
		// map存储为键值对key-value|键不可重复；无序的,值可重复
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ICBC","中国工商银行");
		map.put("CBC","中国银行");
		map.put("CCB","中国建设银行");
		map.put("ABC","中国农业银行");
		map.put("ABC", "中国农业银行1");// 覆盖已有的
		map.put(null, "test");
		map.put("null", "test1");// null与"null"不同
		
		System.out.println("****** 1******");
		System.out.println("map的长度是："+map.size());
		
		System.out.println("****** 2******");
		System.out.println(map.get("ICBC"));
		
		System.out.println("****** 3******");
		System.out.println(map.containsKey("LGD"));
		System.out.println(map.containsValue("中国银行"));
		
		System.out.println("****** 4******");
		for (Object res : map.keySet()) {
			System.out.println(res+"||"+map.get(res));
		}
		
		System.out.println("****** 5******");
		System.out.println(map.remove("ICBC"));
		// map.remove(key)
		System.out.println(map.remove("中国银行"));
		
		System.out.println("****** 6******");
		for (Object res : map.keySet()) {
				System.out.println(res+"||"+map.get(res));
		}
		
		System.out.println("****** 7******");
		System.out.println(map.values() instanceof HashMap);
	}
	@Test
	public void tcm3() {
		// set类集合元素是唯一、无序的
		Set<String> set = new HashSet<String>();
		set.add("123");
		set.add("add");
		set.add("ver");
		set.add("atum");
		set.add("veratum");
		set.add("notify");
		// 显示set集合的所有对象
		for (Object object : set) {
			System.out.println(object);
		}
		
		System.out.println("****** ******");
		// 迭代法
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	@Test
	public void tcm4() {
		// 商品管理系统测试
		ProductManage pm = new ProductManage();
		pm.menu();
	}
}
