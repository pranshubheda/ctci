
public class Test {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		for (int i = 1; i <= 15; i++) {
			tree.insert(i);
		}

		for (int i = 1; i < 15; i++) {
			Integer removed = tree.remove();
			System.out.println(tree);
		}
	}

}
