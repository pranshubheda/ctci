import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tree<E extends Comparable<E>> {
	Node root;
	
	/**
	 * level order insertion into tree
	 * @param data
	 */
	public void insert(E data) {
		//find node with less than two children and place as child
		Node newNode = new Node<E>(data);
		if(root == null ) {
			root = newNode;
		}
		else {
			//find a node using bfs with less than 2 child
			ArrayList<Node> queue = new ArrayList<Node>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node curr = queue.remove(0);
				if(curr.left == null) {
					curr.left = newNode;
					break;
				}else if(curr.right == null) {
					curr.right = newNode;
					break;
				}else {
					//find successors 
					queue.add(curr.left);
					queue.add(curr.right);
				}
			}
		}
	}
	
	/**
	 * level order removal of data from tree
	 * @param data
	 * @return
	 */
	public E remove() {
		if(root == null || root.left == null) {
			//handle root
			root = null;
			return null;
		}
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(root);
		Node prev = root;
		Node deleted = null;
		while(!queue.isEmpty()) {
			Node curr = queue.remove(0);
			if(curr.left == null) {
				Node temp = prev.right;
				prev.right = null;
				deleted = temp;
				break;
			}else if(curr.right == null) {
				Node temp = curr.left;
				curr.left = null;
				deleted = temp;
				break;
			}
			else {
				//find successors 
				queue.add(curr.left);
				queue.add(curr.right);
			}
			prev = curr;
		}			
	
		return (E)deleted.data;
	}
	
	/**
	 * traverse the tree in level order manner
	 * @return
	 */
	public ArrayList<Node> levelOrderTraversal() {
		//find last node in the last level and remove it
		
		ArrayList<Node> queue = new ArrayList<Node>();
		ArrayList<Node> res = new ArrayList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node curr = queue.remove(0);
			res.add(curr);
			if(curr.left != null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		return res;
	}
	
	/**
	 * Remove the node with given data and maintain
	 * complete tree.
	 * @param data
	 * @return
	 */
	public E remove(E data) {
		return null;
	}
	
	@Override
	public String toString() {
		ArrayList<Node> queue = levelOrderTraversal();
		AtomicInteger idx = new AtomicInteger();
		String res =  queue.stream()
									.map(node -> node.data)
									.map(data -> new StringBuilder(data.toString()))
									.collect(Collectors.joining(","));
		return res;
	}
	
}
