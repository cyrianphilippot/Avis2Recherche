package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MysqlConnect {
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