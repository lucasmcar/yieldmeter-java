
package br.tec.devpoa.yieldmeter.connect;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    
    
    private static Connection con = null;
    
    public static Connection getConnection()
    {
        try
        {
            
            con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/db_yieldmeter.db");
            
            return con;

        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro", 0);
        }
        
        return con;
    }
}
