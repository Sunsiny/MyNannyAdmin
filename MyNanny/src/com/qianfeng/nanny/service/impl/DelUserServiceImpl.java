package com.qianfeng.nanny.service.impl;

import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.DelUserDao;
import com.qianfeng.nanny.dao.impl.DelUserDaoImpl;
import com.qianfeng.nanny.service.DelUserService;

public class DelUserServiceImpl implements DelUserService {
	DelUserDao deluser = new DelUserDaoImpl();

	@Override
	public int DelUser(User user) {
		// TODO Auto-generated method stub
		return deluser.DelUser(user);
	}

}
