package com.sam.app.services.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.sam.app.services.model.User;

public interface UserRepo extends CrudRepository<User, BigInteger> {

}
