
public class Conversion {
	private String input="";
	private String numbers="";
	private Stack operations=new Stack(15);
	private Stack writer=new Stack(15);
	public Conversion(String input) {
		this.input=input;
	}
	public void printConversion() {
		boolean dispFlag=false;
		boolean last=false;
		
		for(int i =0;i<input.length();i++) {
			if(input.substring(i,i+1).equals("/")||input.substring(i,i+1).equals("*")) {
				if(operations.size()!=0&&(operations.peek().equals("/")||operations.peek().equals("*"))) {
					numbers+=" "+operations.peek();
					operations.pop();
					operations.push(input.substring(i,i+1));
					
				}
				else
					operations.push(input.substring(i,i+1));
				
			}
			else if(input.substring(i,i+1).equals("+")||input.substring(i,i+1).equals("-")) {
				if(!operations.isEmpty()&&!operations.peek().equals("(")) {
					numbers=numbers+" "+operations.peek();
					operations.pop();
				}
				
				operations.push(input.substring(i,i+1));
				
			}
			else if(input.substring(i,i+1).equals("(")) {
				operations.push(input.substring(i,i+1));
			}
			else if(input.substring(i,i+1).equals(")")) {
				while(!operations.peek().equals("(")) {
					numbers+=" "+operations.peek();
					operations.pop();
				}
				operations.pop();
				
			}
			else
			{
				if(input.length()>=i+2&&!input.substring(i+1,i+2).equals("-")&&!input.substring(i+1,i+2).equals("+")&&!input.substring(i+1,i+2).equals("/")&&!input.substring(i+1,i+2).equals("*")&&!input.substring(i+1,i+2).equals("(")&&!input.substring(i+1,i+2).equals(")"))
					{if(input.length()>=i+3&&!input.substring(i+2,i+3).equals("-")&&!input.substring(i+2,i+3).equals("+")&&!input.substring(i+2,i+3).equals("/")&&!input.substring(i+2,i+3).equals("*")&&!input.substring(i+2,i+3).equals("(")&&!input.substring(i+2,i+3).equals(")")) {
					numbers+=" "+input.substring(i,i+3);
					dispFlag=true;
					i+=2;
					}
					else {
					numbers+=" "+input.substring(i,i+2);
					i++;
					}
					}
				
				else
					numbers+=" "+input.substring(i,i+1);
			}
			
			
			System.out.println("Step "+(i)+" - "+input);
			if(dispFlag) {
				if(i+1>=9) {
					for(int j=0;j<i/2;j++) {
						if(j==0)
							System.out.print("          ¯¯¯");
						else
							System.out.print("¯¯");
					}
				}
				else {
					for(int j=0;j<i/2;j++) {
						if(j==0)
							System.out.print("         ¯¯¯");
						else
							System.out.print("¯¯");
					}
				}
				
			}
			else {
				if(i+1>=9) {
					last=true;
					for(int j=0;j<i/2;j++) {
						if(j==0)
							System.out.print("          ¯¯");
						else
							System.out.print("¯¯");
					}
				}
				else {
					for(int j=0;j<i/2;j++) {
						if(j==0)
							System.out.print("         ¯¯");
						else
							System.out.print("¯¯");
					}
				}
				
			}
			if(last) {
				System.out.print("¯¯");
			}
			System.out.println("\n"+numbers);
			System.out.println();
			//System.out.println(" "+input);
			//System.out.println(numbers);
			int temp=operations.size();
			while(operations.size()!=5) {
				operations.push(" ");
			}
			while(!operations.isEmpty()) {
				System.out.println("            | "+operations.peek()+" |");
				if(operations.size()<=temp) {
				writer.push(operations.peek());
				operations.pop();
				}
				else
					operations.pop();
				
			}
			System.out.println("            -----");
			while(!writer.isEmpty()) {
				operations.push(writer.peek());
				writer.pop();
			}
			if(i==input.length()-1) {
				while(!operations.isEmpty()) {
					numbers+=" "+operations.peek();
					operations.pop();
				}
			}
		}
		
		System.out.println("\nPostfix expression :");
		System.out.println(numbers);
		System.out.println();
		Calculate sea=new Calculate(numbers);
		sea.setC(numbers);
		
	}
	public String getNumbers() {
		return numbers;
	}
}
		
	

