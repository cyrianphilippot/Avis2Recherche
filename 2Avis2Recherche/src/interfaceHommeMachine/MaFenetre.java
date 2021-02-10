package interfaceHommeMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.omg.PortableInterceptor.NON_EXISTENT;

import connecte.MaConnexion;
import interfaceHommeMachine.ActivitesPratiques;
import interfaceHommeMachine.Activites;
import interfaceHommeMachine.Apropos;
import interfaceHommeMachine.Client;
import interfaceHommeMachine.Acteur;
import interfaceHommeMachine.MaFenetre;
import interfaceHommeMachine.Pro;
import interfaceHommeMachine.Resultats;
import sun.misc.CEStreamExhausted;

public class MaFenetre extends JFrame {
	static long time1 = (new Date()).getTime();
	static long time2 = (new Date()).getTime();

	  private JToolBar tool = new JToolBar();
	 
	  private JButton reqExu = new JButton();
	  private JButton reqEffac = new JButton();
	  private JButton b = new JButton("Liste des acteurs");
	  private JButton b1 = new JButton("Liste des clients");
	  private JButton b2 = new JButton("Liste des Pro");
	  private JButton b3 = new JButton("Liste des activités");
	  private JButton b4 = new JButton("Les Resultats");
	  private JButton b5 = new JButton("Les activités pratiquées");
	  private JButton b6 = new JButton("Liste des clients et Pro");
	  
	  private JButton b01 = new JButton("table acteurs");
	  private JButton b11 = new JButton("table des clients");
	  private JButton b21 = new JButton("table des Pro");
	  private JButton b31 = new JButton("table des activités");
	  private JButton b41 = new JButton("table Resultats");
	  private JButton b51 = new JButton("table activités pratiquées");
	  private JButton b61 = new JButton("table Charger");
	  
	  private JButton b010 = new JButton();
	 
	  private JSplitPane split, split1;
	 
	  private JPanel result = new JPanel();
	  private JLabel img = new JLabel(new ImageIcon("images/plus.png"));
	  private JButton lab12 = new JButton();

	  private JPanel onglet = new JPanel();
	
	  private JPanel recherche = new JPanel();
	  private JPanel recherche1 = new JPanel();
	  private JPanel operation = new JPanel();
	
	  private int i = 0;
	
      private JPanel panH = new JPanel();
      
      private String requete = "SELECT  * FROM acteurs order by  nom asc";
	  private String requete1 = "SELECT  * FROM clients order by nomclients asc";
	  private String requete2 = "SELECT  * FROM Pro order by nompro asc";
	  private String requete3 = "SELECT  * FROM Activites";
	  private String requete4 = "SELECT  * FROM Resultats";
	  private String requete5 = "SELECT  * FROM ActivitesPratiques";
	  private String requete6 = "SELECT  * FROM CHARGE";
	 
	  
	  private String requete01 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'acteurs'";
	  private String requete11 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'clients'";
	  private String requete21 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'Pro' ";
	  private String requete31 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'Activites' ";
	  private String requete41 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'Resultats' ";
	  private String requete51 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'ActivitesPratiques' ";
	  private String requete61 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'CHARGE' ";
	  
