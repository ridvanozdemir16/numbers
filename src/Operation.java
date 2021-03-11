
public class Operation {
	private int num1;
	private int num2;
	private String ope;
	public Operation(int num1,int num2, String ope) {
		this.num1=num1;
		this.num2=num2;
		this.ope=ope;
	}
	public int result() {
		if (ope.equals("+")) {
			return num1+num2;
		}
		if (ope.equals("-")) {
			return num1-num2;
		}
		if (ope.equals("/")) {
			return num1/num2;
		}
		else  {
			return num1*num2;
		}
		
		
	}
}
