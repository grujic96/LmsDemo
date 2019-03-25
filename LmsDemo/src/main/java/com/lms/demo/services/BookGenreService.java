package com.lms.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.models.BookGenre;
import com.lms.demo.repositories.BookGenreRepository;

@Service
public class BookGenreService {
	
	@Autowired
	BookGenreRepository bookGenreRepository;
	
	
	public Collection<BookGenre> getAllGenres() {
		List<BookGenre> bookGenres = new ArrayList<BookGenre>();
		
		for(BookGenre bG : bookGenreRepository.findAll())
			bookGenres.add(bG);
		return bookGenres;
	}


	public BookGenre getGenreByName(String name) {
		BookGenre bookGenre = new BookGenre();
		
		for(BookGenre bG : bookGenreRepository.findAll())
			if (bG.getBookGenre().equals(name)){
				bookGenre = bG;
				}
		return bookGenre;
	}
}
