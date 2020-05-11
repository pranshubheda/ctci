import java.util.HashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> test = new SinglyLinkedList();
		for (int i = 0; i < 10; i++) {
			test.add(i);
			if(i%2==0) {
				test.add(i);
			}
			
		}
		System.out.println(test);
		
//		test.removeDuplicates();
//		test.removeDuplicatesFromSortedList();
		test.removeDuplicateFromSortedsRecursive();
		
		System.out.println(test);
	}

}
