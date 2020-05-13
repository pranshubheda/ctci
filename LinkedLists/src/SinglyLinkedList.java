import java.util.HashSet;


/**
 * 
 * @author Pranshu Nitin Bheda
 * @param <E> Type of data inserted in SinglyLinkedList
 */

public class SinglyLinkedList<E> implements LinkedList<E>{

	private Node head;
	private int size;

	public SinglyLinkedList() {
		super();
	}
	
	public SinglyLinkedList(Node head) {
		super();
		this.head = head;
		this.size = 0;
		Node temp = head;
		while(temp!=null) {
			this.size++;
			temp = temp.getNext();
		}
	}

	@Override
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
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
	public Node findNodeAtOffsetFromEndDoublePointer(int offset) {
		try {
			Node slow=head;
			Node fast=head;
			int counter = 1;
			while(counter<offset) {
				fast = fast.getNext();
				counter++;
			}
			
			if(fast == null) {
				throw new Exception("Invalid offset .... greater than linked list size");
			}
			
			while(fast.getNext() != null) {
				fast = fast.getNext();
				slow = slow.getNext();
			}
			
			return slow;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Node findNodeAtOffsetFromEnd(int offset) {
		Node temp = head;
		for(int i=0; i<size-offset; i++)
			temp = temp.getNext();
		return temp;
	}
	
	@Override
	public void deleteMiddleNode() {
		//middle = floor(size / 2)
		Node slow = head;
		Node fast = head;
		
		//lenth == 1 delete head
		if(fast.getNext()==null) {
			head = null;
			return;
		}
		
		//length == 2 delete head and place second element at head
		if(fast.getNext().getNext()==null) {
			head = fast.getNext();
			return;
		}
		
		//comment this  to delete ceiling of size/2 in case of even length
		fast = fast.getNext().getNext();
		
		while(fast.getNext()!=null && fast.getNext().getNext()!=null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		slow.setNext(slow.getNext().getNext());
		size--;
	}
	
	@Override
	public void partition(int k) {
		Node front = head;
		Node rear = head;
		while(front!=null) {
			Node next = front.getNext();
			if ((Integer)front.getData() < k) {
				front.setNext(head);
				head = front;
			}
			else {
				rear.setNext(front);
				rear = front;
			}
			front = next;
		}
		rear.setNext(null);
	}

	@Override
	public LinkedList<Integer> sumOnesPlaceAtHead(LinkedList<Integer> list) {
		Node i = this.head;
		Node j = list.getHead();
		int m= this.getSize(), n = list.getSize();
		Node result = null;
		Node resultFront = null;
		int carry = 0;
		while(i!=null && j!=null) {
			int sum = (Integer)i.getData() +(Integer)j.getData() + carry;
			int val = sum %10;
			carry = sum/10;
			Node newNode = new Node(val);
			if(resultFront==null) {
				resultFront = newNode;
				result = newNode;
			}else {
				result.setNext(newNode);
				result = newNode;
			}
			i = i.getNext();
			j = j.getNext();
		}
		Node padd = i!=null ? i : j;
		while(padd!=null) {
			int sum = (int) padd.getData() + carry;
			int val = sum %10;
			carry = sum/10;
			Node newNode = new Node(val);
			result.setNext(newNode);
			result = newNode;
			padd = padd.getNext();
		}
		
		if(carry > 0) {
			Node newNode = new Node(carry);
			result.setNext(newNode);
			result = newNode;
		}
		return new SinglyLinkedList<Integer>(resultFront);
	}
	
	private void paddingHelper(int pad, SinglyLinkedList l) {
		while(pad > 0) {
			Node temp = new Node(0);
			temp.setNext(l.getHead());
			l.setHead(temp);
			pad--;
			l.size++;
		}
	}
	
	private void paddWithZeros(SinglyLinkedList l1, SinglyLinkedList l2) {
		int pad = l1.getSize() -l2.getSize();
		if(pad == 0) {
			return;
		}
		else if (pad > 0) {
			//l2 is shorter
			pad = Math.abs(pad);
			paddingHelper(pad, l2);
		}
		else {
			//l1 is shorter
			pad = Math.abs(pad);
			paddingHelper(pad, l1);
		}
	}
	
	private class PartialSum {
		Node val;
		int carry;
		public PartialSum(Node val, int carry) {
			super();
			this.val = val;
			this.carry = carry;
		}
	}
	
	private PartialSum sumRecursive(Node i, Node j) {
		if(i.getNext() == null && j.getNext()==null) {
			int sum = (int) i.getData()+ (int) j.getData();
			int carry = sum/10;
			int val = sum%10;
			return new PartialSum(new Node(val), carry);
		}
		else {
			PartialSum partialSum = sumRecursive(i.getNext(), j.getNext());
			int sum = (int) i.getData()+ (int) j.getData() + partialSum.carry;
			int carry = sum/10;
			int val = sum%10;
			Node newNode = new Node(val);
			newNode.setNext(partialSum.val);
			partialSum.val = newNode;
			partialSum.carry = carry;
			return partialSum;
		}
	}
	
	@Override
	public LinkedList<Integer> sumOnesPlaceAtTail(SinglyLinkedList<Integer> list) {
		//padd
		SinglyLinkedList l1 = this;
		SinglyLinkedList l2 = list;
		paddWithZeros(l1, l2);
		//sum
		PartialSum partialSum = sumRecursive(l1.getHead(), l2.getHead());
		if(partialSum.carry > 0) {
			Node newNode = new Node(partialSum.carry);
			newNode.setNext(partialSum.val);
			partialSum.val = newNode;
			partialSum.carry = 0;
		}
		return new SinglyLinkedList<Integer>(partialSum.val);
	}
	
	@Override
	public boolean palindrome() {
		Node slow = this.head;
		Node fast = this.head;
		Node reverse = null;
		
		while(fast!=null && fast.getNext() != null) {
			Node next = slow.getNext();
			fast = fast.getNext().getNext();
			if(reverse == null) {
				slow.setNext(null);
				reverse = slow;
			}
			else {
				slow.setNext(reverse);
				reverse = slow;
			}
			slow = next;
		}
		
		if(fast!=null) {
			//odd length strings
			slow = slow.getNext();
		}
		
		System.out.println(new SinglyLinkedList<E>(reverse));
		while(slow.getNext()!=null) {
			if(reverse.getData().hashCode() != slow.getData().hashCode())
				return false;
			slow = slow.getNext();
			reverse = reverse.getNext();
		}
		return true;
	}
	
	@Override
	public void reverse() {
		Node curr = head;

		while(curr.getNext()!=null) {
			Node nextOfNext = curr.getNext().getNext();
			curr.getNext().setNext(curr);
			if(curr == head) {
				head = curr.getNext();
				curr.setNext(null);
			}
			else {
				Node temp = curr.getNext();
				curr.setNext(head);
				head = temp;
			}
			curr = nextOfNext;
		}
		if(curr != null) {
			curr.setNext(head);
			head = curr;
		}
	}
	
	@Override
	public Node findIntersection(LinkedList<E> list) {
		paddWithZeros(this, (SinglyLinkedList)list);
		Node i = this.head;
		Node j = list.getHead();
		
		Node tail1 = this.findNodeAtOffsetFromEnd(0);
		Node tail2 = list.findNodeAtOffsetFromEnd(0);
		
		if(tail1!=tail2) {
			return null;
		}
		
		while(i!=j) {
			i = i.getNext();
			j = j.getNext();
		}

		return i;
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

	@Override
	public String toString(Node node) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
