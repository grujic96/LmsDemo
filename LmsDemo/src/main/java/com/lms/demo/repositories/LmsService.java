package com.lms.demo.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.models.Book;


@Service
public class LmsService{

	@Autowired
	private LmsRepository lmsRepository;


	private Collection<Book> findAllBooks(){
		List<Book> books = new ArrayList<Book>();	
		for (Book b : lmsRepository.findAll()) {
			books.add(b);
		}
		
		return books;
	}
	
}
