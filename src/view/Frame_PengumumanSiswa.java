package view;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.Database;
import model.Pengumuman;

public class Frame_PengumumanSiswa extends javax.swing.JFrame {
    Account akun;
    Database conn = new Database();
    public Frame_PengumumanSiswa() {
        initComponents();
    }
    public Frame_PengumumanSiswa(Account user){
        this.akun = user;
        initComponents();
        addTable();
    }
    
    public String getCari(){
        return txtCari.getText();
    }
    
    public void addTable(){
        ArrayList<Pengumuman> lulus = new ArrayList<>();
        btnRegistrasi.setEnabled(false);
        Pengumuman siswa;
        try {
            String SQL = "SELECT * FROM pengumuman";
            ResultSet rs = conn.getData(SQL);
            while(rs.next()){
                siswa = new Pengumuman(rs.getString("nama"), rs.getString("NISN"), rs.getString("asal_sekolah"), rs.getString("jurusan"), rs.getString("noLulus"), rs.getString("username"));
                lulus.add(siswa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pengumuman belum dibuka", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel)tablePengumuman.getModel();
        Object[] row = new Object[6];
        for(int i=0; i < lulus.size(); i++){
            row[0] = lulus.get(i).getNama();
            row[1] = lulus.get(i).getNISN();
            row[2] = lulus.get(i).getAsal_sekolah();
            if (lulus.get(i).getNoLulus() == null ){
                row[3] = "TIDAK LULUS";
            }else{
                if (akun.getUsername().equals(lulus.get(i).getUsername())){
                    btnRegistrasi.setEnabled(true);
                }
                row[3] = "LULUS";
            }
            row[4] = lulus.get(i).getJurusan();
            if (lulus.get(i).getNoLulus() == null){
                row[5] = "-";
            }else{
                row[5] = lulus.get(i).getNoLulus();
            }
            model.addRow(row);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengumuman = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        btnRegistrasi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PENGUMUMAN CALON SISWA BARU");

        tablePengumuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NISN", "Asal Sekolah", "Status", "Jurusan", "No Lulus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePengumuman.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePengumuman);

        jLabel2.setText("Cari Nama");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnRegistrasi.setText("Regitrasi");
        btnRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnRegistrasi)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrasi)
                            .addComponent(btnBack))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frame_MenuSiswa siswa = new Frame_MenuSiswa(akun);
        
        siswa.setVisible(true);
        siswa.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablePengumuman.getModel();
        model.setRowCount(0);
        try {
            String SQL = "SELECT * FROM pengumuman WHERE nama='" + getCari() + "'";
            ResultSet rs = conn.getData(SQL);
            Object[] row = new Object[6];
            while(rs.next()){
                row[0] = rs.getString("nama");
                row[1] = rs.getString("NISN");
                row[2] = rs.getString("asal_sekolah");
                if (rs.getString("noLulus") == null ){
                    row[3] = "TIDAK LULUS";
                }else{
                    if (akun.getUsername().equals(rs.getString("username"))){
                        btnRegistrasi.setEnabled(true);
                    }
                    row[3] = "LULUS";
                }
                row[4] = rs.getString("jurusan");
                if (rs.getString("noLulus") == null){
                    row[5] = "-";
                }else{
                    row[5] = rs.getString("noLulus");
                }
                model.addRow(row);
            }
        } catch (Exception e) {
            
        }

        
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrasiActionPerformed
        Frame_Registrasi regis = new Frame_Registrasi(akun);
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnRegistrasiActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Pengumuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Pengumuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Pengumuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Pengumuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Pengumuman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnRegistrasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePengumuman;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
