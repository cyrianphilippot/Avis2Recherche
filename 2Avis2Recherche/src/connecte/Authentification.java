package connecte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Authentification extends JFrame {
	
	private JPanel panJ = new JPanel();
	private JPanel pan = new JPanel();
	
	private JLabel loginZ = new JLabel();
	private JLabel passZ = new JLabel();
	
	private JTextField loginX = new JTextField();
	private JPasswordField passX = new JPasswordField();
	
	private JButton ok = new JButton();
	private JButton nonok = new JButton();
	
	private Font fe = new Font("Malo", 0, 16);
	
	private Dimension de = new Dimension(300, 60);
	public Authentification(){
		setTitle("Authentification");
		setSize(800,400);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initLabel();
		initChamps();
		initButton();
		initPanel();
		
	}
	private void initLabel(){
		loginZ.setText("Numero du client:");
		loginZ.setPreferredSize(de);
		loginZ.setFont(fe);
		
		passZ.setText("Nom du client:");
		passZ.setPreferredSize(de);
		passZ.setFont(fe);
		
		
		
	}
	private void initChamps(){
		loginX.setPreferredSize(de);
		loginX.setFont(fe);
		
		passX.setPreferredSize(de);
		passX.setFont(fe);
		
	}
	
	private void initButton(){
		 Statement state = null;	
		ok.setText("Ok");
		ok.setPreferredSize( new Dimension(200, 60));
		ok.setBackground(Color.WHITE);
		ok.setFont(fe);
		ok.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				
			     
			}});
		
		nonok.setText("Annuler");
		nonok.setPreferredSize( new Dimension(200, 60));
		nonok.setFont(fe);
		nonok.setBackground(Color.WHITE);
		nonok.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				 setVisible(false);
			     
			}});
	}
	private void initPanel(){
		panJ.setBackground(Color.WHITE);
		panJ. setPreferredSize( new Dimension( 800, 400) ) ;
		panJ.setBorder( BorderFactory. createTitledBorder( "Authentification : ") ) ;
		
		panJ.add(loginZ);
		panJ.add(loginX);
		
		panJ.add(passZ);
		panJ.add(passX);
		
		panJ.add(ok);
		panJ.add(nonok);
		
		
		
		setContentPane(panJ);
		
	}
	}
