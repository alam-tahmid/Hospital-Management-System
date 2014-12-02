package controller;

import gui.FormEvent;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Gender;
import model.Paitient;
import model.PaitientDatabase;

public class Controller {

	public String fname = "";
	public String lname="";
	public String age="";
	public String gender="";
	public String occupation="";
	public String email="";
	public String adr="";
	public String phone="";


	PaitientDatabase db = new PaitientDatabase();

	public List<Paitient> getPaitient(){

		return db.getPaitient();
	}

	public void addPaitient(FormEvent e){

		int id = e.getId();
		String first = e.getFirstName();
		String second = e.getLastName();
		String occupation =  e.getOccupation();
		String age = e.getAge();
		String address = e.getAddress();
		String phone = e.getPhone();
		String email = e.getEmail();
		String gender = e.getGender();

		Gender gen;

		if(gender.equals("Male")){

			gen = Gender.male;
		} else {

			gen = Gender.female;
		}


		Paitient paitient = new Paitient(id,first,second,occupation,age,address,phone,email,gen);

		db.addPaitient(paitient);



		//textPanel.appendText("Name :"+ second +" "+first+"\n"+"Gender: "+gender+"\n"+"Occupation"+occupation+"\n"
		//+"Age: "+age+"\n"+"Adress: "+address+"\n"+"Phone no: "+phone+"\n"+"email: "+email+"\n");

	}

	public void search(int id ) throws SQLException{

		try {
			
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.search(id);
		
		fname = db.getFName();
		lname = db.getLName();
		gender = db.getGen();
		age = db.getAge();
		email = db.getEmail();
		phone = db.getPhone();
		occupation = db.getOccupation();
		adr = db.getAdr();

	}

	public void save() throws SQLException{

		db.save();
	}



	public void connect() throws Exception{

		db.connect();
	}

	public void load() throws SQLException{

		db.load();
	}
	public void disconnect(){

		db.disconnect();
	}
	public void createTable() throws Exception{

		db.createTable();
	}

	public void saveToFile(File file) throws IOException{

		db.saveToFile(file);
	}

	public void LoadFromFile(File file) throws IOException{

		db.loadFromFile(file);
	}

	public void removePatient(int index){

		db.removePaitient(index);
	}
}
