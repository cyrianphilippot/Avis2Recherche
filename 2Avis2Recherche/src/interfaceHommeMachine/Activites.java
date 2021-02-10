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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connecte.MaConnexion;

public class Activites extends JFrame{
	private JLabel niveauL =new JLabel();
	private JLabel nonActivL =new JLabel();
	private JLabel compliceL =new JLabel();

	private JTextField niveauT = new JTextField();
	private JComboBox  nonActivT = new JComboBox ();
	private JTextField compliceT = new JTextField();
	
	private Font fenC = new Font("Malo", 0, 16);
	private Font fenC1 = new Font("Malo", 1, 16);
	
	private JPanel panC = new JPanel();
	private JPanel panp = new JPanel();
	
	private JButton ok = new JButton();
	private JButton annuler = new JButton();
	
	public Activites(){
		setTitle("Fen-Ajout-Activités");
		setSize(650, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		initLabel();
		initChamps();
		initButton();
		initPanel();
		
	}
	private void initLabel(){
		niveauL.setText("Niveau:");
		niveauL.setPreferredSize(new Dimension(300, 50));
		niveauL.setFont(fenC1);
		
		nonActivL.setText("Nom d'activités:");
		nonActivL.setPreferredSize(new Dimension(300, 50));
		nonActivL.setFont(fenC1);
		
		
		compliceL.setText("complice:");
		compliceL.setPreferredSize(new Dimension(300, 50));
		compliceL.setFont(fenC1);
		
	}
	private void initChamps(){
		niveauT.setPreferredSize(new Dimension(300, 50));
		niveauT.setFont(fenC);
		
		nonActivT.setPreferredSize(new Dimension(300, 50));
		nonActivT.setFont(fenC);
		nonActivT. addItem( "meurtre") ;
		nonActivT. addItem("suicide");
		nonActivT. addItem("suicide");
		nonActivT. addItem( "violence");
		nonActivT. addItem( "viole-vol");
		
		compliceT.setPreferredSize(new Dimension(300, 50));
		compliceT.setFont(fenC);
		
	}
	
	private void initButton(){
		ok.setText("OK");
		ok.setPreferredSize(new Dimension( 200, 50));
		ok.setBackground(Color.WHITE);
		ok.setFont(fenC1);
		ok.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				String num =	niveauT.getText() ;
				String comp =  compliceT.getText();
				String nom =	(String) nonActivT.getSelectedItem() ;
				
				String requete = "INSERT INTO ACTIVITES VALUES ('"+num+"','"+comp+"','"+nom+"')";
				

				long start = System.currentTimeMillis();
			      Statement state = null;
				try {
					
					state = MaConnexion.getInstance().createStatement();
				  int res =  state.executeUpdate(requete);
				  if(res!=0){
						setVisible( false) ;
						JOptionPane.showMessageDialog(null, "Eneregistrement Ok"+start, "info", JOptionPane.INFORMATION_MESSAGE);
						}
						state.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}	 
			     
			}});
		
		annuler.setText("Annuler");
		annuler.setFont(fenC1);
		annuler.setPreferredSize(new Dimension( 200, 50));
		annuler.setBackground(Color.WHITE);
		annuler.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				 setVisible(false);
			     
			}});
	}
	private void initPanel(){
		panC.setBackground(Color.WHITE);
		panC. setPreferredSize( new Dimension( 400, 180) ) ;
		panC.setBorder( BorderFactory. createTitledBorder( "Information d'activités : ") ) ;
		
		panC.add(niveauL);
		panC.add(niveauT);
		
		panC.add(nonActivL);
		panC.add(nonActivT);
		
		panC.add(compliceL);
		panC.add(compliceT);
		
		panC.add(ok);
		panC.add(annuler);
		setContentPane(panC);
		
		
	
	}
}
