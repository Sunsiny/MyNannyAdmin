package com.qianfeng.nanny.test;

import org.junit.Test;

import com.qianfeng.nanny.util.JdbcUtils;

public class JdbcUtilsTest {
	
	@Test
	public void testInsertUser(){
		for(int i =1;i<=50;i++){
			String username = null;
			String realname =null;
			String address = null;
			String tel = null;
			JdbcUtils.Update("insert into tb_user values(null,?,?,?,?)",username+i,realname+i,address+i,tel+i);
			
		}
	}
}
