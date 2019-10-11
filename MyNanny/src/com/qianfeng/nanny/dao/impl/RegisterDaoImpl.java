package com.qianfeng.nanny.dao.impl;

import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.RegisterDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public int Insert(User user) {
		// TODO Auto-generated method stub
		return JdbcUtils.Update("insert into tb_user(username,realname,address,tel)VALUES(?,?,?,?)",
				user.getUsername(),
				user.getRealname(),
				user.getAddress(),
				user.getTel()
				);
	}

}
