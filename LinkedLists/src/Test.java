
public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> test = new SinglyLinkedList();
		for (int i = 0; i < 10; i++) {
			test.add(i);
		}
		System.out.println(test);

		for (int i = 0; i < 10; i++) {
			if(i%2==0) {
				test.remove(i);
			}
		}
		System.out.println(test);
		test.reverse();
		System.out.println(test);
	}
}
