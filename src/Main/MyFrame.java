package Main;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
	JButton bt1,bt2,btnMethod1,btnMethod2,btnMethod3,btnMethod4;
	File file;
	public MyFrame(String name,JLabel lb) {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x123456));
		panel.setLayout(null);
		
		/*bt1 = new JButton("Creat a new FILE");
		bt1.setFocusable(false);
		bt1.setBounds(100, 270, 300, 50);
		bt1.addActionListener(this);
		//this.add(bt1);*/


		lb.setBounds(100,10,300,200);
		panel.add(lb);
		
	    bt2 = new JButton("Select an existing FILE");
		bt2.setFocusable(false);
		bt2.setBounds(100, 350, 300, 50);
		bt2.addActionListener(this);
		panel.add(bt2);



		
		this.setTitle(name);
		this.setSize(500,500);
		this.add(panel);
		this.setResizable(false);
		this.setBackground(new Color(0x123456));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*if(arg0.getSource() == bt1) {
				JLabel labelDiscrubtion = new JLabel();
				labelDiscrubtion.setText("Discribtion : put your text to encrypt and the result will be saved in a file");
				labelDiscrubtion.setHorizontalAlignment(JLabel.CENTER);
				labelDiscrubtion.setFont(new Font("MV Boli",Font.BOLD,10));
				labelDiscrubtion.setBounds(0,10,500,50);
				
				JTextField textField = new JTextField();
				textField.setFont(new Font("Elephant",Font.PLAIN,28));
				textField.setBounds(5,55,490,70);
				
				
				
				
				JFrame frame1 = new JFrame();
				frame1.add(labelDiscrubtion);
				frame1.add(textField);
				frame1.setSize(500,500);
				frame1.setResizable(false);
				frame1.setLayout(null);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
				
			
		}*/
		if(arg0.getSource() == bt2) {
				JFileChooser fileChooser = new JFileChooser();
				int respond = fileChooser.showOpenDialog(null);
				if (respond == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					file = new File(filePath);
					carreOn();
		
					
				}
				
		}
		
		// Method buttons
		if(arg0.getSource() == btnMethod1) {
			String key = JOptionPane.showInputDialog("What key to use with vigenere ? ( KEY IS A STRING )");
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
		    String line = bufferedReader.readLine();
		    while(line != null) {
		    	Encryption.vigenere(line, key);
		        line = bufferedReader.readLine();
		    }
		} catch (FileNotFoundException e) {
				System.out.println("file not found");
		} catch (IOException e) {
				System.out.println(e);
		}
			
		}
		if(arg0.getSource() == btnMethod2) {
			String paraghraphe = "";
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
		    String line = bufferedReader.readLine();
		    while(line != null) {
		        paraghraphe = paraghraphe + line;
		        line = bufferedReader.readLine();
		    }

	    	Encryption.reverce(paraghraphe);;
		} catch (FileNotFoundException e) {
				System.out.println("file not found");
		} catch (IOException e) {
				System.out.println(e);
		}
			
		}
		if(arg0.getSource() == btnMethod3) {
			int keyint = Integer.parseInt(JOptionPane.showInputDialog("What key to use with vigenere ? ( KEY IS AN INTEGER )"));
			try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
		    String line = bufferedReader.readLine();
		    while(line != null) {
		    	Encryption.encrept(line, keyint);;
		        line = bufferedReader.readLine();
		    }
		} catch (FileNotFoundException e) {
				System.out.println("file not found");
		} catch (IOException e) {
				System.out.println(e);
		}
			
		}
		
	}


	private void carreOn() {
		JLabel labelMenu = new JLabel();
		labelMenu.setText("Select which method to encrypt with");
		labelMenu.setHorizontalAlignment(JLabel.CENTER);
		labelMenu.setFont(new Font("MV Boli",Font.BOLD,12));
		labelMenu.setBounds(0,10,350,50);
		
		JLabel labelNote = new JLabel();
		labelNote.setText("The result will be saved in a file 'MethodName.txt' on the Desktop");
		labelNote.setHorizontalAlignment(JLabel.CENTER);
		labelNote.setFont(new Font("MV Boli",Font.ITALIC,10));
		labelNote.setBounds(0,320,350,50);
		
		btnMethod1 = new JButton("Vigenere");
		btnMethod1.setFocusable(false);
		btnMethod1.setBounds(10, 110, 140, 50);
		btnMethod1.addActionListener(this);
		
		btnMethod2 = new JButton("Reverce");
		btnMethod2.setFocusable(false);
		btnMethod2.setBounds(200, 110, 140, 50);
		btnMethod2.addActionListener(this);
		
		btnMethod3 = new JButton("Encrept");
		btnMethod3.setFocusable(false);
		btnMethod3.setBounds(105, 190, 140, 50);
		btnMethod3.addActionListener(this);

		/*btnMethod4 = new JButton("RSA");
		btnMethod4.setFocusable(false);
		btnMethod4.setBounds(200, 210, 140, 50);
		btnMethod4.addActionListener(this);*/
		
		JFrame frame2 = new JFrame();
		frame2.add(labelMenu);
		frame2.add(labelNote);
		frame2.add(btnMethod1);
		frame2.add(btnMethod2);
		frame2.add(btnMethod3);
		//frame2.add(btnMethod4);
		frame2.setSize(350,400);
		frame2.setResizable(false);
		frame2.setLayout(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		
	}
	
		
}
