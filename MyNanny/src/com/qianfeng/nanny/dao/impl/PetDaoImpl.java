package com.qianfeng.nanny.dao.impl;

import java.util.List;

import com.qiamfeng.nanny.entity.Pet;
import com.qianfeng.nanny.dao.PetDao;
import com.qianfeng.nanny.util.JdbcUtils;

public class PetDaoImpl implements PetDao {

	@Override
	public List<Pet> SelectAllPet() {
		// TODO Auto-generated method stub
		return JdbcUtils.queryList(Pet.class,"select * from pet");
	}

	@Override
	public int AddPet(Pet pet) {
		// TODO Auto-generated method stub
		return JdbcUtils.Update("insert into pet values(null,?,?,?,?)",
				pet.getName(),
				pet.getType(),
				pet.getAge(),
				pet.getImage()
				);
	}

	@Override
	public Pet SelectPetByName(String name) {
		// TODO Auto-generated method stub
		return JdbcUtils.queryOne(Pet.class,"select * from pet where name = ?", name);
	}

}
