package TestsWithJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppCreateOneJson {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business?serverTimezone=UTC","root","!qazxsw@");
		//object of statement needed to execute queries
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		System.out.println("hi there!");
		List<CustomerDetails> custArr = new ArrayList<CustomerDetails>();
		JSONArray jsonArray = new JSONArray();


		while(rs.next()){ //set the pointer here
            CustomerDetails customer = new CustomerDetails();

			customer.setCourseName(rs.getString(1));
			customer.setPurchaseDate(rs.getString(2));
			customer.setAmount(rs.getInt(3));
			customer.setLocation(rs.getString(4));
			custArr.add(customer);
		}


		for(int i=0;i<custArr.size();i++){
            ObjectMapper o = new ObjectMapper();
            //convert java object to json
            o.writeValue(new File("//Users//home//Documents//Test-architecture//src//main//java//Resources//CustomerDetail"+i+".json"),custArr.get(i));
//create json string from object
			Gson converter = new Gson();
			String sqlDataRow = converter.toJson(custArr.get(i));
			jsonArray.add(sqlDataRow); //object here
        }


		//create one json file with value as an array
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("data",jsonArray);

		System.out.println(jsonObject.toJSONString());



		conn.close();


	}

}
