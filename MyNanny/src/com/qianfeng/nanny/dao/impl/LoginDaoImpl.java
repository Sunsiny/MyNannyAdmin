package com.qianfeng.nanny.dao.impl;

import com.qiamfeng.nanny.entity.Administrators;
import com.qianfeng.nanny.dao.LoginDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class LoginDaoImpl implements LoginDao {

	//Ð´µÇÂ¼¹¦ÄÜ
	@Override
	public Administrators Login(String username, String password) {
		// TODO Auto-generated method stub
		 return JdbcUtils.queryOne(Administrators.class,"select * from administrators where username = ? "
		 		+ "and password = ?" ,username,password);
	}

}
