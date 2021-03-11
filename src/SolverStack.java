public class SolverStack {
	private int top;
	private Solver[] elements;
	SolverStack(int capacity){
		elements =new Solver [capacity];
		top=-1;
	}
	void push(Solver data) {
		if (isFull())
			System.out.println("Stack overflow");
		else {
			top++;
			elements[top]=data;
		}
	}
	Solver pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			Solver retData=elements[top];
			top--;
			return retData;
		}
	}
	Solver peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else
			return elements[top];
		
	}
	boolean isEmpty() {
		return (top==-1);
	}
	boolean isFull() {
		return (top+1==elements.length);
	}
	int size() {
		return top+1;
	}
	
}
