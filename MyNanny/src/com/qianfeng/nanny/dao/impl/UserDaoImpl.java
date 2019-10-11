package com.qianfeng.nanny.dao.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.UserDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> SelectAllUsers() {
		// TODO Auto-generated method stub
		return JdbcUtils.queryList(User.class,"select * from tb_user");
	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
		JdbcUtils.Update("delete from tb_user where user_id = ?",id);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		 JdbcUtils.Update("update tb_user set username=?,realname=?,address=?,tel=? where user_id =?", 
				 user.getUsername(),
				 user.getRealname(),
				 user.getAddress(),
				 user.getTel(),
				 user.getUser_id());
	}

	@Override
	public User SelectUserById(int id) {
		// TODO Auto-generated method stub
		return JdbcUtils.queryOne(User.class, "select * from tb_user where user_id = ?",id);
	}

	@Override
	public User SelectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return JdbcUtils.queryOne(User.class, "select * from tb_user where username = ?", username);
	}
	
	//数据的总量
	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return JdbcUtils.queryCount("select count(*) from tb_user");
	}
	//每一页数据
	@Override
	public List<User> selectUserLimit(int start, int length) {
		// TODO Auto-generated method stub
		return JdbcUtils.queryList(User.class, 
				"select * from tb_user limit ?,?",
				start,length);
	}

}
