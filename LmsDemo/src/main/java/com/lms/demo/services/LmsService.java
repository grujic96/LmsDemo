package com.lms.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.models.Book;
import com.lms.demo.models.BookGenre;
import com.lms.demo.repositories.LmsRepository;


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
	
	public Collection<Book> findByAuthor(String author){
		List<Book> books = new ArrayList<Book>();
		for(Book b : lmsRepository.findAll()) {
			if (b.getAuthor().contains(author)){
				books.add(b);
			}
		}
		
		return books;
	}
	
	
	public void save(Book book) {
		lmsRepository.save(book);
	}
	
	public void delete(int id) {
		lmsRepository.deleteById(id);
	}
	
}
