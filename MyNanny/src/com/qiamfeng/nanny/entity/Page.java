package com.qiamfeng.nanny.entity;

import java.util.List;

//泛型类
public class Page<T> {
	//每页展示的数据量------5
	public static final int PAGE_SIZE = 10;
	//保存分页的数据
	private List<T> data;
	//页面的数量
	private int pageCount;
	//页面当前页
	private int currentPage;
	
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(List<T> data, int pageCount, int currentPage) {
		super();
		this.data = data;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static int getPageSize() {
		return PAGE_SIZE;
	}
	@Override
	public String toString() {
		return "Page [data=" + data + ", pageCount=" + pageCount + ", currentPage=" + currentPage + "]";
	}

	
	
	
	
	
	
	
}
