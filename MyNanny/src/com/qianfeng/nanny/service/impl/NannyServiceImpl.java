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
		//查询总行数
				int count = nannydao.selectNannyCount();
				//System.out.println("总数据："+count);
				//计算出总的页数
				int pageCount = count % Page.PAGE_SIZE == 0 ? count / Page.PAGE_SIZE : count / Page.PAGE_SIZE+1;
			//	System.out.println("总的页数："+pageCount);
				//通过当前页数执行分页查询
				List<Nanny> data = nannydao.selectNannyLimit((currentPage-1)*Page.PAGE_SIZE,
						Page.PAGE_SIZE);
				//System.out.println("data"+data);
				//把总页数，当前页数，数据集合包装到Page对象中
				Page<Nanny> page = new Page<>();
				page.setCurrentPage(currentPage);
				page.setPageCount(pageCount);
				page.setData(data);
				//返回Page对象
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
