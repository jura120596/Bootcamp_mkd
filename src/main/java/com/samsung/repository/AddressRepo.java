package com.samsung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsung.entity.Address;
import com.samsung.entity.Role;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
