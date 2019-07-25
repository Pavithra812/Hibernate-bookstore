package com.niit.Bookstore.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.niit.Bookstore.config.Hibernateconfig;
import com.niit.Bookstore.model.Book;

public class Bookimplement implements Bookdao {
	SessionFactory sessionFactory;

	@Override
	public boolean addBook(Book b) {
		try {
			sessionFactory = Hibernateconfig.createSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction txt = s.beginTransaction();
			s.save(b);
			txt.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBook(Book b) {
		try {
			sessionFactory = Hibernateconfig.createSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction txt = s.beginTransaction();
			s.update(b);
			txt.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBook(Book b) {
		try {
			sessionFactory = Hibernateconfig.createSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction txt = s.beginTransaction();
			s.delete(b);
			txt.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Book selectOneBook(String bookname) {
		try {
			sessionFactory = Hibernateconfig.createSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction txt = s.beginTransaction();
			Book b = (Book) s.createQuery("from Book where bookname='" + bookname + "'").uniqueResult();
			txt.commit();
			s.close();
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Book> selectAll() {
		try {
			sessionFactory = Hibernateconfig.createSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction txt = s.beginTransaction();
			List<Book> b = s.createQuery("from Book").list();
			txt.commit();
			s.close();
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	

	public void name() {

	}
}