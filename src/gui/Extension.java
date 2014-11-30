package gui;

public  class Extension {

	public static String getExtension(String name){

		int index = name.lastIndexOf(".");
		
		
		if(index ==-1){

			return null;
		}
		if(index == name.length()-1){

			return null;
		}

		return name.substring(index+1, name.length());
	}
}
