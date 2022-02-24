package project_pbo;

import controller.MainController;
import javax.swing.JOptionPane;
import model.Database;

public class Project_PBO {

    public static void main(String[] args) {
        Database conn = new Database();
        try {
            String SQL = "TRUNCATE TABLE pengumuman";
            conn.Query(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        MainController start = new MainController();
    }
}
