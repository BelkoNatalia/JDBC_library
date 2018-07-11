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
		BookDao dao = new BookDaoImpl();
		Book book = dao.read(1);
		System.out.println(book);
		dao.list();
	
		System.out.println("--------------------------");
		
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