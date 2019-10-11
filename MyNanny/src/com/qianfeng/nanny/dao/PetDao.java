package com.qianfeng.nanny.dao;

import java.util.List;

import com.qiamfeng.nanny.entity.Pet;


public interface PetDao {
	public List<Pet> SelectAllPet();
	public int AddPet(Pet pet);
	public Pet SelectPetByName(String name);
}
