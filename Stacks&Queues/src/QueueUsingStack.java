
public class QueueUsingStack {
	Stack front = new Stack<Integer>();
	Stack rear = new Stack<Integer>();
	int size;
	
	private void transfer() {
		while(!rear.isEmpty()) {
			front.push(rear.pop().getData());
		}
	}
	
	public QueueUsingStack(int size) {
		super();
		this.size = size;
	}
	
	public boolean add(int data) {
		boolean pushed = false;
		if(rear.getSize() < (size-(int)size/2) ) {
			rear.push(data);
			pushed = true;
		}
		else if(front.isEmpty()) {
			transfer();
			rear.push(data);
			pushed = true;
		}
		return pushed;
	}
	
	public Integer remove() {
		Node popped;
		if(!front.isEmpty()) {
			popped = front.pop();
		}
		else {
			transfer();
			popped = front.pop();
		}
		return (Integer) popped.getData();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String dataStackString = front.toString();
		sb.append("Front : ");
		sb.append(dataStackString);
		sb.append("\n");
		dataStackString = rear.toString();
		sb.append("Rear : ");
		sb.append(dataStackString);
		sb.append("\n");
		return sb.toString();
	}
}
