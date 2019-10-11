package com.qianfeng.nanny.service;

import java.util.List;

import com.qiamfeng.nanny.entity.Page;
import com.qiamfeng.nanny.entity.User;

public interface UserService {
	public List<User> selectAllUsers();
	public void delUser(int id);
	public void UpdateUser(User user);
	public User SelectUserById(int id);
	public User SelectUserByUsername(String username);
	//µ±Ç°Ò³
	Page<User> selectUsersPage(int currentPage); 
}
