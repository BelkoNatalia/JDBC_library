package by.htp.library.dao;

import java.util.List;

import by.htp.library.book.Autor;

public interface AutorDao {
	
	Autor readById(int id);
	
	List<Autor> getAutors();
	
	void addAutor(Autor autor);
	
	void deliteAutor(Autor autor);
	
	
	void updateAutor(Autor autorCurrent, Autor autorNew);
	
}
