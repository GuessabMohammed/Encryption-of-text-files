package Main;



import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {


	public static void main(String[] args) {
			ImageIcon img = new ImageIcon("src/locked.png");
			
			JLabel label = new JLabel();
			label.setIcon(img);
			new MyFrame("Encryption",label);
			
		
		
		
	}
}
