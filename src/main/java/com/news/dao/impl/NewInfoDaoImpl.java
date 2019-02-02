package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewInfoDao;
import com.news.entity.NewInfo;
import com.news.util.NewSBBaseDao;

public class NewInfoDaoImpl extends NewSBBaseDao implements NewInfoDao {

	@Override
	public List<NewInfo> queryNewInfo() {
		String sql = "select n_title,n_author,n_time,n_id,n_content from newinfo";
		List<NewInfo> list = null;
		try {
			list = new ArrayList<NewInfo>();
			ResultSet rs = this.exeQuery(sql, null);
			while (rs.next()) {
				NewInfo newInfo = new NewInfo();
				newInfo.setN_title(rs.getString(1));
				newInfo.setN_author(rs.getString(2));
				newInfo.setN_time(rs.getString(3));
				newInfo.setN_id(rs.getInt(4));
				newInfo.setN_content(rs.getString(5));
				list.add(newInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public List<NewInfo> queryNewInfos(int t_id) {
		String sql = "select n_title,n_author,n_time,n_id,n_content from newinfo where n_type=?";
		List<NewInfo> list = null;
		try {
			list = new ArrayList<NewInfo>();
			ResultSet rs = this.exeQuery(sql, new Object[] {t_id});
			while (rs.next()) {
				NewInfo newInfo = new NewInfo();
				newInfo.setN_title(rs.getString(1));
				newInfo.setN_author(rs.getString(2));
				newInfo.setN_time(rs.getString(3));
				newInfo.setN_id(rs.getInt(4));
				newInfo.setN_content(rs.getString(5));
				list.add(newInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public NewInfo queryNewInfo(int n_id) {
		String sql = "select n_title,n_author,n_time,n_content from newinfo where n_id=?";
		NewInfo newInfo = null;
		try {
			ResultSet rs = this.exeQuery(sql, new Object[] {n_id});
			if (rs.next()) {
				newInfo = new NewInfo();
				newInfo.setN_title(rs.getString(1));
				newInfo.setN_author(rs.getString(2));
				newInfo.setN_time(rs.getString(3));
				newInfo.setN_content(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return newInfo;
	}
	@Override
	public List<NewInfo> queryNewInfoLimit(int page, int pageSize) {
		String sql = "select * from newinfo limit ?,?";
		List<NewInfo> list = null;
		try {
			list = new ArrayList<NewInfo>();
			int startPage = (page-1)*pageSize;
			ResultSet rs = this.exeQuery(sql, new Object[] {startPage,pageSize});
			while (rs.next()) {
				NewInfo newInfo = new NewInfo();
				newInfo.setN_title(rs.getString("n_title"));
				newInfo.setN_author(rs.getString("n_author"));
				newInfo.setN_time(rs.getString("n_time"));
				newInfo.setN_id(rs.getInt("n_id"));
				list.add(newInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int queryNewInfoPage(int pageSize) {
		String sql = "select count(1) from newinfo";
		int total = 0;
		try {
			ResultSet rs = this.exeQuery(sql,null);
			if(rs.next()) {
				total = (int)Math.ceil(1.0*rs.getInt(1)/pageSize);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return total;
	}

	@Override
	public int addNewInfo(NewInfo newInfo) {
		String sql = "INSERT INTO newinfo(n_title,n_content,n_author,n_type,n_pic) VALUES(?,?,?,?,?)";
		Object[] obj = {
				newInfo.getN_title(),
				newInfo.getN_content(),
				newInfo.getN_author(),
				newInfo.getN_type(),
				newInfo.getN_pic()
		};
		return exeUpdate(sql, obj);
	}

	@Override
	public int delNewInfo(int n_id) {
		String sql = "DELETE FROM newinfo where n_id = ?";
		return exeUpdate(sql, new Object[]{n_id});
	}

}
