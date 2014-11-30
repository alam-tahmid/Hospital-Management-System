package gui;
import java.io.File;

import javax.swing.filechooser.FileFilter;


public class PaitientFileFilter extends FileFilter {
	
	@Override
	public boolean accept(File file) {

		if(file.isDirectory()){
			
			return true;
		}
		String name = file.getName();
		
		
		String exten = Extension.getExtension(name);
		
		if(exten == null){
			
			return false;
		}
		else if(exten.equals("hms")){
			
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		
		return "Paitient database(*.hms)";
	}

}
