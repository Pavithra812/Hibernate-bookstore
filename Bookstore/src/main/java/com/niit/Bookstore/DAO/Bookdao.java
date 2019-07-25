package com.niit.Bookstore.DAO;


import java.util.List;

import com.niit.Bookstore.model.Book;

public interface Bookdao {
	boolean addBook(Book b);

	boolean updateBook(Book b);

	boolean deleteBook(Book b);

	Book selectOneBook(String bookname);

	List<Book> selectAll();

}
