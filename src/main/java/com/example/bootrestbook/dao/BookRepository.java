package com.example.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);

}
