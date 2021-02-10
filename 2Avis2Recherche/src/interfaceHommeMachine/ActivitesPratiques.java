package interfaceHommeMachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connecte.MaConnexion;

public class ActivitesPratiques extends JFrame{
	private JLabel niveauL =new JLabel();
	private JLabel numcliL =new JLabel();
	private JLabel nomL =new JLabel();

	private JComboBox niveauAC =new JComboBox();
	private JComboBox  numclientC =new JComboBox();
	private JComboBox nomAC =new JComboBox();
	
	private Font fenC = new Font("Malo", 0, 16);
	private Font fenC1 = new Font("Malo", 0, 16);
	
	private JPanel panC = new JPanel();
	private JPanel panY = new JPanel();
	
	private JButton ok = new JButton();
	private JButton annuler = new JButton();
	
	private String req1E = " select DISTINCT niveau from  ACTIVITES";
	private String req2A = " select DISTINCT numclient from clientS";
	public ActivitesPratiques(){
		setTitle("add-ActivitésPratiquées");
		setSize(650, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		initLabel();
		initCombo();
		initButton();
		initPanel();
		
	}
	private void initLabel(){
		niveauL.setText("niveau : ");
		niveauL.setPreferredSize(new Dimension(300, 50));
		niveauL.setFont(fenC1);
		
		numcliL.setText("Numero client : ");
		numcliL.setPreferredSize(new Dimension(300, 50));
		numcliL.setFont(fenC1);
		
		nomL.setText("Nom Activité pratiquées : ");
		nomL.setPreferredSize(new Dimension(300, 50));
		nomL.setFont(fenC1);
		
	}
	private void initCombo(){
		niveauAC.setPreferredSize(new Dimension(300, 50));
		niveauAC.setFont(fenC);
		niveauAC.setBackground(Color.WHITE);
		 Statement state;ResultSet res;
		try {
			state = MaConnexion.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			state.executeQuery(req1E);
			
			res = state.getResultSet();
			while(res.next()){
				niveauAC.addItem(res.getString("niveau"));
			}res.close();state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		
		numclientC.setPreferredSize(new Dimension(300, 50));
		numclientC.setFont(fenC);
		numclientC.setBackground(Color.WHITE);
		try {
			state = MaConnexion.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			state.executeQuery(req2A);
			
			res = state.getResultSet();
			while(res.next()){
				numclientC.addItem(res.getString("numclient"));
			}res.close();state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		nomAC.setPreferredSize(new Dimension(300, 50));
		nomAC.setFont(fenC);
		nomAC.setBackground(Color.WHITE);
		nomAC.addItem( "meurtre") ;
		nomAC.addItem("suicide");
		nomAC. addItem("suicide");
		nomAC. addItem( "violence");
		nomAC. addItem( "viole-vol");
	}
	
	private void initButton(){
		ok.setText("OK");
		ok.setPreferredSize(new Dimension( 200, 50));
		ok.setBackground(Color.WHITE);
		ok.setFont(fenC1);
		ok.addActionListener( new ActionListener( ) {
			public void actionPerformed( ActionEvent arg0) {
				String niv =	 (String) niveauAC.getSelectedItem() ;
				String numcli =	(String) numclientC.getSelectedItem() ;
				String nom =	(String) nomAC.getSelectedItem() ;
				
				String requete = "INSERT INTO ACTIVITES VALUES ('"+niv+"','"+numcli+"','"+nom+"')";
				

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
		panC.add(niveauAC);
		
		panC.add(numcliL);
		panC.add(numclientC);
		
		panC.add(nomL);
		panC.add(nomAC);
		
		panC.add(ok);
		panC.add(annuler);
		setContentPane(panC);
		
		
	
	}
}
