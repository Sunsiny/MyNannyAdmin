package com.qianfeng.nanny.dao;

import java.util.List;

import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;
import com.qiamfeng.nanny.entity.User;

public interface NannyDao {
	public List<Nanny> SelectAllNanny();
	public void DeleteNanny(int id);
	public int AddNanny(Nanny nanny);
	//��ѯ��������
	public int selectNannyCount();
	//���ݵ�ÿһҳ����ʼ���ݣ�ÿһҳ����������
	List<Nanny> selectNannyLimit(int start,int length);
	//�鱣ķ��������
	List<NannyWorkDTO> SelectNannyWorks();
}
