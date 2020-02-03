package gamePanel;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GamePanel {
	
	static int Counter = 0;

	public static void main(String[] args) {
		
		//ProgrammFenster
	 JFrame mainmenu = new JFrame();
	 JLabel mainlabel = new JLabel();
	 mainmenu.setBounds(100,100,500,450);
	 mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 mainmenu.setTitle("KekseKlicker");
	 mainmenu.setContentPane(mainlabel);
	 mainlabel.setBorder(new EmptyBorder(5,5,5,5));
	 mainlabel.setLayout(null);
	 
	 //Geklickte Cookies anzeigen!
	 TextField cookies = new TextField();
	 cookies.setText(Counter + "");
	 cookies.setEditable(false);
	 cookies.setVisible(true);
	 cookies.setBounds(200,50,100,100);
	 mainlabel.add(cookies);
	   
	 
	 //CookieNummer 1 +1
	 JButton Cookie1 = new JButton("Klick mich blyat");
	 Cookie1.setBounds(200,200,100,100);
	 Cookie1.setVisible(true);
	 Cookie1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Counter +=1;
			cookies.setText(Counter + "");
			if(Counter > 10) {
				System.out.println("Spieler hat Counter 1 erfüllt!");
			}
		}
		 
	 });
	 mainlabel.add(Cookie1);
	 
	 
	 
	 //CookieNummer 2 +5
	 JButton Cookie2 = new JButton("Klick mich blyat");
	 Cookie2.setBounds(0,0,100,100);
	 Cookie2.setVisible(false);
	 mainlabel.add(Cookie2);
	 
	 
	 
	 //Dont DELET!!!!
		mainmenu.setVisible(true);
	}

}
