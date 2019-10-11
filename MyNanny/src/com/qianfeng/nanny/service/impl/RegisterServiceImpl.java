package com.qianfeng.nanny.service.impl;

import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.RegisterDao;
import com.qianfeng.nanny.dao.impl.RegisterDaoImpl;
import com.qianfeng.nanny.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	RegisterDao registerDao = new RegisterDaoImpl();
	@Override
	public int Insert(User user) {
		// TODO Auto-generated method stub
		return registerDao.Insert(user);
	}

}
