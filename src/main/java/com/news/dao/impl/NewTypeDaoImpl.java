package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewTypeDao;
import com.news.entity.NewType;
import com.news.util.NewSBBaseDao;
import com.news.util.PageInfo;

public class NewTypeDaoImpl extends NewSBBaseDao implements NewTypeDao {

	@Override
	public int addNewType(NewType nt) {
		String sql = "insert into new_type (t_name) values (?)";
		return this.exeUpdate(sql, new Object[] {nt.gettName()});
	}

	@Override
	public List<NewType> queryNewType() {
		String sql = "select * from new_type";
		List<NewType> list = null;
		try {
			list = new ArrayList<NewType>();
			ResultSet rs = this.exeQuery(sql, null);
			while(rs.next()) {
				NewType newType = new NewType();
				newType.settId(rs.getInt(1));
				newType.settName(rs.getString(2));
				list.add(newType);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return null;
	}

	@Override
	public int delNewType(int t_id) {
		String sql = "delete from new_type where t_id=?";
		return this.exeUpdate(sql,new Object[]{t_id});
	}

	@Override
	public NewType getNewType(int t_id) {
		String sql = "select * from new_type where t_id = ?";
		NewType nt = null;
		try {
			ResultSet rs = this.exeQuery(sql,new Object[]{t_id});
			if(rs.next()) {
				nt = new NewType();
				nt.settId(rs.getInt(1));
				nt.settName(rs.getString(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nt;
	}

	@Override
	public int updateNewType(NewType nt) {
		String sql = "update new_type set t_name = ? where t_id = ?";
		return this.exeUpdate(sql, new Object[]{nt.gettName(),nt.gettId()});
	}

	@Override
	public List<NewType> queryNewType(int page, int pageSize) {
		String sql = "select * from new_type limit ?,?";
		List<NewType> list = null;
		try {
			int startpage = (page-1)*pageSize;
			list = new ArrayList<NewType>();
			ResultSet rs = this.exeQuery(sql, new Object[]{startpage,pageSize});
			while(rs.next()) {
				NewType newType = new NewType();
				newType.settId(rs.getInt(1));
				newType.settName(rs.getString(2));
				list.add(newType);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int queryNewTypePage(int pageSize) {
		String sql = "select count(1) from new_type";
		int total = 0;
		try {
			ResultSet rs = this.exeQuery(sql,null);
			if(rs.next()) {
				total=(int) Math.ceil(1.0*rs.getInt(1)/pageSize);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return total;
	}

	@Override
	public PageInfo<NewType> queryNewType(PageInfo<NewType> pageInfo) {
		String sql = "select * from new_type limit ?,?";
		String sql1 = "select count(1) from new_type";
		List<NewType> list = null;
		int startpos = (pageInfo.getCurrent()-1)*pageInfo.getLength();
		try {
			list = new ArrayList<NewType>();
			ResultSet rs = this.exeQuery(sql, new Object[]{startpos,pageInfo.getLength()});
			while(rs.next()) {
				NewType newType = new NewType();
				newType.settId(rs.getInt(1));
				newType.settName(rs.getString(2));
				list.add(newType);
			}
			// 将list添加到pageInfo
			pageInfo.setResults(list);
			
			// 查询总页数
			rs = exeQuery(sql1, null);
			if (rs.next()) {
				pageInfo.setCount(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return pageInfo;
	}
	public static void main(String[] args) {
		PageInfo<NewType> pageInfo = new PageInfo<>();
		pageInfo.setCurrent(3);// 当前页码
		NewTypeDao newTypeDao = new NewTypeDaoImpl();
		pageInfo = newTypeDao.queryNewType(pageInfo);
		System.out.println("页大小:"+pageInfo.getLength());
		System.out.println("页记录数:"+pageInfo.getCount());
		System.out.println("页总数:"+pageInfo.getTotal());
		System.out.println("当前页:"+pageInfo.getCurrent());
		for (NewType newType : pageInfo.getResults()) {
			System.out.println(newType);
		}
	}
}
