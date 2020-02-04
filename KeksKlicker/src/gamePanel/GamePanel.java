package gamePanel;


import java.awt.Color;
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
	JButton Cookie1 = new JButton();
	JButton Cookie2 = new JButton();
	Image hintergrund = new ImageIcon(GamePanel.class.getResource("/mgrund.png")).getImage();	
		//ProgrammFenster
	 JFrame mainmenu = new JFrame();
	 JLabel mainlabel = new JLabel();
	 mainmenu.setBounds(100,100,450,500);
	 mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 mainmenu.setTitle("KekseKlicker");
	 mainlabel.setIcon(new ImageIcon(hintergrund));
	 mainmenu.setBackground(Color.BLACK);
	 
	 mainlabel.setBorder(new EmptyBorder(5,5,5,5));
	 mainlabel.setLayout(null);
	 mainmenu.setContentPane(mainlabel);
	 
	
	 
	 
	 //Geklickte Cookies anzeigen!
	 JTextField cookies = new JTextField();
	 cookies.setFont(acookies);
	 cookies.setText( Counter + " Kekse");
	 cookies.setEditable(false);
	 cookies.setVisible(true);
	 cookies.setBounds(280,30,100,130);
	 cookies.setBorder(null);
	 cookies.setForeground(Color.white);
	 cookies.setBackground(Color.BLACK);
	 mainlabel.add(cookies);
	 
	 //upgrade fehlgeschlagen zuwenige Cookies
	 JTextField ufalses = new JTextField();
	 ufalses.setText("Du benötigst 150 Kekse");
	 ufalses.setBounds(0,200,150,100);
	 //ufalses.setVisible(true);
	 ufalses.setForeground(Color.WHITE);
	 ufalses.setBackground(Color.BLACK);
	 ufalses.setEditable(false);
	 ufalses.setBorder(null);
	 ufalses.setVisible(false);
	 mainlabel.add(ufalses);
	 
	 //upgrade knopf
	 Image upgradetrue = new ImageIcon(GamePanel.class.getResource("/utrue.png")).getImage();
	 Image upgradefalse = new ImageIcon(GamePanel.class.getResource("/ufalse.png")).getImage();
	 
	 JButton upgrade = new JButton();
	 upgrade.setBounds(0,0,195,100);
	 
	 upgrade.setVisible(true);
	 upgrade.setIcon(new ImageIcon(upgradefalse));
	 upgrade.setContentAreaFilled(false);
	 upgrade.setBorder(null);
	 upgrade.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Counter += 0;
			if(Counter < 149) {
				ufalses.setVisible(true);
			}
			if(Counter > 149) {
				ufalses.setVisible(false);
				Cookie1.setVisible(false);
				upgrade.setVisible(false);
				upgrade.setIcon(new ImageIcon(upgradefalse));
				upgrade.setVisible(true);
				Cookie2.setVisible(true);
			}
		}
		 
	 });
	 
	 
	 mainlabel.add(upgrade);  
	 
	
	 
	 
	 //CookieNummer 1 +1
	//declart weiter oben
	 Cookie1.setBounds(125,160,100,100);
	 Cookie1.setVisible(true);
	 Cookie1.setBorder(null);
	 Cookie1.setContentAreaFilled(false);
	 Cookie1.addActionListener(new ActionListener() {
     
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Counter +=1;
			ufalses.setVisible(false);
			cookies.setText(Counter + " Kekse");
			if(Counter > 150) {
				upgrade.setIcon(new ImageIcon(upgradetrue));
			}
			if(Counter < 149) {
				
				upgrade.setVisible(true);
				upgrade.setIcon(new ImageIcon(upgradefalse));
			}
		}
		 
	 });
	 
	 Image CUKIE = new ImageIcon(GamePanel.class.getResource("/Cuukie.png")).getImage();
	 Cookie1.setSize(250,250);
	 
	 Cookie1.setIcon(new ImageIcon(CUKIE));
	 
	 mainlabel.add(Cookie1);
	 
	 
	 
	 //CookieNummer 2 +5
	 Cookie2.setBounds(125,160,100,100);
	 Cookie2.setVisible(false);
	 Cookie2.setBorder(null);
	 Cookie2.setContentAreaFilled(false);
	 Cookie2.addActionListener(new ActionListener() {
	     
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Counter +=5;
				cookies.setText(Counter + " Kekse");
				upgrade.setIcon(new ImageIcon(upgradefalse));
				upgrade.setVisible(true);
				
			}
			 
		 });
     Cookie2.setSize(250,250);
	 
	 Cookie2.setIcon(new ImageIcon(CUKIE));
	 
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
