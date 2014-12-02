package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class PaitientDatabase {


	private Connection con;
	private Statement stmt;
	private String Url;
	private String dbName;
	private String createTableSQL;
	private List<Paitient> paitientData;

	private String FName;
	private String LName;
	private String occupation;
	private String gen;
	private String Email;
	private String phone;
	private String adr;
	private String age;


	public String getAge() {
		return age;
	}

	public String getFName() {
		return FName;
	}

	public String getLName() {
		return LName;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getGen() {
		return gen;
	}

	public String getEmail() {
		return Email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAdr() {
		return adr;
	}

	public PaitientDatabase() {

		paitientData =  new LinkedList<Paitient>();
	}

	public void addPaitient(Paitient paitient){

		paitientData.add(paitient);
	}

	public List<Paitient> getPaitient(){

		return Collections.unmodifiableList(paitientData);
	}

	public void connect() throws Exception{

		if(con!= null){

			return;
		}

		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {

			throw new Exception("Driver not found");
		}

		dbName = "PaitientDatabase";
		Url= "jdbc:derby:" + dbName + ";create=true";
		con = DriverManager.getConnection("jdbc:derby:" + dbName + ";create=true");

	}

	public void disconnect(){

		if(con!=null){

			try {

				con.close();
			} catch (SQLException e) {

				System.out.println("Cannot close connection");
			}
		}
	}

	public void save() throws SQLException{

		String checkSQL= "Select count(*) as count from paitient where id =?";

		PreparedStatement checkStmt = con.prepareStatement(checkSQL);

		String insertSQL ="insert into paitient(ID, FIRST_NAME, LAST_NAME,OCCUPATION,AGE, ADDRESS, PHONE, EMAIL,GENDER) values(?,?,?,?,?,?,?,?,?) ";

		String updateSQL ="UPDATE paitient set FIRST_NAME=?, LAST_NAME=?,OCCUPATION=? ,AGE=? ,ADDRESS=?, PHONE=?, EMAIL=?, GENDER=? where ID =? ";


		PreparedStatement insertStatement = con.prepareStatement(insertSQL);
		PreparedStatement updateStatement = con.prepareStatement(updateSQL);

		for (Paitient paitient : paitientData) {

			int id = paitient.getId();
			String firstName = paitient.getFirstName();
			String lastName = paitient.getLastName();
			String age = paitient.getAge();
			String gender = paitient.getGender().name();
			String occupation = paitient.getOccupation();
			String address = paitient.getAddress();
			String email = paitient.getEmail();
			String phone = paitient.getPhone();

			checkStmt.setInt(1, id);

			ResultSet checkResult=checkStmt.executeQuery();

			checkResult.next();

			int count =checkResult.getInt(1);

			if(count == 0){

				System.out.println("inserting person with id "+ id);

				int col = 1;

				insertStatement.setInt(col++,id);
				insertStatement.setString(col++, firstName);
				insertStatement.setString(col++, lastName);
				insertStatement.setString(col++, occupation);
				insertStatement.setString(col++, age);
				insertStatement.setString(col++, address);
				insertStatement.setString(col++, phone);
				insertStatement.setString(col++, email);
				insertStatement.setString(col++, gender);
				insertStatement.executeUpdate();

			} else {

				System.out.println("updating person with id "+ id);

				int col = 1;


				updateStatement.setString(col++, firstName);
				updateStatement.setString(col++, lastName);
				updateStatement.setString(col++, occupation);
				updateStatement.setString(col++, age);
				updateStatement.setString(col++, address);
				updateStatement.setString(col++, phone);
				updateStatement.setString(col++, email);
				updateStatement.setString(col++, gender);
				updateStatement.setInt(col++,id);

				updateStatement.executeUpdate();
			}
		}

		updateStatement.close();
		insertStatement.close();
		checkStmt.close();
	}

	public void load() throws SQLException{

		paitientData.clear();

		String sql ="select ID, FIRST_NAME, LAST_NAME,OCCUPATION,AGE, ADDRESS, PHONE, EMAIL,GENDER from paitient order by ID";
		Statement selectStatement = con.createStatement();

		ResultSet results =selectStatement.executeQuery(sql);

		while(results.next()){

			int id = results.getInt("ID");
			String firstName = results.getString("FIRST_NAME");
			String lastName = results.getString("LAST_NAME");
			String occupation = results.getString("OCCUPATION");
			String age = results.getString("AGE");
			String address = results.getString("ADDRESS");
			String phone = results.getString("PHONE");
			String email = results.getString("EMAIL");
			String gender = results.getString("GENDER");


			Paitient person = new Paitient(id,firstName,lastName,occupation,age,address,phone,email,Gender.valueOf(gender));
			paitientData.add(person);
			//System.out.println(paitient.toString());
		}

		results.close();
		selectStatement.close();
	}

	public void saveToFile(File file) throws IOException{

		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Paitient[] paitient = paitientData.toArray(new Paitient[paitientData.size()]);

		oos.writeObject(paitient);

		oos.close();
	}

	public void loadFromFile(File file) throws IOException{

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {

			Paitient [] paitient = (Paitient[])ois.readObject();

			paitientData.clear();
			paitientData.addAll(Arrays.asList(paitient));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ois.close();
	}

	public void removePaitient(int index){

		paitientData.remove(index);
	}

	public void search(int id ) throws SQLException {

		PreparedStatement st = con.prepareStatement("select * from paitient where id=?");
		st.setInt(1, id);

		//Excuting Query
		ResultSet rs = st.executeQuery();

		if (rs.next()) {

			FName = rs.getString("FIRST_NAME");
			LName = rs.getString("LAST_NAME");
			occupation = rs.getString("OCCUPATION");
			age = rs.getString("AGE");
			adr = rs.getString("ADDRESS");
			phone = rs.getString("PHONE");
			Email = rs.getString("EMAIL");
			gen = rs.getString("GENDER");

			System.out.println("Firstname: "+ FName);

		}
		rs.close();
		st.close();
	}

	/////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////


	public void query() throws SQLException{

		String sql_statement = "select * from paitient ";
		con = DriverManager.getConnection(Url);
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql_statement);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();

		for(int x= 1; x<=columnCount; x++){

			System.out.print(resultSetMetaData.getColumnName(x)+" | "+"\t");
		}
		while(resultSet.next()){

			System.out.println();

			for(int x =1; x<=columnCount; x++){

				System.out.print(resultSet.getString(x)+" | ");
			}
		}

		if(statement!=null){

			statement.close();
		}

		if(con!=null){

			con.close();
		}
	}

	public void createTable() throws Exception{

		if(con!= null){

			return;
		}

		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			///// creating the table

		} catch (ClassNotFoundException e) {

			throw new Exception("Driver not found");
		}

		dbName = "PaitientDatabase";
		Url= "jdbc:derby:" + dbName + ";create=true";
		con = DriverManager.getConnection("jdbc:derby:" + dbName + ";create=true");

		createTableSQL = "CREATE TABLE paitient("
				+ "ID INTEGER NOT NULL, "
				+ "FIRST_NAME VARCHAR(55) NOT NULL, "
				+ "LAST_NAME VARCHAR(55) NOT NULL, "
				+ "OCCUPATION VARCHAR(55) NOT NULL, "
				+ "AGE VARCHAR(10) NOT NULL, "
				+ "ADDRESS VARCHAR(255) NOT NULL, "
				+ "PHONE VARCHAR(20) NOT NULL, "
				+ "EMAIL VARCHAR(255) NOT NULL, "
				+ "GENDER VARCHAR(6) NOT NULL, "
				+ "PRIMARY KEY (ID) "
				+ ")";

		stmt = con.createStatement();
		stmt.executeUpdate(createTableSQL);
	}
}

