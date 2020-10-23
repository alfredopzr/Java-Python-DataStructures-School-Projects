import java.util.StringTokenizer;


//Implement a multivariate polynomial table class MVPolyTable, that is a doubly linked list of
//MVPolynomials. This class should implement all the polynomial table operations and all the
//polynomial math operations.

public class MVPolyTable  {
	
	
	//Is this my PolyTable?
	//Doubly Linked list that holds all MVPolynomials
	DLList<MVPolynomial> polynomials = new DLList<MVPolynomial>();
	
	public MVPolyTable() {
		this.polynomials=new DLList<MVPolynomial>();
	}
	
	public void insert(String input) {
//		Insert a new polynomial into the table. If the insert operation is successful, output the
//		polynomial. The insert operation can fail if there is already a polynomial in the table with
//		the same name. In the case of an insertion failure, display the message POLYNOMIAL <name>
//		ALREADY INSERTED.
		
		String polyName = input.substring(0, input.indexOf(" "));
		//STR
		StringTokenizer str = new StringTokenizer(input);
		MVPolynomial temp = new MVPolynomial(input);
		
		//Getting all components of MVPolyTerms from tokenized input string
		while(str.hasMoreTokens()) {
			StringTokenizer str2 = new StringTokenizer(str.nextToken());
			String coeff = str2.nextToken();
			String xExp = str2.nextToken();
			String yExp = str2.nextToken();
			String zExp = str2.nextToken();
			//Hold components and join them to form MVPolyTerms
			MVPolyTerm tempTerm = new MVPolyTerm(coeff, xExp, yExp, zExp);
			//Insert MVPolyTerm at end of temp, a temporary MVPolynomial to hold temporarily
			temp.insertLast(tempTerm);
		}
			
		if(search(polyName) == true) {
			System.out.println("POLYNOMIAL "+ polyName + "ALREADY INSERTED");
		}
		else {
			///temp is then called and inserted at the end of 
			polynomials.insertLast(temp);
		}
    }
	
	public void delete(String input) {
		String polyName = input.substring(0, input.indexOf(" ")); 
		if(search(polyName) == true) {
			//delete at current
			polynomials.deleteAtCurrent();
		}
		else {
			System.out.println("A POLYNOMIAL WITH NAME " + polyName + " DOES NOT EXIST");
		}
	}
	
	public void update(String input) {
		//UPDATE Update an existing polynomial in the table. If it is found in the table, the existing
		//polynomial is replaced by the newly entered one, and output the updated polynomial. If the
		//polynomial does not exist, display the message POLYNOMIAL <name> DOES NOT EXIST.
		String polyName = input.substring(0, input.indexOf(" ")); 
		StringTokenizer str1 = new StringTokenizer(input);
		MVPolynomial temp1 = new MVPolynomial(input);
		
		while(str1.hasMoreTokens()) {
			StringTokenizer str3 = new StringTokenizer(str1.nextToken());
			String coeff = str3.nextToken();
			String xExp = str3.nextToken();
			String yExp = str3.nextToken();
			String zExp = str3.nextToken();
			MVPolyTerm tempTerm1 = new MVPolyTerm(coeff, xExp, yExp, zExp);
			temp1.insertLast(tempTerm1);
		}
		
		if(search(polyName)==true) {
			//existing polynomial is replaced by the newly entered one,
			//and output the updated polynomial
			//delete at current
			//insert at end
			polynomials.deleteAtCurrent();
			polynomials.insertLast(temp1);
		}
		else {
			System.out.println("POLYNOMIAL "+ polyName + " DOES NOT EXIST.");
		}
	}

	public boolean search(String input) {
	//SEARCH Search for a named polynomial in the table. If it is found in the table, output the
	//polynomial. If the polynomial does not exist, display the message POLYNOMIAL <name> DOES
	//NOT EXIST.
		
		//check size
		if(polynomials.size() <= 0) {
			return false;
		}
		
		//check first
		if(polynomials.first() && polynomials.dataRead().getName().equals(input) == true) {
			return true;
		}
		
		while(polynomials.next() == true) {
			if(polynomials.dataRead().getName().equals(input)) {
				System.out.println("POLYNOMIAL "+ input + " EXISTS");
				return true;
			}
		}
		System.out.println("POLYNOMIAL " + input + " DOES NOT EXIST");
		return false;
	}
	
	public void quit() {
		polynomials.clear();
	}
    // If power of 1st polynomial is greater then 2nd, then store 1st as it is 
    // and move its pointer
	
	
    // If power of 2nd polynomial is greater then 1st, then store 2nd as it is 
    // and move its pointer 
	
	// If power of both polynomial numbers is same then add their coefficients
	
	//The incoming strings are the names associated with the respective Polynomial
	//Result will also be the name associated with a Linked List to hold the union of
	//the two linked lists.
	public void add(String poly1, String poly2, String result) {
		
		//with the use of the Polynomial name, we can search for the specific
		//polynomials involved in that operation.
		
		//We use the search function to look through all the MVPolyTable elements.
		
		//How do you identify a MVPolynomial by it's name? (Which is a MVPolyTerm of the MVPolynomial.)
		//Answer: We iterate through MVPolynomial.
		//How do we this?
		//We can iterate through it calling
		//search on 

		
		
		//poly1 is the name associated with an MVPolynomial
		//how do we bring the MVPolynomail? (to then be added/joined with the other polynomial)
		
		//We use the names because you can getName() to find a specific polynomial with search
		
		//
		
		if(search(poly1) == true && search(poly2) == true) {
			while(polynomials.next() == true) {
				if(polynomials.dataRead().getName().equals(poly1)) {
					System.out.println("POLYNOMIAL "+ poly1 + " EXISTS");
				}
				else if(polynomials.dataRead().getName().equals(poly2)){
					MVPolynomial s1 = polynomials.dataRead();
				}
				
		}
				
				
			
			
			//Combine them store in result variable
			//poly1 is the name 
		}
		//string that represents that polynomial
	}
	
	public void subtraction() {
		
	}
	public void multiply() {
		
	}
	public void simplify() {
		
	}
}
