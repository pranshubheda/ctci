import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rand = new Random(25);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for (int i = 1; i <= 15; i++) {
			int x = rand.nextInt(20);
//			System.out.println(x);
			bst.insert(x);
		}
		System.out.println(bst);
		bst.inOrderTraversal();
		System.out.println();
		bst.preOrderTraversal();
		System.out.println();
		bst.postOrderTraversal();
	}
}
