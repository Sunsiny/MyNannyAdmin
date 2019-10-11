package com.qianfeng.nanny.dao;

import java.util.List;

import com.qiamfeng.nanny.entity.User;

public interface UserDao {
	public List<User> SelectAllUsers();
	public void delUser(int id);
	public void UpdateUser(User user);
	public User SelectUserById(int id);
	public User SelectUserByUsername(String username);
	//��ѯ��������
	public int selectUserCount();
	//���ݵ�ÿһҳ����ʼ���ݣ�ÿһҳ����������
	List<User> selectUserLimit(int start,int length);
}
