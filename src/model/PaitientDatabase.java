package model;

import java.util.ArrayList;
import java.util.List;

public class PaitientDatabase {

	private ArrayList<Paitient> paitientData;

	public PaitientDatabase() {

		paitientData =  new ArrayList<Paitient>();
	}
	
	public void addPaitient(Paitient paitient){
		
		paitientData.add(paitient);
	}
	
	public List<Paitient> getPaitient(){
		
		return paitientData;
	}
}
