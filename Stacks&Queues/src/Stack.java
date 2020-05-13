public class Stack<E> {
	private Node top;
	private int size;
	public Node getTop() {
		return top;
	}
	public void setTop(Node top) {
		this.top = top;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void push(E data) {
		Node newNode = new Node(data);
		if(top == null) {
			top = newNode;
		}
		else { 
			newNode.setNext(top);
			top = newNode;
		}
		size++;
	}

	public Node pop() {
		Node popped = top;
		top = top.getNext();
		size--;
		return popped;
	}
	
	public Node peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == null ? true:false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node temp = top;
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