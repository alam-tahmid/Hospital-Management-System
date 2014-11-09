package gui;
import javax.swing.SwingUtilities;


public class Test {


	public static void main(String[] args) {


		int i = 1;

		if(i ==1){

			SwingUtilities.invokeLater(new Runnable(){

				@Override
				public void run() {

					new LoginFrame();

				}


			});
		}else{


			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new MainFrame();
				}
			});
		}
	}
}



