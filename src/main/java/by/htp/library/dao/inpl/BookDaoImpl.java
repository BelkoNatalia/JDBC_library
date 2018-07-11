package by.htp.library.dao.inpl;

import static by.htp.library.dao.util.MySqlPropertyManager.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.book.Autor;
import by.htp.library.book.Book;
import by.htp.library.dao.BookDao;

public class BookDaoImpl implements BookDao {

	private static final String SELECT_BOOK_BYID = "SELECT * FROM book WHERE id_book = ?";
//	private static final String SELECT_ALL_BOOK = "SELECT * FROM book ";
	private static final String SELECT_ALL_BOOK = "SELECT title,name,surname,birsdate FROM book, authors WHERE author=authors.id_author";

	// SELECT title,name,surname,birsdate FROM book, authors WHERE author=authors.id_author;
 

	@Override
	public Book read(int id) {

		Book book = null;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {

			PreparedStatement ps = conn.prepareStatement(SELECT_BOOK_BYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = buildBook(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public List<Book> list() {
		
		List <Book> listAllBooks = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(SELECT_ALL_BOOK);
//			while(result.next()) {
//				String name = result.getString(2);
//				String surname = result.getString(3);
//				String date = result.getDate(4);
//				
//				Autor a = new Autor(name, surname, date);
//				Book b = new Book("afa", a);
//				System.out.println(result.getString(2) + ":" + result.getString(3));
//			}
//			PreparedStatement psAllBook = conn.prepareStatement(SELECT_ALL_BOOK);
		
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
//		for (String s: listAllBooks){
//			System.out.println(s);
		return listAllBooks;
	}

	@Override
	public int add(Book book) {
		return 0;
	}

	@Override
	public void delete(Book book) {

	}

	@Override
	public void update(Book book) {

	}

	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setTitle(rs.getString("title"));
		// setAutor
		return book;
	}

}
