package com.samsung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samsung.entity.Address;
import com.samsung.entity.Communication;
import com.samsung.entity.ObjectMkd;
import com.samsung.entity.RepairData;
import com.samsung.repository.AddressRepo;
import com.samsung.repository.CommRepo;
import com.samsung.repository.RepairDataRepo;
import com.samsung.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommService implements BaseService<Communication> {
	
	private final CommRepo rr;
	@Override
	public List<Communication> getAll() {
		return rr.findAll();
	}

	@Override
	public Communication getById(long id) {
		// TODO Auto-generated method stub
		return rr.getById(id);
	}

	@Override
	public void deleteById(long id) {
		rr.deleteById(id);
		
	}

	@Override
	public void save(Communication entity) {
		rr.save(entity);
	}
	
	public Communication getByObject(ObjectMkd o) {
		return rr.findByObject(o);
	}

}
