package com.niit.Bookstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.niit.Bookstore.DAO.Bookdao;
import com.niit.Bookstore.DAO.Bookimplement;
import com.niit.Bookstore.model.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Bookdao d = new Bookimplement();
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("enter the case:");
		int n = s1.nextInt();

		switch (n) {
		case 1:
			Book e = new Book();
			System.out.println("enter the bookname");
			String bookname = s1.next();
			e.setBookname(bookname);
			System.out.println("enter the bookauthor");
			String authorname = s1.next();

			e.setAuthorname(authorname);
			System.out.println("enter the content");
			String bookcontent = s1.next();
			e.setBookcontent(bookcontent);
			System.out.println("enter the price");
			int bookprice = s1.nextInt();
			e.setPrice(bookprice);

			d.addBook(e);
			break;

		case 2:
			System.out.println("enter the bookname to delete the row");
			String bname = s1.next();
			Book b1 = d.selectOneBook(bname);
			d.deleteBook(b1);
			break;

		case 3:
			System.out.println("enter the booknmae to update the row ");
			String bookname1 = s1.next();
			Book b2 = d.selectOneBook(bookname1);
			System.out.println("enter the price to update");
			int n1 = s1.nextInt();
			b2.setPrice(n1);
			if (d.updateBook(b2))
				break;
		case 4:
			ArrayList<Book> booklist = (ArrayList<Book>) d.selectAll();
			Iterator<Book> iterator = booklist.iterator();
			while (iterator.hasNext()) {
				Book book = (Book) iterator.next();
				System.out.println(book.getBookname() + "\t" + book.getAuthorname() + "\t" + book.getBookcontent()
						+ "\t" + book.getPrice());
			}

		}

	}
}
