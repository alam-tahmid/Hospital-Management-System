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

public class PaitientDatabase {

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
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			throw new Exception("org.apache.derby.jdbc.EmbeddedDriver");
		}
		
		String dbName = "PaitientDatabase";
		
		String Url= "jdbc:derby:" + dbName + ";create=truer";
		
		Connection con = DriverManager.getConnection(Url,"root","");
		
	}
	
	public void disconnect(){
		
		
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
