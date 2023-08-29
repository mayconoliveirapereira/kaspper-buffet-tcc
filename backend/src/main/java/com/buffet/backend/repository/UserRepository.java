package com.buffet.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buffet.backend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}