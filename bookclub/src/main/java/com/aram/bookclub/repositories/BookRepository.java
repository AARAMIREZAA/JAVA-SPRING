package com.aram.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aram.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

//	Overwrite findAll
	List<Book> findAll();
	
	Optional<Book> findByTitle(String title);
}