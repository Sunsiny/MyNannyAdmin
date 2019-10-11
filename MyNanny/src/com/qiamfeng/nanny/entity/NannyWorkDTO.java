package com.qiamfeng.nanny.entity;

public class NannyWorkDTO {
	//Í¼±í
		private  String nannyname;
		private  String workcount;
		
		
		@Override
		public String toString() {
			return "NannyWorkDTO [nannyname=" + nannyname + ", workcount=" + workcount + "]";
		}
		public NannyWorkDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public NannyWorkDTO(String nannyname, String workcount) {
			super();
			this.nannyname = nannyname;
			this.workcount = workcount;
		}
		public String getNannyname() {
			return nannyname;
		}
		public void setNannyname(String nannyname) {
			this.nannyname = nannyname;
		}
		public String getWorkcount() {
			return workcount;
		}
		public void setWorkcount(String workcount) {
			this.workcount = workcount;
		}
		
		
		
		
}
