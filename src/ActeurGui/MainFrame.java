package ActeurGui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
	public class MainFrame extends JFrame implements ActionListener {
	//private JLabel m_resultat, m_code, m_reference;
	private ProfileFrame profileFrame;
	private ActeurFrame acteurFrame;
	private JButton m_bprofil, m_bcreation, m_bKill;
	
	public MainFrame() {
		// Paramétrages de la frame
		setSize(1200, 800);
		setTitle("Avis2Recherche");
		
		// Premier panel des informations : 4 lignes et 2 colonnes
		JPanel infosPanel = new JPanel(new GridLayout(2, 1, 1000, 100));
		infosPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		infosPanel.add( m_bprofil= new JButton("Profil"));
		infosPanel.add(m_bcreation=new JButton("Création"));
		// Ajout du panel à la frame
		add(infosPanel);
		
		// Deuxième panel de bouton : 1 ligne et 1 colonnes
		JPanel boutonsPanel = new JPanel(new GridLayout(1, 5, 10, 10));
		boutonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		boutonsPanel.add(m_bKill= new JButton("kill"));
		// ajout du panel au sud
		add(boutonsPanel, BorderLayout.SOUTH);
		
		// Les évènements
		m_bprofil.addActionListener(this);
		m_bcreation.addActionListener(this);
		m_bKill.addActionListener(this);
	}
																					
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==m_bKill)
			System.exit(0);
		else {
			double code=0, reference=0;
			try {
				if(e.getSource()==m_bprofil) {
					
					if (profileFrame == null) {
						profileFrame = new ProfileFrame();
					}
					if (!profileFrame.isVisible()) {
						profileFrame.setVisible(true);
					}
				}
				else if(e.getSource()==m_bcreation) {
					
					if (acteurFrame == null) {
						acteurFrame = new ActeurFrame();
					}
					if (!acteurFrame.isVisible()) {
						acteurFrame.setVisible(true);
					}
				}
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this,
						"je t'ai eux !");
			}
		}
	}
	public static void main(String[] args) {
		MainFrame gui=new MainFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}