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

	//获得当前页数据
	@Override
	public Page<User> selectUsersPage(int currentPage) {
		// TODO Auto-generated method stub
		//查询总行数
		int count = userDao.selectUserCount();
		//计算出总的页数
		int pageCount = count % Page.PAGE_SIZE == 0 ? count / Page.PAGE_SIZE : count / Page.PAGE_SIZE+1;
		//System.out.println("总的页数："+pageCount);
		//通过当前页数执行分页查询
		List<User> data = userDao.selectUserLimit((currentPage-1)*Page.PAGE_SIZE,
				Page.PAGE_SIZE);
		
		//把总页数，当前页数，数据集合包装到Page对象中
		Page<User> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setPageCount(pageCount);
		page.setData(data);
		//返回Page对象
		return page;
	}
	
}
