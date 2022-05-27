package com.samsung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samsung.entity.Address;
import com.samsung.repository.AddressRepo;
import com.samsung.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService implements BaseService<Address> {
	
	private final AddressRepo ar;
	@Override
	public List<Address> getAll() {
		return ar.findAll();
	}

	@Override
	public Address getById(long id) {
		// TODO Auto-generated method stub
		return ar.getById(id);
	}

	@Override
	public void deleteById(long id) {
		ar.deleteById(id);
		
	}

	@Override
	public void save(Address entity) {
		ar.save(entity);
	}

}
