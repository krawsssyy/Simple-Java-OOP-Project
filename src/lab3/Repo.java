package lab3;
import java.util.Vector;

public class Repo {
	protected Vector<Coal> values; // vector de va retine toti carbunii inserati in program
	
	public Repo() { // constructor implicit
		this.values = new Vector<Coal>();
	}
	
	public void addElem(Coal c) { // metoda ce adauga un carbune in lista
		this.values.add(c);
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Coal> getElems() { // metoda ce returneaza lista de carbuni
		return (Vector<Coal>)this.values.clone();
	}
	
	public int getSize() { // metoda ce returneaza dimensiunea listei de carbuni
		return this.values.size();
	}
	
	protected void clearRepo() { // metoda ce curata toata lista
		this.values.clear();
	}
	
	public void loadFromFile() throws Exception {
		//metoda goala lasata pentru polimorfism cu RepoFile
	}
	
	public void saveToFile() throws Exception {
		// metoda goala lasata pentru polimorfism cu RepoFile
	}
	
}
