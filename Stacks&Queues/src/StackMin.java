
public class StackMin<E> extends Stack<E>{
	//data stack
	Stack<E> dataStack = new Stack<>();
	//min stack
	Stack<E> minStack = new Stack<>();
	
	//push
	public void push(E data) {
		dataStack.push(data);
		if(minStack.isEmpty()) {
			minStack.push(data);
		}
		else {
			if((Integer)minStack.peek().getData() >= (Integer)data) {
				minStack.push(data);
			}
		}
	}
	
	//pop
	public Node<E> pop() {
		Node<E> data = dataStack.pop();
		Node<E> min = minStack.peek();
		if(min.getData()==data.getData()) {
			minStack.pop();
		}
		return data;
	}
	
	//min
	public E min() {
		E min = null;
		if(!minStack.isEmpty())
			min = (E) minStack.peek().getData();
		return min;
	}
	
	@Override
	public int getSize() {
		return dataStack.getSize();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String dataStackString = dataStack.toString();
		String minStackString = minStack.toString();
		sb.append(dataStackString);
		sb.append("\n");
		sb.append(minStackString);
		return sb.toString();
	}
}
