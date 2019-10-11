package com.qianfeng.nanny.service;

import java.util.List;

import com.qiamfeng.nanny.entity.Pet;

public interface PetService {
	public List<Pet> SelectAllPet();
	public int AddPet(Pet pet);
	public Pet SelectPetByName(String name);
}
