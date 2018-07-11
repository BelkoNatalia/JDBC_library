package by.htp.library.dao;

import java.util.List;

import by.htp.library.book.Book;

public interface BookDao {
	Book read(int id);

	List<Book> list();

	int add(Book book);

	void delete(Book book);

	void update(Book book);
}
