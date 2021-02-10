package interfaceHommeMachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connecte.MaConnexion;

public class Client extends JFrame {
	private JLabel numclientL =new JLabel();
	private JLabel nonclientL =new JLabel();
	private JLabel nbrclientL =new JLabel();
	private JLabel anneeclientL =new JLabel();
	private Dimension de = new Dimension(150, 30);

	private JTextField numclientT = new JTextField();
	private JTextField nomclientT = new JTextField();
	private JTextField nbrclientT = new JTextField();
	private JTextField anneeclientT = new JTextField();
	
	private Font fenC = new Font("Malo", 0, 16);
	private Font fenC1 = new Font("Malo", 1, 16);
	
	private JPanel panC = new JPanel();
	private JPanel panp = new JPanel();
	
	private JButton ok = new JButton();
	private JButton annuler = new JButton();
	
	public Client(){
		setTitle("add-client");
		setSize(650, 350);
		setVisible(true);
		setLocationRelativeTo(null);
		initLabel();
		initChamps();
		initButton();
		initPanel();
		
	}
	private void initLabel(){
		numclientL.setText("Numero du client:");
		numclientL.setPreferredSize(de);
		numclientL.setFont(fenC1);
		
		nonclientL.setText("Nom du client:");
		nonclientL.setPreferredSize(de);
		nonclientL.setFont(fenC1);
		
		nbrclientL.setText("Nombre d'heurs:");
		nbrclientL.setPreferredSize(de);
		nbrclientL.setFont(fenC1);
		
		anneeclientL.setText("Année :");
		anneeclientL.setPreferredSize(de);
		anneeclientL.setFont(fenC1);
		
		
	}
	private void initChamps(){
		numclientT.setPreferredSize(de);
		numclientT.setFont(fenC);
		
		nomclientT.setPreferredSize(de);
		nomclientT.setFont(fenC);
		
		nbrclientT.setPreferredSize(de);
		nbrclientT.setFont(fenC);
		
		anneeclientT.setPreferredSize(de);
		anneeclientT.setFont(fenC);
		
	}
	
	private void initButton(){
				
		ok.setText("OK");
		ok.setPreferredSize(de);
		ok.setBackground(Color.WHITE);
		ok.setFont(fenC1);
		ok.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				String num =	numclientT.getText() ;
				String nom =	nomclientT.getText() ;
				int nbr =  Integer.valueOf(nbrclientT.getText());
				String anne = anneeclientT.getText();
				
				String requete = "INSERT INTO client VALUES ('"+num+"','"+nom+"',"+nbr+",'"+anne+"')";
				

				long start = System.currentTimeMillis();
			      Statement state = null;
				try {
					
					state = MaConnexion.getInstance().createStatement();
				  int res =  state.executeUpdate(requete);
				  if(res!=0){
						setVisible( false) ;
						JOptionPane.showMessageDialog(null, "Eneregistrement Ok", "info", JOptionPane.INFORMATION_MESSAGE);
						}
						state.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}
			     
			}});
		
		annuler.setText("Annuler");
		annuler.setPreferredSize(de);
		annuler.setFont(fenC1);
		annuler.setBackground(Color.WHITE);
		annuler.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				 setVisible(false);
			     
			}});
	}
	private void initPanel(){
		panC.setBackground(Color.WHITE);
		panC. setPreferredSize( new Dimension( 800, 400) ) ;
		panC.setBorder( BorderFactory. createTitledBorder( "Information de client : ") ) ;
		
		panC.add(numclientL);
		panC.add(numclientT);
		
		panC.add(nonclientL);
		panC.add(nomclientT);
		
		panC.add(nbrclientL);
		panC.add(nbrclientT);
		
		panC.add(anneeclientL);
		panC.add(anneeclientT);
	
		panC.add(ok);
		panC.add(annuler);
		setContentPane(panC);
		
		
	
	}
}
