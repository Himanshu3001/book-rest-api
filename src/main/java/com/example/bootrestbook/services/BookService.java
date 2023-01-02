package com.example.bootrestbook.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bootrestbook.dao.BookRepository;
import com.example.bootrestbook.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list=new ArrayList<>();
//
//	static {
//		list.add(new Book(1,"Java","James"));
//		list.add(new Book(2,"C","Newton"));
//		list.add(new Book(3,"C++","Himu"));
//	}
	
	public List<Book> getAllBooks(){
		List<Book> book= (List<Book>) this.bookRepository.findAll();
		return book;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		try {
			//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepository.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	public Book addBook(Book b) {
		//list.add(b);
		Book result = bookRepository.save(b);
		return result;
	}
	
	public void deleteBook(int bid) {
		
//		list=list.stream().filter(book->{
//			if(book.getId()!=bid) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		bookRepository.deleteById(bid);
	}
	
	public void updateBook(Book book,int id) {
//		list = list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookRepository.save(book);
	}
}
