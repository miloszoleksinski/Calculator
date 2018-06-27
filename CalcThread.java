public class CalcThread implements Runnable
{
	private UserInterFace userInterface;
	private CalcMode calc;
	
	public CalcThread(UserInterFace userInterface,CalcMode calc)
	{
		this.userInterface = userInterface;
		this.calc=calc;
	}
	
	public void run()
	{
		CalcController controller = new CalcController(userInterface,calc);	
	}
}