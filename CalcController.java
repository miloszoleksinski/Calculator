import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CalcController
{
	private java.text.DecimalFormat df=new java.text.DecimalFormat("0.00");
	private UserInterFace userInterface;
	private CalcMode calc;
	
	public CalcController(UserInterFace userInterface,CalcMode calc)
	{
		this.userInterface = userInterface;
		this.calc = calc;
		
		this.userInterface.plusButtonListener( new plusButtonListener() );
		this.userInterface.minusButtonListener( new minusButtonListener() );
		this.userInterface.multiplyButtonListener( new multiplyButtonListener() );
		this.userInterface.divideButtonListener( new divideButtonListener() );
		this.userInterface.equalButtonListener( new equalButtonListener() );
		this.userInterface.backButtonListener( new backButtonListener() );
	}
	
	class plusButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setSign(" + ");
		}	
	}
	
	class minusButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setSign(" - ");
		}	
	}
	
	class multiplyButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setSign(" * ");
		}	
	}
	
	class divideButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setSign(" / ");
		}	
	}
	
	class equalButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{
			double firstNum = userInterface.getFirstNumber();
			double secondNum = userInterface.getSecondNumber();
			
			if(userInterface.getSign().equals("   ")) // if no sign
			{
				userInterface.showMessageError("Choose operation. (+,-,*,/)");
				userInterface.setResult("0,00");
			}
			
			else if(userInterface.getSign().equals(" + ")) // if summing
			{
				if( userInterface.getBoolError() == true )
				{
					userInterface.setResult("0,00");
				}
				else
				{
					calc.addNumbers( firstNum , secondNum );
					double num = calc.getNumber();
					userInterface.setResult( df.format(num) );
				}
			}
			
			else if(userInterface.getSign().equals(" - ")) // if subtracting
			{
				if( userInterface.getBoolError() == true )
				{
					userInterface.setResult("0,00");
				}
				else
				{
					calc.subtractNumbers( firstNum ,secondNum );
					double num = calc.getNumber();
					userInterface.setResult( df.format(num) );	
				}
			}
			
			else if(userInterface.getSign().equals(" * ")) // if multiplying
			{
				calc.multiplyNumbers( firstNum , secondNum );
				double num = calc.getNumber();
				userInterface.setResult( df.format(num) );
			}
			
			else if(userInterface.getSign().equals(" / ")) // if dividing
			{
				if( secondNum == 0 )
				{
					userInterface.showMessageError("Don't divide by zero");
					userInterface.setResult("Error");
				}
				else if( firstNum == 0 )
				{
					userInterface.setResult("0.00");
				}
				else
				{
					calc.divideNumbers( firstNum , secondNum );
					double num = calc.getNumber();
					userInterface.setResult( df.format(num) );
				}
			}
			
			userInterface.setErrorCounter(0);
			userInterface.setBoolError(false);
		}	
	}

	class backButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userInterface.setContentPane(userInterface.centerMenu);	
			calc.setX(true);
		}	
	}

	
}




