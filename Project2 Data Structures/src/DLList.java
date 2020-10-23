//****************************************************************
// Alfredo Perez
//Due Thursday
//
// Java Templated Doubly Linked List Class
//****************************************************************

//****************************************************************
//
// DLList Class
//
//****************************************************************
//Implement the DLList class as described in Project 2: Part A.
class DLList<T> {

	//****************************************************************
	//
	// DLListNode nested class
	//
	//****************************************************************
	private static class DLListNode<T> {
		//****************************************************************
		// DLList node private data members
		//****************************************************************
		private T data;
		private DLListNode<T> prev;
		private DLListNode<T> next;
		

		//****************************************************************
		// Constructor
		//****************************************************************
		DLListNode(T item, DLListNode<T> p, DLListNode<T> n) {
			data = item;
			prev = p;
			next = n;
		}

		//****************************************************************
		// Get element.
		//****************************************************************
		T getElement() {
			return data;
		}

		//****************************************************************
		// Set element.
		//****************************************************************
		void setElement(T item) {
			data = item;
		}

		//****************************************************************
		// Get previous.
		//****************************************************************
		DLListNode<T> getPrev() {
			return prev;
		}
		
		//****************************************************************
		// Set previous.
		//****************************************************************
		void setPrev(DLListNode<T> node) {
			prev = node;
		}

		//****************************************************************
		// Get Next.
		//****************************************************************
		DLListNode<T> getNext() {
			return next;
		}

		//****************************************************************
		// Set Next.
		//****************************************************************
		void setNext(DLListNode<T> node) {
			next = node;
		}
	}

	//****************************************************************
	// DLList private data members
	//****************************************************************
	private DLListNode<T> header;
	private DLListNode<T> trailer;
	//****************************************************************
	// !!!IMPORTANT!!!
	// Node current acts as an iterator.
	// Node current should always point to a concrete node if there is
	// at least one concrete node in the list.
	// Otherwise, current is null.
	//****************************************************************
	private DLListNode<T> current;
	private int size = 0;

	//****************************************************************
	// Default constructor
	//****************************************************************
	DLList() {
		header = new DLListNode<>(null, null, null);
		trailer = new DLListNode<>(null, header, null);
		header.setNext(trailer);
	}

	//****************************************************************
	// Construct a new list by copying an existing list.
	//****************************************************************
	DLList(DLList<T> other) {
		if(other.header==null) {
			this.header=null;
			this.trailer=null;
			this.current=this.header;
			this.size=0;
		}
		else {
			this.header=new DLListNode<T>(other.header.getElement(), null, null);
			this.current=this.header;
			this.trailer=this.header;
			other.atFirst();
			this.size=1;
			
			while(!other.last()) {
				other.next();
				DLListNode<T> node=new DLListNode<T>(other.dataRead(),this.current,null);
				this.current.setNext(node);
				this.next();
				this.trailer=node;
				this.size++;
				
			}
		}
	}

	//****************************************************************
	// Delete all the nodes in the list.
	//****************************************************************
	void clear() {
		header = trailer = null;
		size = 0;
	}

	//****************************************************************
	// Return the number of nodes in the list.
	//****************************************************************
	int size() {
		return size;
	}

	//****************************************************************
	// Return whether the list is empty.
	//****************************************************************
	boolean isEmpty() {
		return size == 0;
	}

	//****************************************************************
	// Return whether node current points to the first node.
	//****************************************************************
	boolean atFirst() {
		return current == header.getNext();
	}

	//****************************************************************
	// Return whether node current points to the last node.
	//****************************************************************
	boolean atLast() {
		return current == trailer.getPrev();
	}

	//****************************************************************
	// Move node current to the first node, and return true.
	// Or return false if list is empty.
	//****************************************************************
	boolean first() {
		if(isEmpty()) {
			return false;
		}
		else {
			current = header.getNext();
			header = current;
			return true;
		}
	}

	//****************************************************************
	// Move node current to the last node, and return true.
	// Or return false if list is empty.
	//****************************************************************
	boolean last() {
		if(isEmpty()) {
			return false;			
		}
		else {
			trailer.setNext(current);
			trailer = current;
			return true;
		}
	}
	
