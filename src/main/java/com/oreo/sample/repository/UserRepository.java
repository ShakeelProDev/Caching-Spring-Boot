package com.oreo.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreo.sample.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
