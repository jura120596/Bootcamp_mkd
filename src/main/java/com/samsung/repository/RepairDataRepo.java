package com.samsung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsung.entity.Address;
import com.samsung.entity.ObjectMkd;
import com.samsung.entity.RepairData;
import com.samsung.entity.Role;

public interface RepairDataRepo extends JpaRepository<RepairData, Long> {
	
	RepairData findByObject(ObjectMkd o);
}
