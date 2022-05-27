package com.samsung.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.entity.Address;
import com.samsung.entity.ObjectMkd;
import com.samsung.repository.AddressRepo;
import com.samsung.repository.ObjectRepo;
import com.samsung.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectService implements BaseService<ObjectMkd> {

	private final AddressRepo ar;
	private final ObjectRepo or;
	@Override
	public List<ObjectMkd> getAll() {
		return or.findAll();
	}

	@Override
	public ObjectMkd getById(long id) {
		// TODO Auto-generated method stub
		return or.getById(id);
	}

	@Override
	public void deleteById(long id) {
		or.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(ObjectMkd entity) {
		Address a = entity.getAddress();
		if (a.getCreated_at() == null) a.setCreated_at(Date.valueOf(LocalDate.now()));
		entity.setCreated_at(Date.valueOf(LocalDate.now()));
		ar.save(a);
		or.save(entity);
	}

}
