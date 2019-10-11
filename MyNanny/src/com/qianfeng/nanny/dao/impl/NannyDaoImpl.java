package com.qianfeng.nanny.dao.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;

import com.qianfeng.nanny.dao.NannyDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class NannyDaoImpl implements NannyDao{

	@Override
	public List<Nanny> SelectAllNanny() {
		// TODO Auto-generated method stub
		return JdbcUtils.queryList(Nanny.class,"select * from tb_nanny");
	}
	//数据总数
	@Override
	public int selectNannyCount() {
		// TODO Auto-generated method stub
		return JdbcUtils.queryCount("select count(*) from tb_nanny");
	}
	
	@Override
	public List<Nanny> selectNannyLimit(int start, int length) {
		// TODO Auto-generated method stub
		return JdbcUtils.queryList(Nanny.class, 
				"select * from tb_nanny limit ?,?",
				start,length);
	}
	//保姆工作
	@Override
	public List<NannyWorkDTO> SelectNannyWorks() {
		// TODO Auto-generated method stub
		return  JdbcUtils.queryList(NannyWorkDTO.class,"SELECT n.name nannyname,count(*) workcount from tb_nanny n,tb_work w where n.nanny_id=w.nanny_id GROUP BY n.nanny_id;");
//	System.out.println("list1:"+list1);
	
	
	}
	@Override
	public void DeleteNanny(int id) {
		// TODO Auto-generated method stub
		JdbcUtils.Update("delete from tb_nanny where nanny_id = ?", id);
	}
	//增
	@Override
	public int AddNanny(Nanny nanny) {
		// TODO Auto-generated method stub
		return JdbcUtils.Update("insert into tb_nanny values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				nanny.getName(),
				nanny.getAge(),
				nanny.getGender(),
				nanny.getTel(),
				nanny.getSalary(),
				nanny.getMonths(),
				nanny.getEdu(),
				
				nanny.getPlace(),
				
				nanny.getAddress(),
				
				nanny.getPicture(),
				
				nanny.getWork_days(),
				nanny.getPhraise(),
				nanny.getAppointments(),
				nanny.getPid(),
				nanny.getNanny_type_id(),
				nanny.getNation(),
				nanny.getMarrital(),
				nanny.getZodiac(),
				nanny.getCurrent_city(),
				nanny.getTarget_city(),
				nanny.getStatus(),
				nanny.getId_picture()
				);
	}

}