	  private String requetett1 = "select  NOM, PRENOM, DATENAISSANCE from acteurs";
	  private String requetett2 = "select *from Activites ";
	  private String requetett3 = "select DISTINCT SPECIALITE from Pro";
	  private String requetett4 = "select NOM,prenom from acteurs,ActivitesPratiques ,Activites \n where \n poids < '50' \n and acteurs.NUMELEVE = ActivitesPratiques.NUMELEVE \n and ActivitesPratiques.NIVEAU=Activites.NIVEAU \n and (Activites.NIVEAU='premier annee' or Activites.NIVEAU='deuxieme ann�e')";
	  private String requetett5 = "select NUMELEVE,NOM,PRENOM from acteurs \n where \n poids between '50'and '60'   ";
	  private String requetett6 = " select * from activ_max \n where \n total_inscrit = (select MAX(total_inscrit) from activ_max)";
	  private String requetett7 = "select * from clients_max \n where \n nbr_total =  (select MAX(nbr_total) from clients_max)    ";
	  private String requetett8 = " select EQUIPE ,NOM,PRENOM ,poids from Activites ,ActivitesPratiques,acteurs \n where \n acteurs.NUMELEVE=ActivitesPratiques.NUMELEVE \n and \n Activites.NIVEAU = ActivitesPratiques.NIVEAU  \n and \n acteurs.PRENOM = 'ali'";
	  private String requetett9 = "select  Pro.SALAIRE ,Pro.NOMpro,Pro.NUMpro from nbr_clients ,Pro \n where \n nombr_cour = '2' \n and \n Pro.NUMpro = nbr_clients.NUMpro ";
	  private String requetett10 = "select Pro.SPECIALITE,Pro.NUMpro,Pro.NOMpro, nbr_heures_max from  charge_lourd4  ,Pro \n where \n Pro.NUMpro=charge_lourd4.NUMpro \n and \n nbr_heures_max=(select MAX(nbr_heures_max) from charge_lourd4)";
	  private String requetett11 = "select clients.NOMclients from clients ,acteurs ,Resultats, ActivitesPratiques where acteurs.NUMELEVE=ActivitesPratiques.NUMELEVE and clients.NUMclients = Resultats.NUMclients \n  and \n Resultats.NUMELEVE =acteurs.NUMELEVE \n and \n ActivitesPratiques.NOMACTPRATIQUE='football'";
	  private String requetett12 = " select acteurs.NUMELEVE, acteurs.NOM, acteurs.PRENOM ,Resultats.POINTES,Resultats.NUMclients from acteurs , Resultats \n where \n acteurs.NUMELEVE = Resultats.NUMELEVE \n and \n POINTES =(select MAX(POINTES) from Resultats ,clients \n where \n Resultats.NUMclients = clients.NUMclients \n and \n clients.NUMclients ='14m01') \n and \n Resultats.NUMclients  ='14m01'";
	  private String requetett13 = "select NOMclients , COUNT(acteurs.NUMELEVE)as nbr_inscrit from clients ,acteurs , Resultats \n where \n acteurs.NUMELEVE =Resultats.NUMELEVE \n and \n Resultats.NUMclients=clients.NUMclients \n GROUP BY NOMclients";
	  private String requetett14 = "select acteurs.NUMELEVE,acteurs.NOM,acteurs.PRENOM,ActivitesPratiques.NOMACTPRATIQUE from acteurs ,ActivitesPratiques \n where \n poids between '50' and '60' \n and \n acteurs.NUMELEVE =ActivitesPratiques.NUMELEVE \n and \n ActivitesPratiques.NOMACTPRATIQUE='gymnastique' ";
	  private String requetett15 = "select clients.NUMclients,clients.NOMclients from clients ,acteurs,Resultats \n where\n  acteurs.NUMELEVE = Resultats.NUMELEVE \n and \n Resultats.NUMclients = clients.NUMclients \n and \n clients.ANNEE='2014' \n and \n acteurs.PRENOM ='kamel'";
	  private String requetett16 = "select distinct * from acteurs,intervalle_rrr";
	 
	  private JTextArea text = new JTextArea();
	
	  JMenuBar barMenu = new JMenuBar();
	  JMenu fichierM = new JMenu();
	  JMenu affichageM = new JMenu();
	  JMenu apropos = new JMenu();
	  JMenu editionM = new JMenu();
	  JMenuItem quit = new JMenuItem(); 
	  JMenu structT = new JMenu();
	  JMenu contentT = new JMenu(); 
	  JMenu nouveauT = new JMenu(); 
	  JMenuItem s1 = new JMenuItem();
	  JMenuItem s2 = new JMenuItem();
	  JMenuItem s3 = new JMenuItem();
	  JMenuItem s4 = new JMenuItem();
	  JMenuItem s5 = new JMenuItem();
	  JMenuItem s6 = new JMenuItem();
	  JMenuItem s7 = new JMenuItem();
	  JMenuItem c1 = new JMenuItem();
	  JMenuItem c2 = new JMenuItem();
	  JMenuItem c3 = new JMenuItem();
	  JMenuItem c4 = new JMenuItem();
	  JMenuItem c5 = new JMenuItem();
	  JMenuItem c6 = new JMenuItem();
	  JMenuItem c7 = new JMenuItem();
	  JMenuItem ap = new JMenuItem();
	  JMenuItem n1 = new JMenuItem();
	  JMenuItem n2 = new JMenuItem();
	  JMenuItem n3 = new JMenuItem();
	  JMenuItem n4 = new JMenuItem();
	  JMenuItem n5 = new JMenuItem();
	  JMenuItem n6 = new JMenuItem();
	  JMenuItem n7 = new JMenuItem();
	 
