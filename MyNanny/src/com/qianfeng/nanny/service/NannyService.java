package com.qianfeng.nanny.service;

import java.util.List;

import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;
import com.qiamfeng.nanny.entity.Page;
import com.qiamfeng.nanny.entity.User;

public interface NannyService {
	public List<Nanny> SelectAllNanny();
	public void DeleteNanny(int id);
	public int AddNanny(Nanny nanny);
	//��ǰҳ
	Page<Nanny> selectNannyPage(int currentPage); 
	//�鱣ķ��������
	List<NannyWorkDTO> SelectNannyWorks();
}
