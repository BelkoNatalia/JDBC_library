package by.htp.library.dao;

import java.util.List;

import by.htp.library.book.Book;

public interface BookDao {
	Book read(int id);

	List<Book> list();

	void add(Book book);

	void delete(Book book);

	void update(Book book);
}
