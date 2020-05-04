package bitlab.askar.lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectionPage extends Container{
	private JLabel lbl;
	private JButton btn;
	private JTextField port;
	private JTextField ip;



	public ConnectionPage(){
		setSize(500,500);
		setLayout(null);

		lbl = new JLabel("Please, insert port and ip addess");
		lbl.setSize(300,30);
		lbl.setLocation(100,100);
		add(lbl);

		port = new JTextField("PORT");
		port.setSize(300,30);
		port.setLocation(100,140);
		add(port);

		ip = new JTextField("IP");
		ip.setSize(300,30);
		ip.setLocation(100,180);
		add(ip);

		btn = new JButton("CONNECT");
		btn.setSize(300,30);
		btn.setLocation(100,220);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String ipText = ip.getText();
				int portInt = 0;
				try{
					portInt = Integer.parseInt(port.getText());
				}catch(Exception ex){
					ex.printStackTrace();
				}

				boolean check = Main.connectToServer(ipText,portInt);
				if(check){
					Main.frame.showSecondPage();
				}
			}
		});
		add(btn);

	}
}