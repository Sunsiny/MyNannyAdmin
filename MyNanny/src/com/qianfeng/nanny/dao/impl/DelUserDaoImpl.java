package com.qianfeng.nanny.dao.impl;

import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.DelUserDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class DelUserDaoImpl implements DelUserDao{

	@Override
	public int DelUser(User user) {
		// TODO Auto-generated method stub
		return JdbcUtils.Update("DELETE from tb_user where user_id = ?",user.getUser_id());
	}

}
