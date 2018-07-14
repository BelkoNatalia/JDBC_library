package by.htp.library.dao.inpl;

import static by.htp.library.dao.util.MySqlPropertyManager.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.library.book.Autor;
import by.htp.library.book.Book;
import by.htp.library.dao.BookDao;

public class BookDaoImpl implements BookDao {

	private static final String SELECT_BOOK_BYID = "SELECT * FROM book WHERE id_book = ?";
	// private static final String SELECT_ALL_BOOK = "SELECT * FROM book ";
	private static final String SELECT_ALL_BOOK = "SELECT id_book,title,name,surname,birsdate FROM book, authors WHERE author=authors.id_author";
	private static final String INSERT_BOOK = "INSERT INTO book(title, author) VALUES (?, ?)";
	private static final String DELETE_BOOK = "DELETE FROM book WHERE title = ? AND author = ?";
	private static final String UPDATE_BOOK = "UPDATE book SET title = ?, author = ? WHERE id_book = ?";

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

		List<Book> listAllBooks = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(SELECT_ALL_BOOK);
			while (result.next()) {
				int idBook = result.getInt("id_book");
				String title = result.getString("title");
				String name = result.getString("name");
				String surname = result.getString("surname");
				Date date = result.getDate("birsdate");

				Autor a = new Autor(name, surname, date);
				Book b = new Book();
				b.setAutor(a);
				b.setIdBook(idBook);
				b.setTitle(title);

				listAllBooks.add(b);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listAllBooks;
	}

	@Override
	public void add(Book book) {
		String title = book.getTitle();
		int idAutor = book.getIdAutor();

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(INSERT_BOOK);
			ps.setString(1, title);
			ps.setInt(2, idAutor);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Book book) {
		String title = book.getTitle();
		int idAutor = book.getIdAutor();

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(DELETE_BOOK);
			ps.setString(1, title);
			ps.setInt(2, idAutor);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Book book) {
		int idBook = book.getIdBook();
		String title = book.getTitle();
		int idAutor = book.getIdAutor();

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(UPDATE_BOOK);
			ps.setString(1, title);
			ps.setInt(2, idAutor);
			ps.setInt(3, idBook);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setTitle(rs.getString("title"));
		return book;
	}

}
