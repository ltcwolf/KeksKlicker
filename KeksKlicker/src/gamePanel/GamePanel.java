package gamePanel;


import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GamePanel {
	
	static int Counter = 0;

	
	static Font acookies = new Font(" Kekse", Font.BOLD, 20);


	public static void main(String[] args) {
	 
		
		//ProgrammFenster
	 JFrame mainmenu = new JFrame();
	 JLabel mainlabel = new JLabel(new ImageIcon(GamePanel.class.getResource("/mgrund.png")));
	 mainmenu.setBounds(100,100,500,450);
	 mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 mainmenu.setTitle("KekseKlicker");
	 mainlabel.setIcon(new ImageIcon("mgrung.png"));
	 
	 mainlabel.setBorder(new EmptyBorder(5,5,5,5));
	 mainlabel.setLayout(null);
	 mainmenu.setContentPane(mainlabel);
	 
	 //mainlabel.setIcon(new ImageIcon(GamePanel.class.getResource("/Cuukie.png")).getImage();
	 
	 
	 //Geklickte Cookies anzeigen!
	 JTextField cookies = new JTextField();
	 cookies.setFont(acookies);
	 cookies.setText(Counter + " Kekse");
	 cookies.setEditable(false);
	 cookies.setVisible(true);
	 cookies.setBounds(200,50,100,100);
	 cookies.setBorder(null);
	 
	 
	 mainlabel.add(cookies);
	   
	 
	 //CookieNummer 1 +1
	 JButton Cookie1 = new JButton();
	 Cookie1.setBounds(125,160,100,100);
	 Cookie1.setVisible(true);
	 Cookie1.setBorder(null);
	 Cookie1.setContentAreaFilled(false);
	 Cookie1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Counter +=1;
			
			cookies.setText(Counter + " Kekse");
			if(Counter > 10) {
				
			}
		}
		 
	 });
	 
	 Image CUKIE = new ImageIcon(GamePanel.class.getResource("/Cuukie.png")).getImage();
	 Cookie1.setSize(250,250);
	 
	 Cookie1.setIcon(new ImageIcon(CUKIE));
	 
	 mainlabel.add(Cookie1);
	 
	 
	 
	 //CookieNummer 2 +5
	 JButton Cookie2 = new JButton("Klick mich blyat");
	 Cookie2.setBounds(0,0,100,100);
	 Cookie2.setVisible(false);
	 mainlabel.add(Cookie2);
	 
	 
	 
	 //Option
	 MenuBar Options = new MenuBar();
	 Menu option = new Menu("Optionen");
	 MenuItem savegame = new MenuItem("Spielspeichern");
	 MenuItem loadgame = new MenuItem("Spielladen");
	 option.add(savegame);
	 option.add(loadgame);
	 
	 savegame.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Writer spielstand = new FileWriter("save.txt");
				spielstand.write(Counter+ "");
				spielstand.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
	 });
	 
	 loadgame.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Scanner s = new Scanner(new File("save.txt"));
				Counter = s.nextInt();
				cookies.setText(Counter + " Kekse");
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		 
	 });
	 
	 Options.add(option);
	 mainmenu.setMenuBar(Options);
	 
	 
	 
	 //Dont DELETE!!!!|| Nicht Löschen Blyat
	    
		mainmenu.setVisible(true);
	}

}
