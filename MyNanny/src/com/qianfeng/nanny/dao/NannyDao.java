package com.qianfeng.nanny.dao;

import java.util.List;

import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;
import com.qiamfeng.nanny.entity.User;

public interface NannyDao {
	public List<Nanny> SelectAllNanny();
	public void DeleteNanny(int id);
	public int AddNanny(Nanny nanny);
	//查询总数据量
	public int selectNannyCount();
	//数据的每一页的起始数据，每一页的数据总数
	List<Nanny> selectNannyLimit(int start,int length);
	//查保姆工作次数
	List<NannyWorkDTO> SelectNannyWorks();
}
