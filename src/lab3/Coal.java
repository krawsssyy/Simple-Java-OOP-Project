package lab3;

public class Coal {
	private String country;//variabila ce retine tara de origine a carbunelui
	private long monthlyImport;//variabile ce retina importul lunar al acelui carbune
	
	public Coal() { // constructor implicit
		this.country = "";
		this.monthlyImport = 0;
		}
	
	public Coal(String c, long m) { // constructor explicit
		this.country = c;
		this.monthlyImport = m;
	}
	
	public String getCountry() { // getter pentru tara de origine
		return this.country;
	}
	
	public long getMonthlyImport() { // getter pentru importul lunar
		return this.monthlyImport;
	}
	
	public String toString() { // metoda ce returneaza un string formatat pentru
		//salvarea in fisier .CSV
		return this.country + "," + String.valueOf(this.monthlyImport);
	}
	
}
