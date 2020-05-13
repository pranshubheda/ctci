
public class Queue<E> {
	Node front;
	Node rear;
	int size;
	
	public Node getFront() {
		return front;
	}
	public void setFront(Node front) {
		this.front = front;
	}
	public Node getRear() {
		return rear;
	}
	public void setRear(Node rear) {
		this.rear = rear;
	}
	public void add(E data) {
		Node newNode = new Node(data);
		if(front == null) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}
	
	public Node remove() {
		Node removed = front;
		front = front.getNext();
		if(isEmpty())
			rear = null;
		size--;
		return removed;
	}
	
	public Node peek() {
		return front;
	}
	
	public boolean isEmpty() {
		return front == null ? true:false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node temp = front;
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
