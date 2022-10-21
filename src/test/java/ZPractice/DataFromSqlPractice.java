package ZPractice;
/*package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class DataFromSqlPractice {

	public static void main(String[] args) throws SQLException {
		Driver driref=new Driver();
		DriverManager.registerDriver(driref);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement sta=(Statement) con.createStatement();
		String querry="select * from student";
		ResultSet result = sta.executeQuery(querry);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getInt(5));
		}
	}

}*/
