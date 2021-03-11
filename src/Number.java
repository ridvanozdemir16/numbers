import java.util.Random;
import java.util.Scanner;

public class Number {
	private int targetNumber;
	private int digit1;
	private int digit2;
	private int digit3;
	private int digit4;
	private int digit5;
	private int middle;
	private int playerScore, compScore;
	private Scanner scan;
	public Number() {
		playerScore=0;
		compScore=0;
		scan = new Scanner(System.in);
	}
	public void easyRun() {
		int turn=1;
		while(playerScore!=100 && compScore!=100) {
		System.out.println("---------- ROUND "+turn+" ----------");
		Random rand = new Random();
		targetNumber=(int)((Math.random()*899)+100);
		digit1= rand.nextInt(9)+1;
		digit2= rand.nextInt(9)+1;
		digit3= rand.nextInt(9)+1;
		digit4= rand.nextInt(9)+1;
		digit5= rand.nextInt(9)+1;
		middle=rand.nextInt(4);
		System.out.println("Target number: "+targetNumber);
		if(middle==1)
			middle=25;
		else if(middle==2)
			middle=75;
		else if(middle==3)
			middle=50;
		else
			middle=100;
		
		
		
		System.out.print(digit1+" "+digit2+" "+digit3+" "+digit4+" "+digit5+" "+middle);
		ComputerEasy d=new ComputerEasy(digit1,digit2,digit3,digit4,digit5,middle,targetNumber);
		Solver Com_answer=d.getResult();
		
		System.out.println("\nPlease enter your number: ");
		int User_answer= scan.nextInt();
		System.out.println("Result numbers");
		System.out.println("      Player: "+User_answer+"   Computer: "+Com_answer.getResult());
		if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<Math.abs(User_answer-targetNumber)) {
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
			System.out.println("Computer's solution steps:");
			System.out.println(Com_answer.getSolve_step());
			System.out.println("--- Correct");
		}
		else {
		//int User_answer=Integer.valueOf(scan.next());
		
			
		System.out.println("\nplease enter your Solve step");
		scan.nextLine();
		String inputs= scan.nextLine();
		boolean flag1 = true;
		int digit11 =0;
		int digit22 =0;
		int digit33 =0;
		int digit44 =0;
		int digit55 =0;
		int middlee=0;
		int countpar=0;
		
		for (int i = 0; i < inputs.length(); i++) {
			if(!inputs.substring(i,i+1).equals("/")&&!inputs.substring(i,i+1).equals("*")&&!inputs.substring(i,i+1).equals("+")&&!inputs.substring(i,i+1).equals("-")&&!inputs.substring(i,i+1).equals(")")&&!inputs.substring(i,i+1).equals("("))
				if(inputs.length()>=i+2&&!inputs.substring(i+1,i+2).equals("/")&&!inputs.substring(i+1,i+2).equals("*")&&!inputs.substring(i+1,i+2).equals("+")&&!inputs.substring(i+1,i+2).equals("-")&&!inputs.substring(i+1,i+2).equals(")")&&!inputs.substring(i+1,i+2).equals("(")) {
					if(inputs.length()>=i+3&&!inputs.substring(i+2,i+3).equals("/")&&!inputs.substring(i+2,i+3).equals("*")&&!inputs.substring(i+2,i+3).equals("+")&&!inputs.substring(i+2,i+3).equals("-")&&!inputs.substring(i+2,i+3).equals(")")&&!inputs.substring(i+2,i+3).equals("(")) {
						if(Integer.valueOf(inputs.substring(i,i+3))!=middle){
							flag1=false;
							
							
							break;
						}
						else{
							if(middlee==0){
							middlee++;
							i+=2;
						}
							else {
								flag1=false;
							break;}
						}
					}
					else {
					if(Integer.valueOf(inputs.substring(i,i+2))!=middle){
						flag1=false;
						break;
					}
					else{
						if(middlee==0){
							middlee++;
						
					
						i++;
						}	
						else {
							flag1=false;
						break;}
					}
					}
				}
				else {
					if(Integer.valueOf(inputs.substring(i,i+1))==digit1&&digit11==0){
					digit11++;
				}
					else if(Integer.valueOf(inputs.substring(i,i+1))==digit2&&digit22==0){
						digit22++;
					}
					else if(Integer.valueOf(inputs.substring(i,i+1))==digit3&&digit33==0){
						digit33++;
					}
					else if(Integer.valueOf(inputs.substring(i,i+1))==digit4&&digit44==0){
						digit44++;
					}
					else if(Integer.valueOf(inputs.substring(i,i+1))==digit5&&digit55==0){
						digit55++;
					}
					else{
						flag1=false;
						break;
					}
					
							
					
				}
			//input control
			if(inputs.substring(i,i+1).equals(")")){
				countpar++;
				if(i!=inputs.length()-1) {
					if(inputs.substring(i+1,i+2).equals("(")) {
						flag1=false;
						break;
					}
				}
				if(i==0) {
					flag1=false;
					break;
				}
				if(inputs.substring(i-1,i).equals("+")|| inputs.substring(i-1,i).equals("-")|| inputs.substring(i-1,i).equals("*")|| inputs.substring(i-1,i).equals("/")) {
					flag1=false;
					break;
				}
			}
			if(inputs.substring(i,i+1).equals("(")){
				countpar--;
				if(i!=inputs.length()-1) {
					if(inputs.substring(i+1,i+2).equals(")")|| inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
						flag1=false;
						break;
					}
				}
				if(i==inputs.length()-1) {
					flag1=false;
					break;
				}
				
			}
			if(inputs.substring(i, i+1).equals("+")||inputs.substring(i, i+1).equals("-")||inputs.substring(i, i+1).equals("*")||inputs.substring(i, i+1).equals("/")) {
				if(i!=inputs.length()-1) {
					if(inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
						flag1=false;
						break;
					}
				}
				else if(i==0) {
					flag1=false;
					break;
				}
				else if(i==inputs.length()-1) {
					flag1=false;
					break;
				}
			}
		}
		if(countpar!=0) {
			flag1=false;
		}
		//input control
		Conversion a=new Conversion("");
		
		if(flag1){
			a =new Conversion(/*"1+6*9/4*(75-9)"*/inputs);
			a.printConversion();
			Calculate c=new Calculate(a.getNumbers());
			c.getResult();
			if((Integer)c.getNumbers().peek()==User_answer) {
				if(Math.abs(User_answer-targetNumber)<10) {
					playerScore+=15-(Math.abs(User_answer-targetNumber));
					System.out.println("\n--- Correct");
				}
				else {
					playerScore+=5;
					System.out.println("\n--- Correct");
				}
			}
			else {
				System.out.println("\n--- Wrong");
				if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
					compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
				}
				else {
					compScore+=5;
				}
			}
		}
		else {
			System.out.println("\n--- Wrong operation");
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
		}
		
	}
		System.out.println("Player Score : "+playerScore);
		System.out.println("Computer Score : "+compScore);
		turn++;
		}
		
		if(playerScore>=100) {
			System.out.println("Player won the game!");
		}
		else if(compScore>=100) {
			System.out.println("Computer won the game!");
		}
}
	public void normalRun() {
		int turn=1;
		while(playerScore!=100 && compScore!=100) {
		System.out.println("---------- ROUND "+turn+" ----------");
		Random rand = new Random();
		targetNumber=(int)((Math.random()*899)+100);
		digit1= rand.nextInt(9)+1;
		digit2= rand.nextInt(9)+1;
		digit3= rand.nextInt(9)+1;
		digit4= rand.nextInt(9)+1;
		digit5= rand.nextInt(9)+1;
		middle=rand.nextInt(4);
		System.out.println("Target number: "+targetNumber);
		if(middle==1)
			middle=25;
		else if(middle==2)
			middle=75;
		else if(middle==3)
			middle=50;
		else
			middle=100;
		System.out.print(digit1+" "+digit2+" "+digit3+" "+digit4+" "+digit5+" "+middle);
		ComputerNormal d=new ComputerNormal(digit1,digit2,digit3,digit4,digit5,middle,targetNumber);
		Solver Com_answer=d.getResult();
		System.out.println("\nPlease enter your number: ");
		int User_answer= scan.nextInt();
		System.out.println("Result numbers");
		System.out.println("      Player: "+User_answer+"   Computer: "+Com_answer.getResult());
		if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<Math.abs(User_answer-targetNumber)) {
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
			System.out.println("Computer's solution steps:");
			System.out.println(Com_answer.getSolve_step());
			System.out.println("--- Correct");
		}
		else {
			System.out.println("\nplease enter your Solve step");
			scan.nextLine();
			String inputs= scan.nextLine();
			boolean flag1 = true;
			int digit11 =0;
			int digit22 =0;
			int digit33 =0;
			int digit44 =0;
			int digit55 =0;
			int middlee=0;
			int countpar=0;
			
			for (int i = 0; i < inputs.length(); i++) {
				if(!inputs.substring(i,i+1).equals("/")&&!inputs.substring(i,i+1).equals("*")&&!inputs.substring(i,i+1).equals("+")&&!inputs.substring(i,i+1).equals("-")&&!inputs.substring(i,i+1).equals(")")&&!inputs.substring(i,i+1).equals("("))
					if(inputs.length()>=i+2&&!inputs.substring(i+1,i+2).equals("/")&&!inputs.substring(i+1,i+2).equals("*")&&!inputs.substring(i+1,i+2).equals("+")&&!inputs.substring(i+1,i+2).equals("-")&&!inputs.substring(i+1,i+2).equals(")")&&!inputs.substring(i+1,i+2).equals("(")) {
						if(inputs.length()>=i+3&&!inputs.substring(i+2,i+3).equals("/")&&!inputs.substring(i+2,i+3).equals("*")&&!inputs.substring(i+2,i+3).equals("+")&&!inputs.substring(i+2,i+3).equals("-")&&!inputs.substring(i+2,i+3).equals(")")&&!inputs.substring(i+2,i+3).equals("(")) {
							if(Integer.valueOf(inputs.substring(i,i+3))!=middle){
								flag1=false;
								
								
								break;
							}
							else{
								if(middlee==0){
								middlee++;
								i+=2;
							}
								else {
									flag1=false;
								break;}
							}
						}
						else {
						if(Integer.valueOf(inputs.substring(i,i+2))!=middle){
							flag1=false;
							break;
						}
						else{
							if(middlee==0){
								middlee++;
							
						
							i++;
							}	
							else {
								flag1=false;
							break;}
						}
						}
					}
					else {
						if(Integer.valueOf(inputs.substring(i,i+1))==digit1&&digit11==0){
						digit11++;
					}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit2&&digit22==0){
							digit22++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit3&&digit33==0){
							digit33++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit4&&digit44==0){
							digit44++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit5&&digit55==0){
							digit55++;
						}
						else{
							flag1=false;
							break;
						}
						
								
						
					}
				//input control
				if(inputs.substring(i,i+1).equals(")")){
					countpar++;
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals("(")) {
							flag1=false;
							break;
						}
					}
					if(i==0) {
						flag1=false;
						break;
					}
					if(inputs.substring(i-1,i).equals("+")|| inputs.substring(i-1,i).equals("-")|| inputs.substring(i-1,i).equals("*")|| inputs.substring(i-1,i).equals("/")) {
						flag1=false;
						break;
					}
				}
				if(inputs.substring(i,i+1).equals("(")){
					countpar--;
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals(")")|| inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
							flag1=false;
							break;
						}
					}
					if(i==inputs.length()-1) {
						flag1=false;
						break;
					}
					
				}
				if(inputs.substring(i, i+1).equals("+")||inputs.substring(i, i+1).equals("-")||inputs.substring(i, i+1).equals("*")||inputs.substring(i, i+1).equals("/")) {
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
							flag1=false;
							break;
						}
					}
					else if(i==0) {
						flag1=false;
						break;
					}
					else if(i==inputs.length()-1) {
						flag1=false;
						break;
					}
				}
			}
			if(countpar!=0) {
				flag1=false;
			}
			//input control
		Conversion a=new Conversion("");
		
		if(flag1){
			 a =new Conversion(/*"1+6*9/4*(75-9)"*/inputs);
			a.printConversion();
			Calculate c=new Calculate(a.getNumbers());
			c.getResult();
			if((Integer)c.getNumbers().peek()==User_answer) {
				if(Math.abs(User_answer-targetNumber)<10) {
					playerScore+=15-(Math.abs(User_answer-targetNumber));
					System.out.println("\n--- Correct");
				}
				else {
					playerScore+=5;
					System.out.println("\n--- Correct");
				}
			}
			else {
				System.out.println("\n--- Wrong");
				if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
					compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
				}
				else {
					compScore+=5;
				}
			}
		}
		else {
			System.out.println("\n--- Wrong operation");
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
		}
		
	}
		System.out.println("Player Score : "+playerScore);
		System.out.println("Computer Score : "+compScore);
		turn++;
		}
		if(playerScore>=100) {
			System.out.println("Player won the game!");
		}
		else if(compScore>=100) {
			System.out.println("Computer won the game!");
		}
	}
	public void hardRun() {
		int turn=1;
		while(playerScore!=100 && compScore!=100) {
		System.out.println("---------- ROUND "+turn+" ----------");
		Random rand = new Random();
		targetNumber=(int)((Math.random()*899)+100);
		digit1= rand.nextInt(9)+1;
		digit2= rand.nextInt(9)+1;
		digit3= rand.nextInt(9)+1;
		digit4= rand.nextInt(9)+1;
		digit5= rand.nextInt(9)+1;
		middle=rand.nextInt(4);
		System.out.println("Target number: "+targetNumber);
		if(middle==1)
			middle=25;
		else if(middle==2)
			middle=75;
		else if(middle==3)
			middle=50;
		else
			middle=100;
		System.out.print(digit1+" "+digit2+" "+digit3+" "+digit4+" "+digit5+" "+middle);
		ComputerAi d=new ComputerAi(digit1,digit2,digit3,digit4,digit5,middle,targetNumber);
		Solver Com_answer=d.getResult();
		System.out.println("\nPlease enter your number: ");
		int User_answer= scan.nextInt();
		System.out.println("Result numbers");
		System.out.println("      Player: "+User_answer+"   Computer: "+Com_answer.getResult());
		if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<Math.abs(User_answer-targetNumber)) {
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
			System.out.println("Computer's solution steps:");
			System.out.println(Com_answer.getSolve_step());
			System.out.println("--- Correct");
		}
		else {
			System.out.println("\nplease enter your Solve step");
			scan.nextLine();
			String inputs= scan.nextLine();
			boolean flag1 = true;
			int digit11 =0;
			int digit22 =0;
			int digit33 =0;
			int digit44 =0;
			int digit55 =0;
			int middlee=0;
			int countpar=0;
			
			for (int i = 0; i < inputs.length(); i++) {
				if(!inputs.substring(i,i+1).equals("/")&&!inputs.substring(i,i+1).equals("*")&&!inputs.substring(i,i+1).equals("+")&&!inputs.substring(i,i+1).equals("-")&&!inputs.substring(i,i+1).equals(")")&&!inputs.substring(i,i+1).equals("("))
					if(inputs.length()>=i+2&&!inputs.substring(i+1,i+2).equals("/")&&!inputs.substring(i+1,i+2).equals("*")&&!inputs.substring(i+1,i+2).equals("+")&&!inputs.substring(i+1,i+2).equals("-")&&!inputs.substring(i+1,i+2).equals(")")&&!inputs.substring(i+1,i+2).equals("(")) {
						if(inputs.length()>=i+3&&!inputs.substring(i+2,i+3).equals("/")&&!inputs.substring(i+2,i+3).equals("*")&&!inputs.substring(i+2,i+3).equals("+")&&!inputs.substring(i+2,i+3).equals("-")&&!inputs.substring(i+2,i+3).equals(")")&&!inputs.substring(i+2,i+3).equals("(")) {
							if(Integer.valueOf(inputs.substring(i,i+3))!=middle){
								flag1=false;
								
								
								break;
							}
							else{
								if(middlee==0){
								middlee++;
								i+=2;
							}
								else {
									flag1=false;
								break;}
							}
						}
						else {
						if(Integer.valueOf(inputs.substring(i,i+2))!=middle){
							flag1=false;
							break;
						}
						else{
							if(middlee==0){
								middlee++;
							
						
							i++;
							}	
							else {
								flag1=false;
							break;}
						}
						}
					}
					else {
						if(Integer.valueOf(inputs.substring(i,i+1))==digit1&&digit11==0){
						digit11++;
					}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit2&&digit22==0){
							digit22++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit3&&digit33==0){
							digit33++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit4&&digit44==0){
							digit44++;
						}
						else if(Integer.valueOf(inputs.substring(i,i+1))==digit5&&digit55==0){
							digit55++;
						}
						else{
							flag1=false;
							break;
						}
						
								
						
					}
				//input control
				if(inputs.substring(i,i+1).equals(")")){
					countpar++;
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals("(")) {
							flag1=false;
							break;
						}
					}
					if(i==0) {
						flag1=false;
						break;
					}
					if(inputs.substring(i-1,i).equals("+")|| inputs.substring(i-1,i).equals("-")|| inputs.substring(i-1,i).equals("*")|| inputs.substring(i-1,i).equals("/")) {
						flag1=false;
						break;
					}
				}
				if(inputs.substring(i,i+1).equals("(")){
					countpar--;
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals(")")|| inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
							flag1=false;
							break;
						}
					}
					if(i==inputs.length()-1) {
						flag1=false;
						break;
					}
					
				}
				if(inputs.substring(i, i+1).equals("+")||inputs.substring(i, i+1).equals("-")||inputs.substring(i, i+1).equals("*")||inputs.substring(i, i+1).equals("/")) {
					if(i!=inputs.length()-1) {
						if(inputs.substring(i+1,i+2).equals("+")|| inputs.substring(i+1,i+2).equals("-")|| inputs.substring(i+1,i+2).equals("*")|| inputs.substring(i+1,i+2).equals("/")) {
							flag1=false;
							break;
						}
					}
					else if(i==0) {
						flag1=false;
						break;
					}
					else if(i==inputs.length()-1) {
						flag1=false;
						break;
					}
				}
			}
			if(countpar!=0) {
				flag1=false;
			}
			//input control
		Conversion a=new Conversion("");
		
		if(flag1){
			 a =new Conversion(/*"1+6*9/4*(75-9)"*/inputs);
			a.printConversion();
			Calculate c=new Calculate(a.getNumbers());
			c.getResult();
			if((Integer)c.getNumbers().peek()==User_answer) {
				if(Math.abs(User_answer-targetNumber)<10) {
					playerScore+=15-(Math.abs(User_answer-targetNumber));
					System.out.println("\n--- Correct");
				}
				else {
					playerScore+=5;
					System.out.println("\n--- Correct");
				}
			}
			else {
				System.out.println("\n--- Wrong");
				if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
					compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
				}
				else {
					compScore+=5;
				}
			}
		}
		else {
			System.out.println("\n--- Wrong operation");
			if(Math.abs((Integer)Com_answer.getResult()-targetNumber)<10) {
				compScore+=15-(Math.abs((Integer)Com_answer.getResult()-targetNumber));
			}
			else {
				compScore+=5;
			}
		}
		
	}
		System.out.println("Player Score : "+playerScore);
		System.out.println("Computer Score : "+compScore);
		turn++;
		}
		if(playerScore>=100) {
			System.out.println("Player won the game!");
		}
		else if(compScore>=100) {
			System.out.println("Computer won the game!");
		}
}	
}
