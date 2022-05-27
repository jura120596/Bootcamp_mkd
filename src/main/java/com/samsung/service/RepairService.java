package com.samsung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samsung.entity.Address;
import com.samsung.entity.ObjectMkd;
import com.samsung.entity.RepairData;
import com.samsung.repository.AddressRepo;
import com.samsung.repository.RepairDataRepo;
import com.samsung.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepairService implements BaseService<RepairData> {
	
	private final RepairDataRepo rr;
	@Override
	public List<RepairData> getAll() {
		return rr.findAll();
	}

	@Override
	public RepairData getById(long id) {
		// TODO Auto-generated method stub
		return rr.getById(id);
	}

	@Override
	public void deleteById(long id) {
		rr.deleteById(id);
		
	}

	@Override
	public void save(RepairData entity) {
		rr.save(entity);
	}
	
	public RepairData getByObject(ObjectMkd o) {
		return rr.findByObject(o);
	}

}
