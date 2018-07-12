package by.htp.library.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.htp.library.book.Autor;
import by.htp.library.book.Book;
import by.htp.library.dao.AutorDao;
import by.htp.library.dao.BookDao;
import by.htp.library.dao.inpl.AutorDaoImpl;
import by.htp.library.dao.inpl.BookDaoImpl;

public class MainLibraryController {

	public static void main(String[] args) throws ParseException {
		BookDao bookDao = new BookDaoImpl();
		Book book = bookDao.read(1);
		System.out.println(book);
		bookDao.list();
	
		System.out.println("-----------add Book -----------");
		Book bookForAdd = new Book();
		bookForAdd.setIdAutor(5);
		bookForAdd.setTitle("book_99");
		bookDao.add(bookForAdd);
	
		System.out.println("-----------delite Book -----------");
		Book bookForDel = new Book();
		bookForDel.setIdAutor(5);
		bookForDel.setTitle("book_99");
		bookDao.delete(bookForDel);
		
		System.out.println("-----------update Book -----------");
		Book bookForUpdate = new Book();
		bookForUpdate.setIdAutor(5);
		bookForUpdate.setTitle("new_book1");
		bookForUpdate.setIdBook(1);
		bookDao.update(bookForUpdate);
		
		
		System.out.println("-----------read Autor by id-----------");
		
		
		AutorDao autorDao = new AutorDaoImpl();
		Autor autor = autorDao.readById(3);
		System.out.println(autor);
		
		System.out.println("--------add Author-----");
		String target = "1500-02-20";
	    SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd");
	    Date birsdate =  formatForDate.parse(target);
	    Autor autorForAdd = new Autor("Ina", "Surname", birsdate);
	    autorDao.addAutor(autorForAdd);
	    
	    System.out.println("--------delite Author-----");
	    String targetDel = "1500-02-20";
	    Date birsdateDel =  formatForDate.parse(targetDel);
	    Autor autorForDel = new Autor("Ina", "Surname", birsdateDel);
	    autorDao.deliteAutor(autorForDel);
	    
	    System.out.println("--------update Author-----");
	    
	    String targetCurrent = "1985-10-10";
	    Date birsdateCurrent =  formatForDate.parse(targetCurrent);
	    Autor autorCurrent = new Autor("name", "surname", birsdateCurrent);
	    String targetNew = "1990-11-11";
	    Date birsdateNew =  formatForDate.parse(targetNew);
	    Autor autorNew = new Autor("Sasha", "Uss", birsdateNew);
	    autorDao.updateAutor(autorCurrent, autorNew);
	    
	    System.out.println("--------select Authors-----");
	    List<Autor> myAutors = autorDao.getAutors();
	    for (int i = 0; i < myAutors.size(); i++) {
	    	System.out.println(myAutors.get(i));
		
		}
	}
}