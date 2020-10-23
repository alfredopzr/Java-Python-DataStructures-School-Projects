import java.util.StringTokenizer;

//Building up from the MVPolyTerm class and DLList class, MVPolynomial is composed of two
//private fields:
//1. The name of the polynomial
//2. A doubly linked list of MVPolyTerms.
//MVPolynomial class should have proper constructors, getters, setters, and other useful methods
//if needed.
public class MVPolynomial extends DLList {
	private DLList<MVPolyTerm> terms;
	public String polyName = "";
	
	//input is everything after the command (name and numbers)
	public MVPolynomial(String input) {
		
		StringTokenizer str = new StringTokenizer(input);
		String polyName = str.nextToken();
//		String numbers = input.substring(input.indexOf(" "), input.indexOf(" "));
		
		while(str.hasMoreTokens()) {
			StringTokenizer str2 = new StringTokenizer(str.nextToken());
			String coeff = str2.nextToken();
			String xExp = str2.nextToken();
			String yExp = str2.nextToken();
			String zExp = str2.nextToken();
			MVPolyTerm tempTerm = new MVPolyTerm(coeff, xExp, yExp, zExp);
			this.insertLast(tempTerm);
		}	
	}

	public String getName() {
		return polyName;
	}

    public String toString() {
    	return null;
    	//Still have to do
    }
    
    public void addNode(String inp) {
    	
    }
    
    
}
