package beans;

import java.util.ArrayList;

import ActeurGui.ActeurFrame;

import java.sql.Connection;
import java.sql.ResultSet;

public class Acteurs {
    private int m_curseur=0;
    private ArrayList<Acteur> m_liste= new ArrayList<Acteur>();
    
    public Acteurs() {
        try {
            MysqlConnect mc = new MysqlConnect("crime");
            ResultSet resultat=mc.select("SELECT * from acteurs");
            System.out.println(resultat);
            while(resultat.next())
            {
                int tete=resultat.getInt("teteActeur");
                int torse=resultat.getInt("torseActeur");
                int jambes=resultat.getInt("jambesActeur");
                int pieds=resultat.getInt("piedsActeur");

                Acteur a = new Acteur(tete, torse, jambes, pieds);
                
                m_liste.add(a);
                }
            System.out.println(m_liste.size()+" enregistrements récupérés...");
        }
            catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void suivant() {
        if(m_curseur<m_liste.size()-1)
            m_curseur++;
    }
    
    public void precedent() {
        if(m_curseur>0)
            m_curseur--;
    }
}