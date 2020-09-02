package com.rab3tech.admin.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.Role;

public interface RolesRepository extends JpaRepository<Role, Integer> {
}

