import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class MenuController
{
	private UserInterFace userInterface;
	private CalcMode calc;
	private Thread myThread = null;
	
	public MenuController(UserInterFace userInterface,CalcMode calc)
	{
		this.userInterface = userInterface;
		this.calc = calc;
		
		this.userInterface.calculatorButtonListener(new CalculatorAction());
		this.userInterface.exitCalculatorButtonListener(new ExitCalculatorAction());
	}
	
	class CalculatorAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setContentPane(userInterface.calculatorPanel);
			userInterface.pack();
			userInterface.setSize(400,150);
			if(calc.getX()==false)
			{
				myThread = new Thread(new CalcThread(userInterface,calc));
				myThread.start();
			}else{}
		}
	} // calculator listener

	class ExitCalculatorAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.dispatchEvent(new WindowEvent(userInterface, WindowEvent.WINDOW_CLOSING));
		}
	} 

	
	
}