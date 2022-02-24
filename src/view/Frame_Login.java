package view;

import controller.MainController;
import javax.swing.JOptionPane;
import model.CalonSiswa;

public class Frame_Login extends javax.swing.JFrame {
    CalonSiswa siswa;
    Frame_Nilai frame = new Frame_Nilai();
    Frame_MenuSiswa menuSiswa = new Frame_MenuSiswa();
    Frame_MenuAdmin menuAdmin = new Frame_MenuAdmin();
    
    public Frame_Login() {
        initComponents();
    }
    
    public String getTxtUsername(){
        return txtUsername.getText();
    }
    
    public String getTxtPassword(){
        return txtPassword.getText();
    }
    
    public String getRadioUser(){
        if(radioAdmin.isSelected()) {
            return "Admin";
        }else return "Calon Siswa";
    }
    
    public void setTxtUsername(String text){
        txtUsername.setText(text);
    }
    
    public void setTxtPassword(String text){
        txtPassword.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipe = new javax.swing.ButtonGroup();
        SignInPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioSiswa = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Masuk");
        SignInPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel2.setText("Username");
        SignInPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        SignInPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 280, 30));

        jLabel3.setText("Password");
        SignInPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        btnSignIn.setText("Masuk");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        SignInPanel.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 110, -1));

        btnSignUp.setText("Daftar");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        SignInPanel.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 110, -1));
        SignInPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 280, 30));

        jLabel4.setText("Masuk sebagai : ");
        SignInPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        btnGroupTipe.add(radioAdmin);
        radioAdmin.setText("Admin");
        SignInPanel.add(radioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 193, -1, 30));

        btnGroupTipe.add(radioSiswa);
        radioSiswa.setText("Calon Siswa");
        SignInPanel.add(radioSiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 193, -1, 30));

        getContentPane().add(SignInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        Frame_Daftar daftar = new Frame_Daftar();
        daftar.setVisible(true);
        daftar.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        
        if(txtUsername.getText().isEmpty() && txtPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username dan Password masih kosong", "Error", JOptionPane.WARNING_MESSAGE);
        }else if (txtUsername.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Username masih kosong");
                txtUsername.requestFocus();
        }else if (txtPassword.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password masih kosong");
                txtPassword.requestFocus();
        }
        else{
            MainController mainProgram = new MainController();
            mainProgram.validasiAkun(getTxtUsername(), getTxtPassword(), getRadioUser());
            dispose();
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SignInPanel;
    private javax.swing.ButtonGroup btnGroupTipe;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioSiswa;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
