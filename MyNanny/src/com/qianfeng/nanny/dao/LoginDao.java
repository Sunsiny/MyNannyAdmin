package com.qianfeng.nanny.dao;

import com.qiamfeng.nanny.entity.Administrators;

public interface LoginDao {
	//µÇÂ¼½Ó¿Ú
	public Administrators Login(String username,String password);
}
