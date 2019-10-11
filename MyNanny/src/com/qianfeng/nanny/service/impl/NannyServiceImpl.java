package com.qianfeng.nanny.service.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;
import com.qiamfeng.nanny.entity.Page;
import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.dao.NannyDao;
import com.qianfeng.nanny.dao.impl.NannyDaoImpl;
import com.qianfeng.nanny.service.NannyService;

public class NannyServiceImpl implements NannyService {
	NannyDao nannydao = new NannyDaoImpl();
	@Override
	public List<Nanny> SelectAllNanny() {
		// TODO Auto-generated method stub
		return nannydao.SelectAllNanny();
	}
	
	@Override
	public Page<Nanny> selectNannyPage(int currentPage) {
		// TODO Auto-generated method stub
		//��ѯ������
				int count = nannydao.selectNannyCount();
				//System.out.println("�����ݣ�"+count);
				//������ܵ�ҳ��
				int pageCount = count % Page.PAGE_SIZE == 0 ? count / Page.PAGE_SIZE : count / Page.PAGE_SIZE+1;
			//	System.out.println("�ܵ�ҳ����"+pageCount);
				//ͨ����ǰҳ��ִ�з�ҳ��ѯ
				List<Nanny> data = nannydao.selectNannyLimit((currentPage-1)*Page.PAGE_SIZE,
						Page.PAGE_SIZE);
				//System.out.println("data"+data);
				//����ҳ������ǰҳ�������ݼ��ϰ�װ��Page������
				Page<Nanny> page = new Page<>();
				page.setCurrentPage(currentPage);
				page.setPageCount(pageCount);
				page.setData(data);
				//����Page����
				return page;
	}

	@Override
	public void DeleteNanny(int id) {
		// TODO Auto-generated method stub
		nannydao.DeleteNanny(id);
	}

	@Override
	public int AddNanny(Nanny nanny) {
		// TODO Auto-generated method stub
		return nannydao.AddNanny(nanny);
	}

	@Override
	public List<NannyWorkDTO> SelectNannyWorks() {
		// TODO Auto-generated method stub
		return nannydao.SelectNannyWorks();
	}
	
}
