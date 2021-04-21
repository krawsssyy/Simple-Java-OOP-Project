package lab3;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RepoFile extends Repo{ // clasa ce mosteneste repo si implementeaza repofile
	private String char_PATH; // variabila ce retine calea catre fisier
	
	public RepoFile() { // constructor implicit
		super();
		this.char_PATH = "";
	}
	
	public RepoFile(String path) { // constructor explicit
		super();
		this.char_PATH = path;
	}
	
	public void loadFromFile() throws Exception { // metoda ce implementeaza citirea din fisier
		if(this.char_PATH.equals(""))
			throw new Exception("Calea catre fisier este goala!");
		try {
			File myFile = new File(this.char_PATH);
			Scanner s = new Scanner(myFile);
			this.clearRepo();
			while(s.hasNextLine()) {
				String data = s.nextLine();
				String[] splitData = data.split(",");
				Coal e = new Coal(splitData[0], Long.parseLong(splitData[1]));
				this.addElem(e);
			}
			s.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			}
	}
	
	public void saveToFile() throws Exception {//metoda ce implementeaza salvarea in fisier
		if(this.char_PATH.equals(""))
			throw new Exception("Calea catre fisier este goala!");
		try {
			FileWriter myFW = new FileWriter(this.char_PATH);
			for(int i = 0; i < this.getSize(); i++) {
				myFW.write(this.values.get(i).toString() + '\n');
			}
			myFW.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
