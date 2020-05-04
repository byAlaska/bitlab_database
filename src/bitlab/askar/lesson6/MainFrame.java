package bitlab.askar.lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame{
	private ConnectionPage first;
	private InteractionPage second;
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bitlab application");
		setSize(500,500);
		
		first = new ConnectionPage();
		first.setLocation(0,0);
		add(first);

		second = new InteractionPage();
		second.setLocation(0,0);
		second.setVisible(false);
		add(second);
	}


	public void showSecondPage(){
		first.setVisible(false);
		second.setVisible(true);
	}

	public void showFirstPage(){
		second.setVisible(false);
		first.setVisible(true);
		
	}
}