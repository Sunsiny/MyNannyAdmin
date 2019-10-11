package com.qianfeng.nanny.test;

import java.util.List;

import org.junit.Test;

import com.qiamfeng.nanny.entity.Nanny;
import com.qianfeng.nanny.service.NannyService;
import com.qianfeng.nanny.service.impl.NannyServiceImpl;

public class NannyTest {
	@Test
	public void SelAllNannyTest(){
		NannyService nannyService = new NannyServiceImpl();
		List<Nanny> nannies = nannyService.SelectAllNanny();
		for(Nanny nanny : nannies){
			System.out.println(nanny);
		}
	}
}
