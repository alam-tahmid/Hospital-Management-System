import model.PaitientDatabase;


public class TestDataBase {

	public static void main(String[] args) {

		System.out.println("Running Database test");

		PaitientDatabase db = new PaitientDatabase();
		try {

			db.connect();

		} catch (Exception e) {

			System.out.println("could not run");
		}

		db.disconnect();
	}
}
