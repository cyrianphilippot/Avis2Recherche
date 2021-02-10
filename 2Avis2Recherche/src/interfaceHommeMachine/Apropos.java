package interfaceHommeMachine;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Apropos extends JDialog{
	private JOptionPane jop = new JOptionPane();
	private String str;
	ImageIcon img = new ImageIcon("images/prj_ynov.jpg");
	JOptionPane jop1 = new JOptionPane(), jop2 = new JOptionPane();
	
	public Apropos(){
		
		str = "Réaliser par : \n";
		str += "\t"+"Avis2Recherche\n"; 
		jop.showMessageDialog( null, str,"A propos...", JOptionPane. INFORMATION_MESSAGE, img); 
		
	}
	
}