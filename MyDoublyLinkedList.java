package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;

	///////////////////////////////////// MY CODE

	@Override
	public void add(E e) {
		//EDGE CASES: SIZE = 0

		DNode node = new DNode();
		node.element = e;

		if (!this.isEmpty()){
			this.tail.next = node;
			node.prev = this.tail;
		}else{
			this.head = node;
		}

		this.tail = node;
		node.next = null;
		this.size++;
	}

	@Override
	public E remove() {
		//EDGE CASES: SIZE = 0, SIZE = 1
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		}

		DNode stored = this.tail;

		if (this.size == 1){
			this.tail = null;
			this.head = null;
		}else{
			this.tail = tail.prev;
			this.tail.next = null;
		}

		this.size--;

		return stored.element;
	}

	@Override
	public void clear() {
		//EDGE CASES: NONE
		int sizeOf = this.getSize();
		for (int i = 0; i < sizeOf; i++){
			this.remove();
		}
	}

	public void addFirst(E e){
		//EDGE CASES: SIZE = 0
		DNode node = new DNode();
		node.element = e;

		if (!this.isEmpty()){
			this.head.prev = node;
			node.next = this.head;
		}else{
			this.tail = node;
		}

		this.head = node;
		node.prev = null;
		this.size++;
	}

	public void addLast(E e){
		//EDGE CASES: SIZE = 0
		this.add(e);
	}

	public E removeFirst(){
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		}

		DNode stored = this.head;

		if (this.size == 1){
			this.tail = null;
			this.head = null;
		}else{
			this.head = head.next;
			this.head.prev = null;
		}

		this.size--;

		return stored.element;
	}

	public E removeLast(){
		return this.remove();
	}

	public E peekFirst(){
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		}
		return this.head.element;
	}

	public E peekLast(){
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		}
		return this.tail.element;
	}

	public boolean equals(Object o){
		if (!(o instanceof MyDoublyLinkedList)) {
			return false;
		}

		MyDoublyLinkedList<E> x = (MyDoublyLinkedList<E>) o;

		if(this.isEmpty() && x.isEmpty()){
			return true;
		}else{
			int i = 0;
			DNode p1 = this.head;
			DNode p2 = x.head;

			while (i < x.getSize()){
				if (!(p1.element.equals(p2.element))){
					return false;
				}
				p1 = p1.next;
				p2 = p2.next;
				i++;
			}
			return true;
		}
	}

	/*
	 * ADD YOUR CODE HERE
	 */

	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
