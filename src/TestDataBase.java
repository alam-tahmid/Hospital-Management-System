import java.sql.SQLException;

import model.Gender;
import model.Paitient;
import model.PaitientDatabase;


public class TestDataBase {

	public static void main(String[] args) {

		System.out.println("Running Database test");

		PaitientDatabase db = new PaitientDatabase();
		try {

			db.connect();

		} catch (Exception e) {

			//			System.out.println("could not run");

			e.printStackTrace(); 
		}

		db.addPaitient(new Paitient(131010, "Tahmid", " Alam", " Student",
				" 21", " Cantonment", " 01671892984", " alam.tahmid@gmail.com",
				Gender.male));
		db.addPaitient(new Paitient(131011, "Tamzid", " Alam", " Student",
				" 16", " Cantoment", " 01623274275", " alam.tamzid@live.com",
				Gender.male));
		db.addPaitient(new Paitient(131012, "Naquib", " Chowdhury", " Student",
				" 21", " Niketon", " 0167189", " naquib555@gmail.com",
				Gender.male));
		db.addPaitient(new Paitient(131013, "Maqsud", " Anwar", " Student",
				" 23", " MDpur", " 0181", " maqsud131033@gmail.com",
				Gender.male));
		try {
			
			db.save();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*try {
			db.query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			db.load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.disconnect();
	}
}
