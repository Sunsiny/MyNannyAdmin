package com.qianfeng.nanny.service.impl;

import com.qiamfeng.nanny.entity.Administrators;
import com.qianfeng.nanny.dao.LoginDao;
import com.qianfeng.nanny.dao.impl.LoginDaoImpl;
import com.qianfeng.nanny.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	LoginDao logindao = new LoginDaoImpl();
	@Override
	public Administrators Login(String username, String password) {
		// TODO Auto-generated method stub
		return logindao.Login(username, password);
	}

}
