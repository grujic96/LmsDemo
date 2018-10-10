package com.lms.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.demo.models.Book;

@Repository
public interface LmsRepository extends CrudRepository<Book, Integer>{

}
