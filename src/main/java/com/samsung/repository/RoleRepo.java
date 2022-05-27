package com.samsung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsung.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
