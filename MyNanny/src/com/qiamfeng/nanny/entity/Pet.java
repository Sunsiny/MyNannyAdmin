package com.qiamfeng.nanny.entity;

public class Pet {
	private int id;
	private String name;
	private String type;
	private int age;
	private String image;
	
	
	
	
	
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(int id, String name, String type, int age, String image) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", image=" + image + "]";
	}
	
	
	
}
