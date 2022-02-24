package controller;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Account;
import model.Admin;
import model.Database;
import view.Frame_Login;
import view.Frame_MenuAdmin;
import view.Frame_MenuSiswa;

public class MainController {
    private Frame_Login login = new Frame_Login();
    private Account akun;
    private Database conn = new Database();
    private Admin mimin;
    private String SQL;

    public MainController() {
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
    public void validasiAkun(String username, String password, String tipe){
        try {
            SQL = "SELECT * FROM `account` WHERE username='" + username + "' and password='" + password + "' and tipe='" + tipe + "';";
            ResultSet rs = conn.getData(SQL);
                if (rs.next()){
                    if(tipe.equals("Admin")){
                        Frame_MenuAdmin menuAdmin = new Frame_MenuAdmin();
                        menuAdmin.setVisible(true);
                        menuAdmin.setLocationRelativeTo(null);
                        login.dispose();
                    }else{
                        akun = new Account(rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("tipe"));
                        Frame_MenuSiswa menuSiswa = new Frame_MenuSiswa(akun);
                        menuSiswa.setVisible(true);
                        menuSiswa.setLocationRelativeTo(null);
                        login.dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "username and password doesn't macth", "Error", JOptionPane.WARNING_MESSAGE);
                }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}