
public class Solver {
	private int result;
	private String solve_step;
	public Solver(int result, String solve_step) {
		this.setResult(result);
		this.setSolve_step(solve_step);
	}
	public Solver(int result) {
		this.result=result;
		this.solve_step=" ";
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getSolve_step() {
		return solve_step;
	}
	public void setSolve_step(String solve_step) {
		this.solve_step = solve_step;
	}
	public boolean step_chacker() {
		if(solve_step.equals(" "))
			return false;
		else 
			return true;
		
	}
	
}
