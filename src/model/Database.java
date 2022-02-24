package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {
    static String url = "jdbc:mysql://localhost/tubespbo";
    static String pass = "";
    static String user = "root";
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "" + e.getMessage() + "", "Connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getData(String SQL) throws SQLException{
        try {
            rs = stmt.executeQuery(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage() +"","Communication Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return rs;
    }
    
    public void Query(String SQL){
        try {
            stmt.execute(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage()+"","Communication Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}