	  public MaFenetre(){
	    setSize(1800, 1400);
	    setTitle("Avis2Recherche");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    initbarMenu();
	    initrecherche();
	    initToolbar();
	    initContent();

	   result.setBackground(Color.blue);
	    
	  }
	 
	  private void initpaneloperation(){
		  
		  operation.setSize(400, 2000);
		  operation.setBackground(Color.blue);
		  JButton bA = new JButton();
		  bA.setPreferredSize(new Dimension(300, 60));
		  bA.setBackground(Color.blue);
		  bA.setText("Nouveau");
		  bA.setFont(new Font("Malo", 0, 16));
		  JButton bM = new JButton();
		  bM.setPreferredSize(new Dimension(300, 60));
		  bM.setBackground(Color.blue);
		  bM.setText("Modifier");
		  bM.setFont(new Font("Malo", 0, 16));
		  JButton bS = new JButton();
		  bS.setPreferredSize(new Dimension(300, 60));
		  bS.setBackground(Color.blue);
		  bS.setText("Supprimer");
		  bS.setFont(new Font("Malo", 0, 16));
		  JButton bR = new JButton();
		  bR.setPreferredSize(new Dimension(300, 60));
		  bR.setBackground(Color.blue);
		  bR.setText("Rechercher");
		  bR.setFont(new Font("Malo", 0, 16));
		  operation.add(bA, BorderLayout.PAGE_START);
		  operation.add(bM, BorderLayout.PAGE_START);
		  operation.add(bS, BorderLayout.PAGE_START);
		  operation.add(bR, BorderLayout.PAGE_START);
		  
	  }
	  private void initbarMenu(){
		 
		  fichierM.setText("Fichier");
		  n1.setText("Nouveau Acteur");
		  n1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  Acteur el = new Acteur();
		      }
		    }); 
		  n2.setText("Nouveau Client");
		  n2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  Client el = new Client();

		      }
		    }); 
		  n3.setText("Nouveau Pro");
		  n3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	 Pro pro = new Pro();

		      }
		    }); 
		  n4.setText("Nouveau Activité");
		  n4.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  Activites el = new  Activites();

		      }
		    }); 
		  n5.setText("Nouveau Résultats des acteurs");
		  n5.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  Resultats el = new Resultats();

		      }
		    }); 
		  n6.setText("Nouveau Activités paratiquées");
		  n6.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  ActivitesPratiques el = new   ActivitesPratiques();

		      }
		    }); 
		  n7.setText("NouveauCode Client-pro");
		  n7.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete6);

		      }
		    }); 
		  quit.setText("Quitter");
		  quit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  System.exit(0);
		      }
		    }); 
		  fichierM.add(nouveauT);
		  nouveauT.setText("Nouveau");
		  nouveauT.add(n1);
		  nouveauT.add(n2);
		  nouveauT.add(n3);
		  nouveauT.add(n4);
		  nouveauT.add(n5);
		  nouveauT.add(n6);
		  fichierM.add(quit);
		 
		  s1.setText("Table Acteur");
		  s1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete01);

		      }
		    }); 
		  s2.setText("Table Client");
		  s2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete11);

		      }
		    }); 
		  s3.setText("Table Pro");
		 
		  s3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete21);	    	  
		      }
		    }); 
		  s4.setText("Table Activités");
		  s4.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete31);

		      }
		    }); 
		  s5.setText("Table Résultats");
		  s5.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete41);

		      }
		    }); 
		  s6.setText("Table Activités paratiquées");
		  s6.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete51);

		      }
		    }); 
		  s7.setText("Table Client-pro");
		  s7.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete61);

		      }
		    }); 
		  structT.setText("Structure des tables");
		  structT.add(s1);
		  structT.add(s2);
		  structT.add(s3);
		  structT.add(s4);
		  structT.add(s5);
		  structT.add(s6);
		  structT.add(s7);
		  c1.setText("Liste des Acteur");
		  c1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete);

		      }
		    }); 
		  c2.setText("Liste des Client");
		  c2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete1);

		      }
		    }); 
		  c3.setText("Liste des Pro");
		  c3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete2);


		      }
		    }); 
		  c4.setText("Liste des Activités");
		  c4.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete3);

		      }
		    }); 
		  c5.setText("Résultats des élèves");
		  c5.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete4);

		      }
		    }); 
		  c6.setText("Liste des Activités paratiquées");
		  c6.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete5);

		      }
		    }); 
		  c7.setText("Code Client-pro");
		  c7.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete6);

		      }
		    }); 
		  contentT.setText("Contenu des tables");
		  contentT.add(c1);
		  contentT.add(c2);
		  contentT.add(c3);
		  contentT.add(c4);
		  contentT.add(c5);
		  contentT.add(c6);
		  contentT.add(c7);
		  affichageM.setText("Affichage");
		  affichageM.add(structT);
		  affichageM.add(contentT);
		  ap.setText("A propos du projet");
		  ap.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	 Apropos apro = new Apropos();

		      }
		    });
		  apropos.setText("?");
		  apropos.add(ap);
		  barMenu.add(fichierM);
		  barMenu.add(affichageM);
		  barMenu.add(apropos);
		  
		  setJMenuBar(barMenu);
	  }   
	  private void initrecherche(){
		  Font fer = new Font("Malo",0, 16);
		  recherche.setBackground(Color.blue);
		  recherche1.setBackground(Color.blue);
		  recherche1.setBackground(Color.blue);
		  onglet.setSize(220, 700);
		  onglet.setBorder(null);
		  onglet.setBackground(Color.blue);
		    b.setPreferredSize(new Dimension(240, 60));
		    b.setBorder(null);
		    b.setBackground(Color.blue);
		    b.setText("Liste des acteurs");
		    b.setFont(fer);
		    b.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  initTable(requete);
		      }
		    }); 
		  
		    b1.setPreferredSize(new Dimension(240, 60));
		    b1.setBorder(null);
		    b1.setBackground(Color.blue);
		    b1.setText("Liste des Client");
		    b1.setFont(fer);
		    b1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete1);
		      }
		    }); 
		    b2.setPreferredSize(new Dimension(240, 60));
		    b2.setBorder(null);
		    b2.setBackground(Color.blue);
		    b2.setFont(fer);
		    b2.setText("Liste des Pro");
		    b2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete2);
		      }
		    });  
		    b3.setPreferredSize(new Dimension(240, 60));
		    b3.setBorder(null);
		    b3.setBackground(Color.blue);
		    b3.setText("Liste des activités");
		    b3.setFont(fer);
		    b3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete3);
		      }
		    });
		    b4.setPreferredSize(new Dimension(240, 60));
		    b4.setBorder(null);
		    b4.setBackground(Color.blue);
		    b4.setText("Les résultats");
		    b4.setFont(fer);
		    b4.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete4);
		      }
		    });  
		    b5.setPreferredSize(new Dimension(240, 60));
		    b5.setBorder(null);
		    b5.setBackground(Color.blue);
		    b5.setFont(fer);
		    b5.setText("Les activités pratiquées");
		    b5.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete5);
		      }
		    }); 
		
		    recherche.add(b, BorderLayout.WEST);
		    recherche.add(b1, BorderLayout.WEST);
		    recherche.add(b2, BorderLayout.WEST);
		    recherche.add(b3, BorderLayout.WEST);
		    recherche.add(b4, BorderLayout.WEST);
		    recherche.add(b5, BorderLayout.WEST);
		    
		    onglet.add("Affichage", recherche1);

		    b01.setPreferredSize(new Dimension(240, 60));
		    b01.setBorder(null);
		    b01.setBackground(Color.blue);
		    b01.setText("Table acteurs");
		    b01.setFont(fer);
		    b01.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete01);
		      }
		    }); 
		  
		    b11.setPreferredSize(new Dimension(240, 60));
		    b11.setBorder(null);
		    b11.setBackground(Color.blue);
		    b11.setText("Table Client");
		    b11.setFont(fer);
		    b11.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete11);
		      }
		    }); 
		    b21.setPreferredSize(new Dimension(240, 60));
		    b21.setBorder(null);
		    b21.setBackground(Color.blue);
		    b21.setText("Table Pro");
		    b21.setFont(fer);
		    b21.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete21);
		      }
		    });  
		    b31.setPreferredSize(new Dimension(240, 60));
		    b31.setBorder(null);
		    b31.setBackground(Color.blue);
		    b31.setText("Table activités");
		    b31.setFont(fer);
		    b31.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete31);
		      }
		    });
		    b41.setPreferredSize(new Dimension(240, 60));
		    b41.setBorder(null);
		    b41.setBackground(Color.blue);
		    b41.setText("Table résultats");
		    b41.setFont(fer);
		    b41.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete41);
		      }
		    });  
		    b51.setPreferredSize(new Dimension(240, 60));
		    b51.setBorder(null);
		    b51.setBackground(Color.blue);
		    b51.setText("Table activités pratiquées");
		    b51.setFont(fer);
		    b51.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        initTable(requete51);
		      }
		    }); 
		  
		    recherche1.add(b01, BorderLayout.WEST);
		    recherche1.add(b11, BorderLayout.WEST);
		    recherche1.add(b21, BorderLayout.WEST);
		    recherche1.add(b31, BorderLayout.WEST);
		    recherche1.add(b41, BorderLayout.WEST);
		    recherche1.add(b51, BorderLayout.WEST);
			onglet.add("Structure",  recherche1);
			 
			
			b010.setPreferredSize(new Dimension(240, 60));
			b010.setBorder(null);
			b010.setBackground(Color.blue);
			b010.setText("Requête 1");
			b010.setFont(fer);
		    b010.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett1);
			      }
			    });
		    b11.setPreferredSize(new Dimension(240, 60));
			b11.setBorder(null);
			b11.setBackground(Color.blue);
			b11.setText("Requête 2");
			b11.setFont(fer);
		    b11.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett2);
			      }
			    });
		    b21.setPreferredSize(new Dimension(240, 60));
			b21.setBorder(null);
			b21.setBackground(Color.blue);
			b21.setText("Requête 3");
			b21.setFont(fer);
		    b21.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett3);
			      }
			    });
			
		    b31.setPreferredSize(new Dimension(240, 60));
			b31.setBorder(null);
			b31.setBackground(Color.blue);
			b31.setText("Requête4");
			b31.setFont(fer);
		    b31.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett4);
			      }
			    });
		   
		    b41.setPreferredSize(new Dimension(240, 60));
			b41.setBorder(null);
			b41.setBackground(Color.blue);
			b41.setText("Requête 5");
			b41.setFont(fer);
		    b41.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett5);
			      }
			    });
		    
		    b51.setPreferredSize(new Dimension(240, 60));
			b51.setBorder(null);
			b51.setBackground(Color.blue);
			b51.setText("Requête 6");
			b51.setFont(fer);
		    b51.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett6);
			      }
			    });
		    b61.setPreferredSize(new Dimension(240, 60));
			b61.setBorder(null);
			b61.setBackground(Color.blue);
			b61.setText("Requête 7");
			b61.setFont(fer);
		    b61.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett7);
			      }
			    });
		    
		    b11.setPreferredSize(new Dimension(240, 60));
			b11.setBorder(null);
			b11.setBackground(Color.blue);
			b11.setText("Requête 8");
			b11.setFont(fer);
		    b11.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett8);
			      }
			    });
		    
		    b21.setPreferredSize(new Dimension(240, 60));
			b21.setBorder(null);
			b21.setBackground(Color.blue);
			b21.setText("Requête 9");
			b21.setFont(fer);
		    b21.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett9);
			      }
			    });
		    
		    b31.setPreferredSize(new Dimension(240, 60));
			b31.setBorder(null);
			b31.setBackground(Color.blue);
			b31.setText("Requête 10");
			b31.setFont(fer);
		    b31.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett10);
			      }
			    });
		    
		    b41.setPreferredSize(new Dimension(240, 60));
			b41.setBorder(null);
			b41.setBackground(Color.blue);
			b41.setText("Requête 11");
			b41.setFont(fer);
		    b41.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett11);
			      }
			    });
		    
		    b51.setPreferredSize(new Dimension(240, 60));
			b51.setBorder(null);
			b51.setBackground(Color.blue);
			b51.setText("Requête 12");
			b51.setFont(fer);
		    b51.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett12);
			      }
			    });
		    
		    b61.setPreferredSize(new Dimension(240, 60));
			b61.setBorder(null);
			b61.setBackground(Color.blue);
			b61.setText("Requête 13");
			b61.setFont(fer);
		    b61.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett13);
			      }
			    });
		    
		    b11.setPreferredSize(new Dimension(240, 60));
			b11.setBorder(null);
			b11.setBackground(Color.blue);
			b11.setText("Requête 14");
			b11.setFont(fer);
		    b11.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett14);
			      }
			    });
		    
		    b21.setPreferredSize(new Dimension(240, 60));
		    b21.setBorder(null);
		    b21.setBackground(Color.blue);
		    b21.setText("Requête 15");
		    b21.setFont(fer);
		    b21.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett15);
			      }
			    });
		    
		    b31.setPreferredSize(new Dimension(240, 60));
		    b31.setBorder(null);
		    b31.setBackground(Color.blue);
		    b31.setText("Requête 16");
		    b31.setFont(fer);
		    b31.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        initTable(requetett16);
			      }
			    }); 
	  }
	  public void initContent(){
		  JLabel ne =  new JLabel(new ImageIcon("images/Fond.jpg"));
		  JLabel nea =  new JLabel();
		  nea.setText("\t"+"Projet 2021 java ");
			
			nea.setFont(new Font("Malo",2 , 70));
			ne.setPreferredSize(new Dimension(200,50));
		 
			AbstractButton recherche2;
			recherche1.setLayout(new BorderLayout());
		    result.setLayout(new BorderLayout());
		    result.add(ne);
		    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(text), result);
		    split.setDividerLocation(100);
		    split.setDividerSize(2);
		    split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, recherche1, split);
		    split1.setDividerLocation(220);
		    split1.setDividerSize(2);
		    getContentPane().add(split1);      
		  }
	
	  private void initToolbar(){
		  
	  
		   reqExu.setPreferredSize(new Dimension(300, 60));
		    reqExu.setBackground(Color.blue);
		    reqExu.setText("Exécuter la reqûete");
		    reqExu.setFont(new Font("Malo", 0, 16));
		   reqExu.addActionListener(new ActionListener(){
	   
	      public void actionPerformed(ActionEvent event){
	        initTable(text.getText());
	      }
	    });
	  
	    reqEffac.setPreferredSize(new Dimension(300, 60));
	    reqEffac.setBackground(Color.blue);
	    reqEffac.setText("Effacer la reqûete");
	    reqEffac.setFont(new Font("Malo", 0, 16));
	    reqEffac.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	    	    
	      }
	    });
	 
	    tool.add( reqExu);

	    getContentPane().add(tool, BorderLayout.NORTH);
	  }
	     
	  public void initTable(String query){
		  JLabel ne =  new JLabel();
		  ne.setFont(new Font("Malo",2 , 35));
	    try {	    
	      long start = System.currentTimeMillis();
	      Statement state = MaConnexion.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 
	      ResultSet res = state.executeQuery(query);

	      ResultSetMetaData meta = res.getMetaData();

	      Object[] column = new Object[meta.getColumnCount()];
	 
	      for(int i = 1 ; i <= meta.getColumnCount(); i++)
	        column[i-1] = meta.getColumnName(i);
	 
	      res.last();
	      int rowCount = res.getRow();
	      Object[][] data = new Object[res.getRow()][meta.getColumnCount()];

	      res.beforeFirst();
	      int j = 1;
	 
	      while(res.next()){
	        for(int i = 1 ; i <= meta.getColumnCount(); i++)
	          data[j-1][i-1] = res.getObject(i);
	                 
	        j++;
	      }
	                                    
	      res.close();
	      state.close();
	 
	      long totalTime = System.currentTimeMillis() - start;
	 
	      result.removeAll();
	     
	      result.add(new JScrollPane(new JTable(data, column)));
	      text.setText(query);
	      result.add(new JLabel("La requête à été exécuté en " + totalTime + " ms et à retourné " + rowCount + " ligne(s)"), BorderLayout.SOUTH);
	      result.revalidate();
	             
	    } catch (SQLException e) {
	    	   
	    	if(e.getSQLState()==null){
	    		ne.setText("Operation Ok");
	    		result.removeAll();
				  result.add(ne);
				  result.revalidate();
	    	}else{
	    		ne.setText(e.getMessage());
	    		ne.setForeground(Color.RED);
	    	result.removeAll();
			  result.add(ne);
			  result.revalidate();}
	     
	    }  
	    catch (StringIndexOutOfBoundsException e) {
	    	result.removeAll();
	    	
			ne.setText("Veuillez saisir une requête puis validez.");
			
			
			  result.add(ne);
			  result.revalidate();}	
	    
	    
	  }
	 
	 
	  public static void main(String[] args){
	   
	  try {
          for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
              if ("RAS".equals(info.getName())) {
                  UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
         
      } catch (InstantiationException ex) {
         
      } catch (IllegalAccessException ex) {
         
      } catch (UnsupportedLookAndFeelException ex) {
    	  JOptionPane.showMessageDialog(null, "Non accepté", "information", NORMAL);
       
      }
	  
     
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
        	
        	  
              new MaFenetre().setVisible(true);
          }
      });
  }
	  
	  
	  
	  }
