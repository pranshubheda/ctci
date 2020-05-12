import java.util.HashSet;

/**
 * 
 * @author Pranshu Nitin Bheda
 * @param <E> type of data for the linked list. We use the same
 * interface for Singly and Doubly Linked lists.
 */
public interface LinkedList<E> {
	boolean add(E data);
	boolean remove(E data);
	void removeDuplicates();
	void removeDuplicateFromSortedsRecursive();
	void removeDuplicatesFromSortedList();
	Node findNodeAtOffsetFromEnd(int offset);
	Node findNodeAtOffsetFromEndDoublePointer(int offset);
	void deleteMiddleNode();
	void partition(int k);
	String toString(Node node);
}
