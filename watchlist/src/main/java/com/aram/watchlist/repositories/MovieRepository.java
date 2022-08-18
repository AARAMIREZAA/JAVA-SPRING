package com.aram.watchlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aram.watchlist.models.Movie;
import com.aram.watchlist.models.User;



@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	List<Movie> findAll();
	Movie findByIdIs(Long id);
	List<Movie> findAllByCreatorOrderByYearAsc(User user);
	List<Movie> findAllByOrderByYearAsc();
	List<Movie> findByTitleContaining(String search);
 }