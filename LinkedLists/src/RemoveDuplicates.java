import java.util.HashSet;


public class RemoveDuplicates {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList();
		Node[] nodes1 = new Node[7];
		for(int i=0; i<nodes1.length; i++) {
			nodes1[i] = new Node(i);
		}

		for(int i=nodes1.length-1; i>0; i--) {
			nodes1[i-1].setNext(nodes1[i]);
		}
		list1.setHead(nodes1[0]);
		list1.setSize(7);
		System.out.println(list1);
		
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList();
		Node[] nodes2 = new Node[7];
		
		for(int i=0; i<nodes2.length; i++) {
			nodes2[i] = new Node(i+1*20);
		}
		
		for(int i=nodes2.length-1; i>0; i--) {
			nodes2[i-1].setNext(nodes2[i]);
		}
		list2.setHead(nodes2[0]);
		list2.setSize(7);
		System.out.println(list2);
		
		nodes1[6].setNext(nodes2[0]);
		nodes2[6].setNext(nodes1[6]);
		
		Node loop = list1.findLoop();
		System.out.println(loop);
	}	
}
