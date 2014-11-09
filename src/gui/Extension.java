package gui;

public class Extension {

	public String extension(String name){

		int index = name.lastIndexOf(".");
		if(index ==-1){

			return null;
		}
		if(index == name.length()){

			return null;
		}

		return name.substring(index+1,name.length()-1);
	}
}
