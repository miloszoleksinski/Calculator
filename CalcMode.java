public class CalcMode
{
	private double number = 0;
	
	synchronized public void addNumbers(double num1,double num2) { this.number = num1 + num2; }
	synchronized public void subtractNumbers(double num1,double num2){ this.number = num1 - num2; }
	synchronized public void multiplyNumbers(double num1,double num2){ this.number = num1 * num2; }
	synchronized public void divideNumbers(double num1,double num2){ this.number = num1 / num2; }
	
	public double getNumber() { return this.number; }
	private boolean x = false;
	public void setX(boolean x) {this.x=x;}
	public boolean getX() {return this.x;}
}