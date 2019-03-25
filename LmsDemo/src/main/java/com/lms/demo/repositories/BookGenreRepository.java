package com.lms.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.demo.models.BookGenre;

@Repository
public interface BookGenreRepository extends CrudRepository<BookGenre, Integer>{

}
