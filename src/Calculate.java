
public class Calculate {
	private String input="";
	private String [] postfix;
	private Stack numbers=new Stack(20);
	private Stack writer=new Stack(20);
	private static String c;
	public Calculate(String input) {
		this.input = input;
		
	}
	public void getResult() {
		boolean dispFlag=false;
		c=Calculate.getC();
		postfix=input.split(" ");
		for(int i=0;i<postfix.length;i++) {
			if(postfix[i].equals("/")||postfix[i].equals("*")||postfix[i].equals("+")||postfix[i].equals("-")) {
				int num1 =Integer.parseInt((numbers.peek().toString()));
				numbers.pop();
				int num2 =Integer.parseInt((numbers.peek().toString()));
				numbers.pop();
				Operation ope=new Operation(num2,num1,postfix[i]);
				numbers.push(ope.result());
			}
			else 
				numbers.push(postfix[i]);
			int temp=numbers.size();
			while(numbers.size()!=5) {
				numbers.push("");
			}
			System.out.println("Step "+(i+1)+" - "+c);
			//System.out.println(" "+input);
			if(postfix[i].trim().equals("100")) {
				dispFlag=true;
				
			}
			if(dispFlag) {
				if(i+1>9) {
					for(int j=0;j<i;j++) {
						if(j==0)
							System.out.print("           ¯¯¯");
						else
							System.out.print("¯¯");
					}
				}
				else {
					for(int j=0;j<i;j++) {
						if(j==0)
							System.out.print("          ¯¯¯");
						else
							System.out.print("¯¯");
					}
				}
				
			}
			else {
				if(i+1>9) {
					for(int j=0;j<i;j++) {
						if(j==0)
							System.out.print("           ¯¯");
						else
							System.out.print("¯¯");
					}
				}
				else {
					for(int j=0;j<i;j++) {
						if(j==0)
							System.out.print("          ¯¯");
						else
							System.out.print("¯¯");
					}
				}
			}
			
			System.out.println();
			while(!numbers.isEmpty()) {
				
				if(numbers.peek().toString().length()==1) {
					System.out.println("           | "+numbers.peek().toString().trim()+"   |");
				}
				else if(numbers.peek().toString().length()==2) {
					System.out.println("           | "+numbers.peek().toString().trim()+"  |");
				}
				else if(numbers.peek().toString().length()==3) {
					System.out.println("           | "+numbers.peek().toString().trim()+" |");
				}
				else if(numbers.peek().toString().length()==4) {
					System.out.println("           |"+numbers.peek().toString().trim()+" |");
				}
				/*else if(numbers.peek().toString().length()==0) {
					System.out.println("           | "+numbers.peek().toString().trim()+"    |");
				}*/
				else {
					System.out.println("           |"+numbers.peek().toString().trim()+"     |");
				}
				
				if(numbers.size()<=temp) {
				writer.push(numbers.peek());
				numbers.pop();
				}
				else
					numbers.pop();
				
			}
			System.out.println("           -------");
			System.out.println();
			while(!writer.isEmpty()) {
				numbers.push(writer.peek());
				writer.pop();
			}
		
		}
		System.out.print(numbers.peek());
	}
	/**
	 * @return the numbers
	 */
	public Stack getNumbers() {
		return numbers;
	}
	public void setC(String a) {
		c=a;
	}
	public static String getC() {
		return c;
	}
	
}
