import java.util.ArrayList;
import java.util.stream.Collectors;

public class BinarySearchTree<E extends Comparable<E>> extends Tree<E>{
	
	@Override
	public void insert(E data) {
		Node curr = root;
		Node newNode = new Node(data);
		
		if(curr==null) {
			root = newNode;
			return;
		}

		while(true) {
			if(curr.compareTo(newNode) < 0) {
				if(curr.left == null) {
					curr.left = newNode;
					System.out.println("inserted left of "+curr);
					break;
				}
				else {
					curr = curr.left;
				}
			}
			else {
				if(curr.right == null) {
					curr.right = newNode;
					System.out.println("inserted right of "+curr);
					break;
				}
				else {
					curr = curr.right;
				}
			}
		}
	}
	
	@Override
	public E remove(E data) {
		// TODO Auto-generated method stub
		return super.remove(data);
	}
	
	private void inOrderTraversal(Node curr) {
		if(curr == null)
			return;
		inOrderTraversal(curr.left);
		System.out.print(curr+",");
		inOrderTraversal(curr.right);
		return;
	}
	
	public void inOrderTraversal() {
		Node curr = root;
		inOrderTraversal(curr);
	}
	
	private void preOrderTraversal(Node curr) {
		if(curr == null)
			return;
		System.out.print(curr+",");
		preOrderTraversal(curr.left);
		preOrderTraversal(curr.right);
		return;
	}
	
	public void preOrderTraversal() {
		Node curr = root;
		preOrderTraversal(curr);
	}
	
	private void postOrderTraversal(Node curr) {
		if(curr == null)
			return;
		postOrderTraversal(curr.left);
		postOrderTraversal(curr.right);
		System.out.print(curr+",");
		return;
	}
	
	public void postOrderTraversal() {
		Node curr = root;
		postOrderTraversal(curr);
	}
}
