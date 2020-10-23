
public class testPractice {
	//Singly Linked List
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;
		if(isEmpty()) {
			tail = head;
		}
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty()) {
			head = null;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		if(isEmpty()) {
			tail = null;
		}
		return answer;
	}
	
	//Doubly Linked List
	public void addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
	}
	public E remove(Node<E> node) {
		Node<E> pred = node.getPrev();
		Node<E> succ = node.getNext();
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		return node.getElement();
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public void removeFirst() {
		return remove(header.getNext());
	}
	public void removeLast() {
		return remove(trailer.getPrev());
	}
	
}
