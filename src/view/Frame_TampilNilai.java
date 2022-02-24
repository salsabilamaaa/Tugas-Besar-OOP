/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Account;
import model.Database;

public class Frame_TampilNilai extends javax.swing.JFrame {
    Account akun;

    public Frame_TampilNilai() {
        initComponents();
    }
    
    public Frame_TampilNilai(Account user) {
        this.akun = user;
        initComponents();
        txtNilai();
    }
    
    public void setTxtBindo(String nilai){
        txtIndo.setText(nilai);
    }
    
    public void setTxtBing(String nilai){
        txtInggris.setText(nilai);
    }
    
    public void setTxtMTK(String nilai){
        txtMTK.setText(nilai);
    }
    
    public void setTxtIPA(String nilai){
        txtIPA.setText(nilai);
    }
    
    public void setTxtIPS(String nilai){
        txtIPS.setText(nilai);
    }
    
    public void setTxtPKN(String nilai){
        txtPkn.setText(nilai);
    }
    
    public void txtNilai(){
        Database conn = new Database();
        try {
            String SQL = "SELECT * FROM nilaisiswa WHERE username='" + akun.getUsername() + "';";
            ResultSet rs = conn.getData(SQL);
            while(rs.next()){
                setTxtBindo(rs.getString("bindo"));
                setTxtBing(rs.getString("bing"));
                setTxtMTK(rs.getString("mtk"));
                setTxtIPA(rs.getString("ipa"));
                setTxtIPS(rs.getString("ips"));
                setTxtPKN(rs.getString("pkn"));
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Ambil Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtIndo = new javax.swing.JLabel();
        txtInggris = new javax.swing.JLabel();
        txtPkn = new javax.swing.JLabel();
        txtMTK = new javax.swing.JLabel();
        txtIPS = new javax.swing.JLabel();
        txtIPA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nilai Siswa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 24, -1, -1));

        jLabel4.setText("Nilai");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 71, -1, -1));

        jLabel5.setText("Bahasa Indonesia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 114, -1, -1));

        jLabel6.setText("Bahasa Inggris");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 146, -1, -1));

        jLabel7.setText("Pkn");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 178, -1, -1));

        jLabel8.setText("Matematika");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 210, -1, -1));

        jLabel9.setText("IPA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 242, -1, -1));

        jLabel10.setText("IPS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 274, -1, -1));

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txtIndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 114, 63, 14));
        jPanel1.add(txtInggris, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 146, 63, 14));
        jPanel1.add(txtPkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 178, 63, 14));
        jPanel1.add(txtMTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 210, 63, 14));
        jPanel1.add(txtIPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 242, 63, 14));
        jPanel1.add(txtIPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 274, 63, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    public void TampilText(){
        try{
            String sql = "SELECT * FROM siswa WHERE nama = '"+ 
                    (Listnilai.getSelectedValue()) +"'";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                String bindo = Float.toString(rs.getFloat(1));
                String  ingg = Float.toString(rs.getFloat(2));
                String pkn = Float.toString(rs.getFloat(3));
                String math = Float.toString(rs.getFloat(4));
                String  ipa = Float.toString(rs.getFloat(5));
                String  ips = Float.toString(rs.getFloat(6));
                indo.setText(bindo);
                this.ingg.setText(ingg);
                this.pkn.setText(pkn);
                mtk.setText(math);
                this.ipa.setText(ipa);
                this.ips.setText(ips);
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }*/
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frame_Profil menu = new Frame_Profil(akun);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_TampilNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_TampilNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_TampilNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_TampilNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_TampilNilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtIPA;
    private javax.swing.JLabel txtIPS;
    private javax.swing.JLabel txtIndo;
    private javax.swing.JLabel txtInggris;
    private javax.swing.JLabel txtMTK;
    private javax.swing.JLabel txtPkn;
    // End of variables declaration//GEN-END:variables
}
