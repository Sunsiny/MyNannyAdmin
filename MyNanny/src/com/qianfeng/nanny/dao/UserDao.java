package com.qianfeng.nanny.dao;

import java.util.List;

import com.qiamfeng.nanny.entity.User;

public interface UserDao {
	public List<User> SelectAllUsers();
	public void delUser(int id);
	public void UpdateUser(User user);
	public User SelectUserById(int id);
	public User SelectUserByUsername(String username);
	//查询总数据量
	public int selectUserCount();
	//数据的每一页的起始数据，每一页的数据总数
	List<User> selectUserLimit(int start,int length);
}
