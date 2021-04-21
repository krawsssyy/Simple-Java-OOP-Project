package lab3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { // metoda principala a programului
		//Alegerea tipului de repo
		System.out.println("1. Alegeti citirea in consola");
		System.out.println("2. Alegeti citirea din fisier");
		System.out.print("Optiune: ");
		String opt = "";
		Scanner s = new Scanner(System.in);
		opt = s.next();
		//
		
		//Constructia tipului de repo ales
		Repo r = null;
		if(opt.equals("1")) {
			r = new Repo();
			Service serv = new Service(r);
			Console c = new Console(serv);
			c.run();
			}
		else if(opt.equals("2")) {
			System.out.print("Introduceti calea catre fisier: ");
			String char_PATH;
			char_PATH = s.next();
			try {
				//
				boolean bb = Files.isReadable(new File(char_PATH).toPath());
				if(new File(char_PATH).exists() ||  bb == false)
					// empty
					;
				else
					throw new Exception("Fisierul nu exista!");
				//
				r = new RepoFile(char_PATH);
				r.loadFromFile();
				Service serv = new Service(r);
				Console c = new Console(serv);
				c.run();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("Optiune invalida! La revedere.");
			return;
		}
	}
	
}
