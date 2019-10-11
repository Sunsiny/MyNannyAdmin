package com.qianfeng.nanny.service.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.Pet;
import com.qianfeng.nanny.dao.PetDao;
import com.qianfeng.nanny.dao.impl.PetDaoImpl;
import com.qianfeng.nanny.service.PetService;

public class PetServiceImpl implements PetService {
	PetDao petdao = new PetDaoImpl();
	@Override
	public List<Pet> SelectAllPet() {
		// TODO Auto-generated method stub
		return petdao.SelectAllPet();
	}
	@Override
	public int AddPet(Pet pet) {
		// TODO Auto-generated method stub
		return petdao.AddPet(pet);
	}
	@Override
	public Pet SelectPetByName(String name) {
		// TODO Auto-generated method stub
		return petdao.SelectPetByName(name);
	}

}
