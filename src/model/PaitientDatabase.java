package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PaitientDatabase {


	private Connection con;
	private List<Paitient> paitientData;

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

		String dbName = "PaitientDatabase";
		String Url= "jdbc:derby:" + dbName + ";create=true";
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
}
