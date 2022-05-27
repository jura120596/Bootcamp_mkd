package com.samsung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsung.entity.Address;
import com.samsung.entity.Communication;
import com.samsung.entity.ObjectMkd;
import com.samsung.entity.RepairData;
import com.samsung.entity.Role;

public interface CommRepo extends JpaRepository<Communication, Long> {
	Communication findByObject(ObjectMkd o);
}
