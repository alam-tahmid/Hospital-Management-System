package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DoctorDatabase {

	private List<Doctor> doctorData;

	public DoctorDatabase() {

		doctorData =  new LinkedList<Doctor>();
	}

	public void addPaitient(Doctor Doctor){

		doctorData.add(Doctor);
	}

	public List<Doctor> getPaitient(){

		return Collections.unmodifiableList(doctorData);
	}

	public void connect() throws Exception{

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			throw new Exception("org.apache.derby.jdbc.EmbeddedDriver");
		}

		String dbName = "DoctorDatabase";

		String Url= "jdbc:derby:" + dbName + ";create=truer";

		Connection con = DriverManager.getConnection(Url,"root","");

	}

	public void disconnect(){


	}

	public void saveToFile(File file) throws IOException{

		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Paitient[] paitient = doctorData.toArray(new Paitient[doctorData.size()]);

		oos.writeObject(paitient);

		oos.close();
	}

	public void loadFromFile(File file) throws IOException{

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {

			Doctor [] doctor = (Doctor[])ois.readObject();

			doctorData.clear();
			doctorData.addAll(Arrays.asList(doctor));

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		ois.close();
	}
	public void removePaitient(int index){

		doctorData.remove(index);
	}
}
