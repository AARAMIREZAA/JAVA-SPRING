package com.aram.watchlist.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aram.watchlist.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmailIs(String email);
	User findByIdIs(Long id);
}