package com.lms.demo.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.models.Book;


@Service
public class LmsService{

	@Autowired
	private LmsRepository lmsRepository;


	public Collection<Book> findAllBooks(){
		List<Book> books = new ArrayList<Book>();	
		for (Book b : lmsRepository.findAll()) {
			books.add(b);
			System.out.println(b.toString());
		}
		
		return books;
	}
	public Book findBook(int id) {
		Optional<Book> b = lmsRepository.findById(id);
		if(b.isPresent()) {
			return b.get();
		} else
			return null;
		
	}
	
}
