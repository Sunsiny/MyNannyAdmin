package com.qianfeng.nanny.dao;

import com.qiamfeng.nanny.entity.Administrators;

public interface LoginDao {
	//��¼�ӿ�
	public Administrators Login(String username,String password);
}
