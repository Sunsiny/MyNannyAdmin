package com.qiamfeng.nanny.entity;

public class Nanny {
	private int nanny_id;
	private String name;
	private int age;
	private String gender;
	private String tel;
	private String salary;
	private int months;
	private String edu;
	private String place;
	private String address;
	private String picture;
	private int work_days;
	private int phraise;
	private int appointments;
	private String pid;
	private int nanny_type_id;
	private String nation;
	private String marrital;
	private String zodiac;
	private String current_city;
	private String target_city;
	private String status;
	private String id_picture;
	
	
	public Nanny() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nanny(int nanny_id, String name, int age, String gender, String tel, String salary, int months, String edu,
			String place, String address, String picture, int work_days, int phraise, int appointments, String pid,
			int nanny_type_id, String nation, String marrital, String zodiac, String current_city, String target_city,
			String status, String id_picture) {
		super();
		this.nanny_id = nanny_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.salary = salary;
		this.months = months;
		this.edu = edu;
		this.place = place;
		this.address = address;
		this.picture = picture;
		this.work_days = work_days;
		this.phraise = phraise;
		this.appointments = appointments;
		this.pid = pid;
		this.nanny_type_id = nanny_type_id;
		this.nation = nation;
		this.marrital = marrital;
		this.zodiac = zodiac;
		this.current_city = current_city;
		this.target_city = target_city;
		this.status = status;
		this.id_picture = id_picture;
	}
	public int getNanny_id() {
		return nanny_id;
	}
	public void setNanny_id(int nanny_id) {
		this.nanny_id = nanny_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getWork_days() {
		return work_days;
	}
	public void setWork_days(int work_days) {
		this.work_days = work_days;
	}
	public int getPhraise() {
		return phraise;
	}
	public void setPhraise(int phraise) {
		this.phraise = phraise;
	}
	public int getAppointments() {
		return appointments;
	}
	public void setAppointments(int appointments) {
		this.appointments = appointments;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getNanny_type_id() {
		return nanny_type_id;
	}
	public void setNanny_type_id(int nanny_type_id) {
		this.nanny_type_id = nanny_type_id;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMarrital() {
		return marrital;
	}
	public void setMarrital(String marrital) {
		this.marrital = marrital;
	}
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}
	public String getCurrent_city() {
		return current_city;
	}
	public void setCurrent_city(String current_city) {
		this.current_city = current_city;
	}
	public String getTarget_city() {
		return target_city;
	}
	public void setTarget_city(String target_city) {
		this.target_city = target_city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId_picture() {
		return id_picture;
	}
	public void setId_picture(String id_picture) {
		this.id_picture = id_picture;
	}
	@Override
	public String toString() {
		return "Nanny [nanny_id=" + nanny_id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel
				+ ", salary=" + salary + ", months=" + months + ", edu=" + edu + ", place=" + place + ", address="
				+ address + ", picture=" + picture + ", work_days=" + work_days + ", phraise=" + phraise
				+ ", appointments=" + appointments + ", pid=" + pid + ", nanny_type_id=" + nanny_type_id + ", nation="
				+ nation + ", marrital=" + marrital + ", zodiac=" + zodiac + ", current_city=" + current_city
				+ ", target_city=" + target_city + ", status=" + status + ", id_picture=" + id_picture + "]";
	}
	
	
	
	
}
