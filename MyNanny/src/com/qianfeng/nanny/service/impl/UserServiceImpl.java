package com.qianfeng.nanny.service.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.Page;
import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.UserDao;
import com.qianfeng.nanny.dao.impl.UserDaoImpl;
import com.qianfeng.nanny.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return userDao.SelectAllUsers();
	}
	
	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
		 userDao.delUser(id);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.UpdateUser(user);
	}

	@Override
	public User SelectUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.SelectUserById(id);
	}

	@Override
	public User SelectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.SelectUserByUsername(username);
	}

	//��õ�ǰҳ����
	@Override
	public Page<User> selectUsersPage(int currentPage) {
		// TODO Auto-generated method stub
		//��ѯ������
		int count = userDao.selectUserCount();
		//������ܵ�ҳ��
		int pageCount = count % Page.PAGE_SIZE == 0 ? count / Page.PAGE_SIZE : count / Page.PAGE_SIZE+1;
		//System.out.println("�ܵ�ҳ����"+pageCount);
		//ͨ����ǰҳ��ִ�з�ҳ��ѯ
		List<User> data = userDao.selectUserLimit((currentPage-1)*Page.PAGE_SIZE,
				Page.PAGE_SIZE);
		
		//����ҳ������ǰҳ�������ݼ��ϰ�װ��Page������
		Page<User> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setPageCount(pageCount);
		page.setData(data);
		//����Page����
		return page;
	}
	
}
