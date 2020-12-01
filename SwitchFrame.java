package SwitchGui;

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
	public class SwitchFrame extends JFrame implements ActionListener {
	private JLabel m_resultat, m_code, m_reference;
	private JButton m_bprecedant, m_bsuivant, m_bKill;
	
	public SwitchFrame() {
		// Paramétrages de la frame
		setSize(1200, 800);
		setTitle("Avis2Recherche");
		
		// Premier panel des informations : 4 lignes et 2 colonnes
		JPanel infosPanel = new JPanel(new GridLayout(4, 2, 1000, 100));
		infosPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		infosPanel.add( m_bprecedant= new JButton("◀️"));
		infosPanel.add(m_bsuivant=new JButton("▶️"));
		infosPanel.add( m_bprecedant= new JButton("◀️"));
		infosPanel.add(m_bsuivant=new JButton("▶️"));
		infosPanel.add( m_bprecedant= new JButton("◀️"));
		infosPanel.add(m_bsuivant=new JButton("▶️"));
		infosPanel.add( m_bprecedant= new JButton("◀️"));
		infosPanel.add(m_bsuivant=new JButton("▶️"));
		// Ajout du panel à la frame
		add(infosPanel);
		
		// Deuxième panel de bouton : 1 ligne et 1 colonnes
		JPanel boutonsPanel = new JPanel(new GridLayout(1, 5, 10, 10));
		boutonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		boutonsPanel.add(m_bKill= new JButton("kill"));
		// ajout du panel au sud
		add(boutonsPanel, BorderLayout.SOUTH);
		
		// Les évènements
		m_bprecedant.addActionListener(this);
		m_bsuivant.addActionListener(this);
		m_bKill.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==m_bKill)
			System.exit(0);
		else {
			double code=0, reference=0;
			try {
				code=Double.parseDouble(m_code.getText());
				reference=Double.parseDouble(m_reference.getText());
				if(e.getSource()==m_bprecedant) {
					double res=code-reference;
					m_resultat.setText(String.format("%.2f", res));
				}
				else if(e.getSource()==m_bsuivant) {
					double res=code+reference;
					m_resultat.setText(String.format("%.2f", res));
				}
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this,
						"je t'ai eux !");
			}
		}
	}
	public static void main(String[] args) {
		SwitchFrame gui=new SwitchFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}