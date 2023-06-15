package com.springboot.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.restfulwebservices.user.User;

public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
