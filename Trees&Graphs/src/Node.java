import java.util.Comparator;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>>{
	E data;
	Node left;
	Node right;
	public Node(E data) {
		super();
		this.data = data;
	}
	
	public Node() {
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}

	@Override
	public int compareTo(Node<E> o) {
		// TODO Auto-generated method stub
		return o.data.compareTo(this.data);
	}

}
