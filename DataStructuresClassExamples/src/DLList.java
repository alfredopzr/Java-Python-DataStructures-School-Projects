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
	DLList(DLList<T> other) throws CloneNotSupportedException {
		DoublyLinkedList<T> copy = (DoublyLinkedList<T>) super.clone();
		if (size > 0) {
	        other.header = new DLListNode<>(null, null, null);
	        other.trailer = new DLListNode<>(null, other.header, null);
	        other.header.setNext(other.trailer);
	        DLListNode<T> walk = header.getNext();
	        DLListNode<T> otherWalk = other.header;
	        for(int i = 0; i < size; i++) {
	        	DLListNode<T> newest = new DLListNode<>(walk.getElement(), otherWalk, otherWalk.getNext());
	            otherWalk.getNext().setPrev(newest);
	            otherWalk.setNext(newest);
	            otherWalk = otherWalk.getNext();
	            walk = walk.getNext();
	        }
	    }
	    return other;
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
		while(current != null) {
			if(current.item == loc) {
				return true;
				current = current.next;
			}
			else {
				return false;
			}
		}
	}

	//****************************************************************
	// Return the content of node current.
	// Or return null if list is empty.
	//****************************************************************
	T dataRead() {
		return null;
	}
	
	//****************************************************************
	// Rewrite the content of node current if list is not empty
	//****************************************************************
	void dataWrite(T item) {
		
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
        
    }

	//****************************************************************
	// Delete the first node in the list if list is not empty.
	// Move node current to the new first node, or set current to null
	// if list becomes empty.
	//****************************************************************
	void deleteFirst() {
		if(isEmpty()) {
			current = null;
		}
		else {
			header.previous().next() = header.next;
			current = header;
			header = header.getNext();
		}
		size--;
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

	}
}
