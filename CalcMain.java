import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JFrame;

public class CalcMain
{
	public static void main(String[] args)
	{
		UserInterFace userInterface = new UserInterFace(); // interface
		CalcMode calc = new CalcMode();
		MenuController menu = new MenuController(userInterface,calc);
		userInterface.setVisible(true);
	} // main thread
} // main class