package TestsWithJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
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

		//mapping sql data to object
		while(rs.next()){ //set the pointer here
            CustomerDetails customer = new CustomerDetails();

			customer.setCourseName(rs.getString(1));
			customer.setPurchaseDate(rs.getString(2));
			customer.setAmount(rs.getInt(3));
			customer.setLocation(rs.getString(4));
			custArr.add(customer);
		}

		//adding data in json format to JSONArray object
		ObjectMapper o = new ObjectMapper();
		for(int i=0;i<custArr.size();i++){
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

		String unescapeString = StringEscapeUtils.unescapeJava(jsonObject.toJSONString());
		System.out.println("wihtout \" :"+unescapeString);
		String step1 = unescapeString.replace("\"{","{");
		String finalString = step1.replace("}\"","}");;
		System.out.println("this is final string: " +finalString);

		FileWriter file = new FileWriter("//Users//home//Documents//" +
				"Test-architecture//src//main//java//Resources//CustomerDetail.json");
		file.write(finalString);
		file.close();
		conn.close();

		//convert json back to java object using Jackson
		CustomerDetails deatailsJson = o.readValue(new File("//Users//home//Documents//" +
				"Test-architecture//src//main//java//Resources//CustomerDetail0.json"),CustomerDetails.class);
		System.out.println(deatailsJson.getPurchaseDate());

		DetailsData det = o.readValue(new File("//Users//home//Documents//" +
				"Test-architecture//src//main//java//Resources//CustomerDetail.json"),DetailsData.class);
		System.out.println(det.getData());


	}

}
