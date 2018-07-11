package by.htp.Lesson16;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class App {
	public static void main(String[] args)

	{
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/belkonat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "belkonat",
					"root");
			System.out.println(connection);
			Statement st = connection.createStatement();
			ResultSet rs=st.executeQuery("select id_book, book.title, pabished.title from book publisher on book.id_publisher=");
			while (rs.next()){
				System.out.println("Book id:" +rs.getInt("id_book")+ "Book title" + rs.getString("title"));
			}
PreparedStatement ps = connection.prepareStatement("select title from publisher where phone = ?");
ps.setString(1, "123");
ResultSet rs2 = ps.executeQuery();
while (rs2.next()){
	System.out.println("Book id:" + rs.getInt("id_book")+
			", title:"+rs.getString("book.title")
					+ " , publisher title:");
}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
