import java.util.HashSet;

/**
 * 
 * @author Pranshu Nitin Bheda
 * @param <E> Type of data inserted in SinglyLinkedList
 */

public class SinglyLinkedList<E> implements LinkedList<E>{

	private Node head;
	private int size;
	
	public int getSize() {
		return size;
	}

	@Override
	public boolean add(E data) {
		try {
			Node node = new Node(data);
			if(head==null) {
				head = node;
			}
			else{
				Node temp = head;
				while(temp.getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(node);
			}
			size++;
			return true;
		}catch (Exception e) {
			//some error occured while adding to linkedlist
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(E data) {
		try {
			if(head==null) {
				throw new Exception("List is Empty. No node present with data "+data);
			}
			
			if(head.getData().hashCode() == data.hashCode()) {
				head = head.getNext();
				size--;
				return true;
			}
			
			Node curr = head;
			while(curr.getNext()!=null) {
				if(curr.getNext().getData().hashCode() == data.hashCode()) {
					curr.setNext(curr.getNext().getNext());
					size--;
					return true;
				}
				curr = curr.getNext();
			}
			
			return false;
		}catch (Exception e) {
			//some error occured while removing from linkedlist
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void removeDuplicates() {
		HashSet<E> visited = new HashSet<E>();
		visited.add((E) head.getData());
		Node temp = head;
		while(temp.getNext() != null) {
			E data = (E)temp.getNext().getData();
			if(visited.contains(data)) {
				temp.setNext(temp.getNext().getNext());
				size--;
			}
			else {
				visited.add(data);
				temp = temp.getNext();
			}
		}
	}
	
	private Node removeDuplicateFromSortedsRecursive(Node node) {
		if(node.getNext() == null) {
			return node;
		}
		
		Node returned = removeDuplicateFromSortedsRecursive(node.getNext());
		if(returned.getData() == node.getData()) {
			node.setNext(returned.getNext());
			size--;
		}
		
		return node;
	}
	
	@Override
	public void removeDuplicateFromSortedsRecursive() {
		removeDuplicateFromSortedsRecursive(head);
	}
	
	@Override
	public void removeDuplicatesFromSortedList() {
		Node temp = head;
		while(temp.getNext() != null) {
			if(temp.getNext().getData() == temp.getData()) {
				temp.setNext(temp.getNext().getNext());
			}
			temp = temp.getNext();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		int counter = 0;
		while(temp!=null) {
			sb.append(temp.getData());
			if(counter < size-1)
				sb.append("->");
			temp = temp.getNext();
			counter++;
		}
		return sb.toString();
	}
}
