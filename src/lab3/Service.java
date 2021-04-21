package lab3;
import java.text.DecimalFormat;
import java.util.Vector;

public class Service {
	private Repo r;//variabila ce retine repoul utilizat
	
	public Service() { // constructor implicit
		this.r = new Repo();
	}
	
	public Service(Repo re) { // constructor explicit
		this.r = re;
	}
	
	public void addElem(String c, long monthlyImport) { // metoda ce adauga un carbune
		//prin elementele sale in repo
		Coal e = new Coal(c, monthlyImport);
		this.r.addElem(e);
	}
	
	public Vector<Coal> sortByCountry() throws Exception { // Metoda ce foloseste algoritmul de SelectionSort pentru a sorta alfabetic 
		//lista de carbuni dupa numele Tarii de provenienta
		Vector<Coal> values = this.r.getElems();
		if (values.size() == 0)
			throw new Exception("Nu aveti elemente in lista!");
		for(int i = 0; i < values.size() - 1; i++)
			for(int j = i + 1; j < values.size(); j++)
				if(values.get(i).getCountry().compareTo(values.get(j).getCountry()) > 0)
				{
					Coal temp = values.get(i);
					values.set(i, values.get(j));
					values.set(j, temp);
				}
		return values;
		}
	
	public Vector<Coal> sortByImport() { // Metoda ce foloseste algoritmul de BubbleSort pentru a sorta
		//lista de carbuni descrescator dupa importul lunar
		Vector<Coal> values = this.r.getElems();
		boolean sorted = false;
	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < values.size() - 1; i++) {
	            if (values.get(i).getMonthlyImport() < values.get(i + 1).getMonthlyImport()) {
	            	Coal temp = values.get(i);
					values.set(i, values.get(i + 1));
					values.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
		return values;
	}
	
	public Vector<Pair<Coal, String> > getPercentages() throws Exception {//metoda ce construieste
		//un vector cu carbunii si procentajele lor
		Vector<Pair<Coal, String>> v= new Vector<Pair<Coal, String>>();
		Vector<Coal> values = this.sortByImport();
		long total = 0;
		for(Coal c : values)
			total += c.getMonthlyImport();
		for(int i = 0; i < values.size(); i++) {
			Coal curr = values.get(i);
			double percentage = ((double)curr.getMonthlyImport() / (double)total ) * 100.00f;
			DecimalFormat df = new DecimalFormat("#.00");
			String perr = df.format(percentage);
			Pair<Coal, String> p = new Pair<Coal, String>(curr, perr);
			v.add(p);
		}
		System.out.println("Totalul este : " + String.valueOf(total));
		return v;
	}
	
	
	public void saveToFile() {
		try {
			this.r.saveToFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
