package TestsWithJson;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.databinder.DataApplication;

import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyApplication {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business?serverTimezone=UTC","root","!qazxsw@");
		//object of statement needed to execute queries
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		System.out.println("hi there!");
		List<CustomerDetails> custArr = new ArrayList<CustomerDetails>();


		while(rs.next()){ //set the pointer here
			CustomerDetails customer = new CustomerDetails();
			customer.setCourseName(rs.getString(1));
			customer.setPurchaseDate(rs.getString(2));
			customer.setAmount(rs.getInt(3));
			customer.setLocation(rs.getString(4));
			custArr.add(customer);
		}
		
		ObjectMapper o = new ObjectMapper();
		o.writeValue(new File("//Users//home//Documents//Test-architecture//src//main//java//Resources//customerDetail.json"),customer);
		conn.close();
	}

}
