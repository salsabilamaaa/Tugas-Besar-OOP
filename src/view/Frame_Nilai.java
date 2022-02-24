package view;

import javax.swing.JOptionPane;
import model.Account;
import model.Database;

public class Frame_Nilai extends javax.swing.JFrame {
    Account user;

    public Frame_Nilai() {
        initComponents();
    }

    public Frame_Nilai(Account user){
        this.user = user;
        initComponents();
    }
    
    public float getTxtBindo(){
        return Float.valueOf(txtIndo.getText());
    }
    
    public float getTxtBing(){
        return Float.valueOf(txtInggris.getText());
    }
    
    public float getTxtMTK(){
        return Float.valueOf(txtMTK.getText());
    }
    
    public float getTxtIPA(){
        return Float.valueOf(txtIPA.getText());
    }
    
    public float getTxtIPS(){
        return Float.valueOf(txtIPS.getText());
    }
    
    public float getTxtPkn(){
        return Float.valueOf(txtPKN.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIndo = new javax.swing.JTextField();
        txtInggris = new javax.swing.JTextField();
        txtMTK = new javax.swing.JTextField();
        txtIPA = new javax.swing.JTextField();
        txtIPS = new javax.swing.JTextField();
        txtPKN = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Input Nilai");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 28, -1, -1));

        jLabel2.setText("B.Indonesia");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 107, -1, -1));

        jLabel3.setText("B.Inggris");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 153, -1, -1));

        jLabel4.setText("Matematika");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 199, -1, -1));

        jLabel5.setText("IPA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 245, -1, -1));

        jLabel6.setText("IPS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 291, -1, -1));

        jLabel7.setText("PKn");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 337, -1, -1));
        jPanel1.add(txtIndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 100, 70, 28));
        jPanel1.add(txtInggris, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 146, 70, 28));
        jPanel1.add(txtMTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 192, 70, 28));
        jPanel1.add(txtIPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 238, 70, 28));
        jPanel1.add(txtIPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 284, 70, 28));
        jPanel1.add(txtPKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 330, 70, 28));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 386, -1, -1));

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frame_DataDiri form = new Frame_DataDiri(user);
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Database conn = new Database();
        try {
            String SQL = "INSERT INTO `nilaisiswa`(`bindo`, `bing`, `mtk`, `ipa`, `ips`, `pkn`, `username`) "
                    + " VALUES ("
                    + getTxtBindo() + ", "
                    + getTxtBing() + ", "
                    + getTxtMTK() + ", "
                    + getTxtIPA() + ", "
                    + getTxtIPS() + ", "
                    + getTxtIPS() + ", '"
                    + user.getUsername() + "');";
            
            conn.Query(SQL);
            JOptionPane.showMessageDialog(null, "Berhasil Input Nilai", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            Frame_MenuSiswa menu = new Frame_MenuSiswa(user);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error menyimpan nilai", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIPA;
    private javax.swing.JTextField txtIPS;
    private javax.swing.JTextField txtIndo;
    private javax.swing.JTextField txtInggris;
    private javax.swing.JTextField txtMTK;
    private javax.swing.JTextField txtPKN;
    // End of variables declaration//GEN-END:variables
}
