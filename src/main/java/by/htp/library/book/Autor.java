package by.htp.library.book;

import java.util.Calendar;
import java.util.Date;

public class Autor {
	private String name;
	private String surname;
	private Date birsdate;
	public Autor() {
		super();
	}
	public Autor(String name, String surname, Date birsdate) {
		super();
		this.name = name;
		this.surname = surname;
		this.birsdate = birsdate;
	}
	
	
	public Date getBirsdate() {
		return birsdate;
	}
	public void setBirsdate(Date birsdate) {
		this.birsdate = birsdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Autor [name=" + name + ", surname=" + surname + ", birsdate="
				+ birsdate + "]";
	}
	

}
