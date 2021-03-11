import java.util.Random;

public class ComputerAi {
	private int [] numbers= {0,0,0,0,0,0};
	private int result=0;
	private Solver temp_solve=new Solver(0);
	private int rannum1;
	private int rannum2;
	
	public ComputerAi(int digit1,int digit2,int digit3,int digit4,int digit5,int middlenumber,int bignumber){
		this.numbers[0]=digit1;
		this.numbers[1]=digit2;
		this.numbers[2]=digit3;
		this.numbers[3]=digit4;
		this.numbers[4]=digit5;
		this.numbers[5]=middlenumber;
		this.result=bignumber;
		
		
		
	}
	public Solver getResult() {
		Solver [] number =new Solver[6];
		Random random=new Random();
		Solver num1=new Solver(0);
		Solver num2=new Solver(0);
		
		int ope=0;
		int counter=0;
		int counter1=30;
		long StartTime=System.currentTimeMillis();
		long EndTime=StartTime+31000;
		System.out.print("\nDuration: ");
		Solver solver=null;
		while(counter1!=0) {
			if((int)(EndTime-System.currentTimeMillis())/1000==counter1){
				System.out.print(counter1+" ");
				counter1--;
			}
			boolean finish_checker=false;
			
			solver=null;
			
			for(int i=0;i<numbers.length;i++) {
				solver=new Solver(numbers[i]);
				number[i]=solver;
			}
			while(!finish_checker) {
			rannum1=0;
			rannum2=0;
			ope=random.nextInt(4);
			while(rannum1==rannum2||number[rannum1].getSolve_step().equals("empty")||number[rannum2].getSolve_step().equals("empty")) {
				rannum1=random.nextInt(number.length);
				rannum2=random.nextInt(number.length);;
			}	
			num1=number[rannum1];
			num2=number[rannum2];
			
			if(ope==0) {
				if (!num1.step_chacker()&&!num2.step_chacker()) {
				solver=new Solver(num1.getResult()-num2.getResult(),num1.getResult()+"-"+num2.getResult()+"="+(num1.getResult()-num2.getResult()));
				number[rannum1]=new Solver(0,"empty");
				number[rannum2]=solver;
				}
				else if(num1.step_chacker()&&!num2.step_chacker()) {
					solver=new Solver(num1.getResult()-num2.getResult(),num1.getSolve_step()+"\n"+num1.getResult()+"-"+num2.getResult()+"="+(num1.getResult()-num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
				}
				else if(!num1.step_chacker()&&num2.step_chacker()) {
					solver=new Solver(num1.getResult()-num2.getResult(),num2.getSolve_step()+"\n"+num1.getResult()+"-"+num2.getResult()+"="+(num1.getResult()-num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
				}
				else {
					solver=new Solver(num1.getResult()-num2.getResult(),num1.getSolve_step()+"\n"+num2.getSolve_step()+"\n"+num1.getResult()+"-"+num2.getResult()+"="+(num1.getResult()-num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
				}
					
			}
			else if (ope==1) {
				if (!num1.step_chacker()&&!num2.step_chacker()) {
					solver=new Solver(num1.getResult()+num2.getResult(),num1.getResult()+"+"+num2.getResult()+"="+(num1.getResult()+num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
					}
					else if(num1.step_chacker()&&!num2.step_chacker()) {
						solver=new Solver(num1.getResult()+num2.getResult(),num1.getSolve_step()+"\n"+num1.getResult()+"+"+num2.getResult()+"="+(num1.getResult()+num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
					else if(!num1.step_chacker()&&num2.step_chacker()) {
						solver=new Solver(num1.getResult()+num2.getResult(),num2.getSolve_step()+"\n"+num1.getResult()+"+"+num2.getResult()+"="+(num1.getResult()+num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
					else {
						solver=new Solver(num1.getResult()+num2.getResult(),num1.getSolve_step()+"\n"+num2.getSolve_step()+"\n"+num1.getResult()+"+"+num2.getResult()+"="+(num1.getResult()+num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
			}
			else if (ope==2) {
				if (!num1.step_chacker()&&!num2.step_chacker()) {
					solver=new Solver(num1.getResult()*num2.getResult(),num1.getResult()+"*"+num2.getResult()+"="+(num1.getResult()*num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
					}
					else if(num1.step_chacker()&&!num2.step_chacker()) {
						solver=new Solver(num1.getResult()*num2.getResult(),num1.getSolve_step()+"\n"+num1.getResult()+"*"+num2.getResult()+"="+(num1.getResult()*num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
					else if(!num1.step_chacker()&&num2.step_chacker()) {
						solver=new Solver(num1.getResult()*num2.getResult(),num2.getSolve_step()+"\n"+num1.getResult()+"*"+num2.getResult()+"="+(num1.getResult()*num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
					else {
						solver=new Solver(num1.getResult()*num2.getResult(),num1.getSolve_step()+"\n"+num2.getSolve_step()+"\n"+num1.getResult()+"*"+num2.getResult()+"="+(num1.getResult()*num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
			}
			else {
				if (!num1.step_chacker()&&!num2.step_chacker()) {
					if(num2.getResult()!=0) {
					solver=new Solver(num1.getResult()/num2.getResult(),num1.getResult()+"/"+num2.getResult()+"="+(num1.getResult()/num2.getResult()));
					number[rannum1]=new Solver(0,"empty");
					number[rannum2]=solver;
					}
					}
					else if(num1.step_chacker()&&!num2.step_chacker()) {
						if(num2.getResult()!=0) {
						solver=new Solver(num1.getResult()/num2.getResult(),num1.getSolve_step()+"\n"+num1.getResult()+"/"+num2.getResult()+"="+(num1.getResult()/num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
						}
					}
					else if(!num1.step_chacker()&&num2.step_chacker()) {
						if(num2.getResult()!=0) {
						solver=new Solver(num1.getResult()/num2.getResult(),num2.getSolve_step()+"\n"+num1.getResult()+"/"+num2.getResult()+"="+(num1.getResult()/num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
						}
					}
					else {
						if(num2.getResult()!=0) {
						solver=new Solver(num1.getResult()/num2.getResult(),num1.getSolve_step()+"\n"+num2.getSolve_step()+"\n"+num1.getResult()+"/"+num2.getResult()+"="+(num1.getResult()/num2.getResult()));
						number[rannum1]=new Solver(0,"empty");
						number[rannum2]=solver;
					}
				}
			}
			int temp=Math.abs(temp_solve.getResult()-result);
			int solve=Math.abs(solver.getResult()-result);
			if(solve<temp) {
				temp_solve=solver;				
			}
			counter=0;
		for(int i=0;i<number.length;i++) {
			if(number[i].getSolve_step().equals("empty"))
				counter++;
				
		}
		if(counter>4)
			finish_checker=true;
		}
			
		}
		//System.out.println(temp_solve.getSolve_step());
		return temp_solve;
	}
}