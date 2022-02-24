package view;

import controller.MainController;
import javax.swing.JOptionPane;
import model.Account;
import model.Database;


public class Frame_Daftar extends javax.swing.JFrame {
    Database conn = new Database();
    Account akun;
    public Frame_Daftar() {
        initComponents();
    }

    public String getTxtEmail(){
        return txtEmail.getText();
    }
    
    public String getTxtUsername(){
        return txtUsername.getText();
    }
    
    public String getTxtPassword(){
        return txtPassword.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnSignUp = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Akun");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 24, -1, -1));

        jLabel2.setText("Email");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 90, -1, -1));

        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 138, -1, -1));

        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 186, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 82, 320, 30));
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 320, 30));

        btnSignUp.setText("Daftar");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 120, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 178, 320, 30));

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        if(txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            if (txtEmail.getText().isEmpty()){
                txtEmail.requestFocus();
            }
            
            if (txtUsername.getText().isEmpty()){
                txtUsername.requestFocus();
            }
            
            if (txtPassword.getText().isEmpty()){
                txtPassword.requestFocus();
            }
        }else{
            try {
                String SQL = "INSERT INTO account (email, username, password, tipe)" 
                        + "VALUES ("
                        + "'" + getTxtEmail() + "', "
                        + "'" + getTxtUsername() + "',"
                        + "'" + getTxtPassword() + "',"
                        + "'Calon Siswa');" ;
                
                conn.Query(SQL);
                akun = new Account(getTxtEmail(), getTxtUsername(), getTxtPassword(), "Calon Siswa");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Akun berhasil dibuat");
            Frame_MenuSiswa menu = new Frame_MenuSiswa(akun);
            menu.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainController main = new MainController();
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
