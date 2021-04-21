package lab3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Console {
	private Service s;//variabila ce retine serviceul folosit
	
	public Console() { // constructor implicit
		this.s = new Service();
	}
	
	public Console(Service s) { // constructor explicit
		this.s = s;
	}
	
	public static void showMenu() { // metoda statica ce afiseaza meniul programului
		System.out.println("1. Adaugati carbune");
		System.out.println("2. Ordonati alfabetic dupa tara de origine");
		System.out.println("3. Ordonati descrescator dupa importul lunar");
		System.out.println("4. Iesire");
		System.out.print("Optiune: " );
	}
	
	private void handleInput() { // metoda ce se ocupa cu citirea unui carbun
		//prin elementele sale
		try {
			Scanner s = new Scanner(System.in);
			System.out.print("Introduceti tara de origine: ");
			String country = s.next();
			System.out.print("Introduceti importul lunar: ");
			long monthlyImport = s.nextLong();
			this.s.addElem(country, monthlyImport);
			System.out.println();
		}
		catch(InputMismatchException ime) {
			System.out.println("Introduceti o valoarea intreaga pentru import!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void handleLexicographicSort() {
		//metoda ce afiseaza tabelul pentru ordonarea alfabetica
		//dupa tara a carbunilor
		try {
			Vector<Coal> val = this.s.sortByCountry();
			System.out.println("+--------------------+---------------+");
			System.out.println("|     Nume Tara      |  Import lunar |");
			System.out.println("+--------------------+---------------+");
			String alignment = "| %-18s | %13s |\n";
			for(int i = 0; i < val.size(); i++)
				System.out.format(alignment, val.get(i).getCountry(), String.valueOf(val.get(i).getMonthlyImport()));
			System.out.println("+--------------------+---------------+");	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void handlePercentages() { // metoda ce afiseaza tabelul cu procentaje
		//descrescator dupa importul lunar
		try {
			Vector<Pair<Coal, String>> val = this.s.getPercentages();
			System.out.println("+--------------------+---------------+-------------------------+");
			System.out.println("|     Nume Tara      |  Import lunar | Proc. din total carbune |");
			System.out.println("+--------------------+---------------+-------------------------+");
			String alignment = "| %-18s | %13s | %23s |\n";
			for(int i = 0; i < val.size(); i++)
				System.out.format(alignment, val.get(i).first().getCountry(), String.valueOf(val.get(i).first().getMonthlyImport()),
						val.get(i).second());
			System.out.println("+--------------------+---------------+-------------------------+");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void run() { // metoda ce pune cap la cap toate metodele de mai sus
		String opt = "";
		Scanner s = new Scanner(System.in);
		showMenu();
		opt = s.next();
		while(!opt.equals("4")) {
			if(opt.equals("1"))
				this.handleInput();
			else if(opt.equals("2"))
				this.handleLexicographicSort();
			else if(opt.equals("3"))
				this.handlePercentages();
			else
				System.out.println("Optiune invalida!");
			showMenu();
			opt = s.next();
		}
		s.close();
		this.s.saveToFile();
	}
}
