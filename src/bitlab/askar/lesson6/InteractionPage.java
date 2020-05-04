package bitlab.askar.lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InteractionPage extends Container{
	private JLabel lbl;
	private JButton btn;
	private JTextField message;
	public InteractionPage(){
		setSize(500,500);
		setLayout(null);

		lbl = new JLabel("Please, insert your message");
		lbl.setSize(300,30);
		lbl.setLocation(100,100);
		add(lbl);

		message = new JTextField();
		message.setSize(300,30);
		message.setLocation(100,140);
		add(message);

		btn = new JButton("SUBMIT");
		btn.setSize(300,30);
		btn.setLocation(100,180);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String messageText = message.getText();
				Main.sendMessage(messageText);
				message.setText("");

			}
		});
		add(btn);
	}

}