	//****************************************************************
	// Move node current to its next node, and return true.
	// Or return false if no such node.
	//****************************************************************
	boolean next() {
		if(current.getNext() == null) {
			return false;
		}
		else {
			current.setNext(current);
			current = current;
			return true;
		}
	}

	//****************************************************************
	// Move node current to its previous node, and return true.
	// Or return false if no such node.
	//****************************************************************
	boolean previous() {
		if(current.getPrev() == null) {
			return false;
		}
		else {
			current.setPrev(current);
			current = current;
			return true;
		}
	}

	//****************************************************************
	// The index of the first concrete node is 0.
	// Move node current to the node at index loc, and return true.
	// Or return false if no such node.
	//****************************************************************
	boolean seek(int loc) {
		int count=0;
		this.first();
		while(this.next()) {
			count++;	
			if(count==loc) {	
				return true;
			}
		}
		return false;
	}

	//****************************************************************
	// Return the content of node current.
	// Or return null if list is empty.
	//****************************************************************
	T dataRead() {
		if(this.header!=null) {
			return this.current.getElement()
					;
		}
		return null;
	}
	
	//****************************************************************
	// Rewrite the content of node current if list is not empty
	//****************************************************************
	void dataWrite(T item) {
		if(this.header!=null) {
			this.current.setElement(item);
		}
	}
	
	//****************************************************************
	// Insert a new node to the front of the list, and move
	// node current to the new node.
	//****************************************************************
	void insertFirst(T item) {
		DLListNode<T> newest = new DLListNode<>(item, header, header.getNext());
//		header = new DLListNode<>(item, header, header.getNext());
		if(isEmpty()) {
			trailer = header;
		}
		else {
			header.setNext(newest);
		}
		current = newest;
		size++;
	}

	//****************************************************************
	// Insert a new node to the end of the list, and move
	// node current to the new node.
	//****************************************************************
	void insertLast(T item) {
		DLListNode<T> newest = new DLListNode<>(item, trailer.getPrev(), trailer);
		if(isEmpty()) {
			header = newest;
		}
		else {
			trailer.setNext(newest);
		}
		current = newest;
		size++;
	}
    
    //****************************************************************
    // Insert a new node before where node current points to if list
    // is not empty, and move node current to the new node.
    // Or insert a new node if list is empty, and move node current to
    // the new node.
    //****************************************************************
	 void insertAtCurrent(T item) {
		 	if(this.header==null) {
		 		this.insertFirst(item);
		 	}
		 	else {
		 		if(this.current==this.header) {
		 			this.insertFirst(item);
		 		}
		 		else {
		 		
		 			DLListNode<T> new_node=new DLListNode<T>(item, this.current.getPrev(), this.current);
		 	
		 			this.current.getPrev().setNext(new_node);
		 			this.current.setPrev(new_node);
		 			this.current=new_node;
		 			this.size++;
		 			
		 		}
		 	}
		     
		 }

	//****************************************************************
	// Delete the first node in the list if list is not empty.
	// Move node current to the new first node, or set current to null
	// if list becomes empty.
	//****************************************************************
	void deleteFirst() {
		if(this.header!=null) {
			DLListNode<T> new_header=header.next;
			
			if(new_header!=null) {
				new_header.setPrev(null);
			}
			else {
				this.trailer=null;
			}
			//update the parameters 
			this.header=new_header;
			this.current=new_header;
			this.size--;
		}
		

	}

	//****************************************************************
	// Delete the last node in the list if list is not empty.
	// Move node current to the new last node, or set current to null
	// if list becomes empty.
	//****************************************************************
	void deleteLast() {
		//needs to iterate
		if(isEmpty()) {
			current = null;
		}
		else {
		//	
		}
		size--;
	}

	//****************************************************************
	// Delete the node where node current points to if list is not
    // empty.
    // Move node current to its previous node, or move node current to
    // its next node if node current was at the front of the list, or
    // set node current to null if list becomes empty.
	//****************************************************************
	void deleteAtCurrent() {
		if(current.prev != null) { //node is not head
		      current.prev.next = current.next;
		    }
		    else { //node a is head
		     current = current.next;
		    }
		    if(current.next != null) {
		      current.next.prev = current.prev;
		    }
	}
}
