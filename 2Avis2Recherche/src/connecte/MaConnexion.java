package connecte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * public class MysqlConnect {
    private Connection m_connection;
    
    public MysqlConnect (String ip, String base, String login, String pass) {
        try {
            String url = "jdbc:mysql://" + ip + ":8012/" + base + "?serverTimezone=UTC";
            m_connection = DriverManager.getConnection(url, "boss", "proj2021");
            
        } catch (Exception exc) {
            System.err.println("Constructeur n°1 : " + exc.getMessage());
        }
    }
    
    public MysqlConnect(String base) {
        
        this("127.0.0.1", base, "boss", "proj2021");
    }
    
    public ResultSet select(String sql) {
        ResultSet res = null;
        try {
            Statement instruction = m_connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = instruction.executeQuery(sql);
            
        } catch (Exception exc) {
            System.err.println("Pb sur requête '" + sql + "'");
        }
        return res;
    }
}
*/
public class MaConnexion {
	private static String url ="jdbc:sqlserver://localhost:1433;databaseName=CEM;user=sa;password=sql";
	
	
	private static Connection connect;
	public static Connection getInstance( ) {
	if( connect == null) {
	
	try {
		connect = DriverManager. getConnection( url) ;
	} catch (SQLException e) {
		// info
		JOptionPane.showMessageDialog(null, "BDD no présente suite à une non-convenance du résultat \n Code erreur: "+e.getErrorCode(), "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	System.out.println("Connexion effective");
	
	}return connect;
	}
	}



