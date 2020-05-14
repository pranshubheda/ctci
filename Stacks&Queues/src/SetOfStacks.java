
public class SetOfStacks {
	int n;
	int size;
	int totalSize;
	Stack[] stacks;
	
	public SetOfStacks(int n, int size) {
		super();
		this.n = n;
		this.size = size;
		this.totalSize = n*size;
		this.stacks = new Stack[n];
		for(int i=0; i<n; i++) {
			stacks[i] = new Stack<Integer>();
		}
	}
	
	public boolean push(int data) {
		int stackUsed = -1;
		for(int i=0; i<n; i++) {
			if(stacks[i].getSize() < size) {
				//stack i has room
				stacks[i].push(data);
				stackUsed = i;
				break;
			}
		}
		
		return stackUsed == -1 ? false:true;
	}
	
	public Integer pop() {
		int stackUsed = -1;
		Node popped = null;
		for(int i=n-1; i>=0; i--) {
			if(!stacks[i].isEmpty()) {
				//stack i has room
				popped = stacks[i].pop();
				stackUsed = i;
				break;
			}
		}
		
		return (Integer) popped.getData();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stacks.length; i++) {
			String dataStackString = stacks[i].toString();
			sb.append("Stack "+i+" : ");
			sb.append(dataStackString);
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
