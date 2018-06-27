import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterFace extends JFrame
{
	//menu\\ 
	JPanel centerMenu = new JPanel(new GridLayout(2,1));
	JPanel centerTFpanel = new JPanel();
	private JLabel textMenu = new JLabel("Choose your app");
	JPanel appButtonsPanel = new JPanel(new GridLayout(1,2));
	private JButton calculatorApp = new JButton("Calculator");
	private JButton exit = new JButton("Exit");
	//menu\\
	
	//calculator\\
	JPanel calculatorPanel = new JPanel();
	private boolean boolError = false;
	private static int errorCounter = 0;
	private JTextField firstNum = new JTextField(10);
	private JLabel countSign = new JLabel("   ");
	private JTextField secondNum = new JTextField(10);
	private JLabel isEqual = new JLabel(" = ");
	private JTextField result = new JTextField(10);
	//buttons
	private JButton equal = new JButton("=");
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton multiply = new JButton("*");
	private JButton divide = new JButton("/");
	JPanel backPanel = new JPanel();
	private JButton backCalc = new JButton("Back");
	//calculator\\
	
	public UserInterFace()
	{
		this.setTitle("Calculator");
		this.setSize(400, 150);
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  // *** this will center  app ***
		
		//menu\\
		centerTFpanel.add(textMenu, SwingConstants.CENTER);
		appButtonsPanel.add(calculatorApp);
		appButtonsPanel.add(exit);
		centerMenu.add(centerTFpanel);
		centerMenu.add(appButtonsPanel);
		this.add(centerMenu,BorderLayout.CENTER);
		//menu\\
		
		//calculator\\
		calculatorPanel.add(firstNum);
		calculatorPanel.add(countSign);
		calculatorPanel.add(secondNum);
		calculatorPanel.add(isEqual);
		calculatorPanel.add(result);
		result.setText("0,00");
		// buttons
		calculatorPanel.add(plus);
		calculatorPanel.add(minus);
		calculatorPanel.add(multiply);
		calculatorPanel.add(divide);
		calculatorPanel.add(equal);
		backPanel.add(backCalc,BorderLayout.SOUTH);
		calculatorPanel.add(backPanel);
		//calculator\\
	}
	
	// --------- MENU ---------- \\
	
	public void addMenuJPanel()
	{
		this.add(centerTFpanel,BorderLayout.NORTH);
		this.add(appButtonsPanel,BorderLayout.CENTER);
	}
	
	public void removeMenuJPanel()
	{
		this.remove(centerTFpanel);
		this.remove(appButtonsPanel);
	}

	public void calculatorButtonListener(ActionListener listener)
	{
		this.calculatorApp.addActionListener(listener);
	}
	
	public void exitCalculatorButtonListener(ActionListener listener)
	{
		this.exit.addActionListener(listener);
	}
	
	// --------- CALCULATOR ---------- \\
	public void addCalculatorPanel()
	{
		this.add(calculatorPanel);
	}
	
	public void removeCalculatorPanel()
	{
		this.remove(calculatorPanel);
	}
	
	// get values from text fields
	
	public double getFirstNumber()
	{
		String firstNumberValue = this.firstNum.getText();
		double firstNum = 0;
		try
		{
			firstNum = Double.parseDouble(firstNumberValue);
		}
		catch(NumberFormatException ex)
		{
			showMessageError("Enter valid numbers!\nUse dot '.' instead of comma ','");
			this.boolError = true;
			firstNum = 0;
		}
		return firstNum;
	}
	
	public double getSecondNumber()
	{
		String secondNumberValue = this.secondNum.getText();
		double secondNum = 0;
		try
		{
			secondNum = Double.parseDouble(secondNumberValue);
		}
		catch(NumberFormatException ex)
		{
			showMessageError("Enter valid numbers!\nUse dot '.' instead of comma ','");
			this.boolError = true;
			secondNum = 0;
		}
		return secondNum;
	}
	
	public double getResult()
	{
		String resultValue = this.result.getText();
		double result = Double.parseDouble(resultValue);
		return result;
	}
	
	public void setResult(String result)
	{
		this.result.setText( result );
		//Double.toString(result)
	}
	
	public void setSign(String sign)
	{
		this.countSign.setText(sign);
	}
	
	public String getSign()
	{
		return this.countSign.getText();
	}
	
	// adding buttonListeners
	
	public void plusButtonListener(ActionListener listener)
	{
		this.plus.addActionListener(listener);
	}
	
	public void minusButtonListener(ActionListener listener)
	{
		this.minus.addActionListener(listener);
	}
	
	public void multiplyButtonListener(ActionListener listener)
	{
		this.multiply.addActionListener(listener);
	}
	
	public void divideButtonListener(ActionListener listener)
	{
		this.divide.addActionListener(listener);
	}
	
	public void equalButtonListener(ActionListener listener)
	{
		this.equal.addActionListener(listener);
	}

	public void backButtonListener(ActionListener listener)
	{
		this.backCalc.addActionListener(listener);
	}
	
	// message error
	public void showMessageError(String text)
	{
		
		if( this.errorCounter==0 )
		{
			errorCounter++;
			JOptionPane.showMessageDialog( null, text );
		}
	}

	public void setErrorCounter(int index)
	{
		this.errorCounter = index;
	}

	public void setBoolError(boolean trueorfalse) { this.boolError = trueorfalse; }
	
	public boolean getBoolError() { return this.boolError; }
	
	// --------- CALCULATOR ---------- \\
	
	
}