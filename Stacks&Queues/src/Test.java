
public class Test {

	public static void main(String[] args) {
		Stack<Integer> testStack = new Stack();
		Queue<Integer> testQueue = new Queue();
		for (int i = 0; i < 10; i++) {
			testStack.push(i);
			testQueue.add(i);
		}
		System.out.println(testStack);

		for (int i = 0; i < 10; i++) {
			if(i%2==0) {
				Node popped = testStack.pop();
				System.out.println(popped);
				Node removed = testQueue.remove();
				System.out.println(removed);
			}
		}
		
		System.out.println(testStack);
		System.out.println(testQueue);
	}
}
