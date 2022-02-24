package view;

import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Account;
import model.Database;

public class Frame_Profil extends javax.swing.JFrame {
    Account akun;
    public Frame_Profil() {
        initComponents();
    }
    
    public Frame_Profil(Account user){
        this.akun = user;
        initComponents();
        profil();
    }
    
    public void setTxtNama(String nama){
        outNama.setText(nama);
    }
    
    public void setTxtNISN(String NISN){
        outNISN.setText(NISN);
    }
    
    public void setTxtAlamat(String Alamat){
        outAlamat.setText(Alamat);
    }
    
    public void setTxtSekolah(String sekolah){
        outAsalSekolah.setText(sekolah);
    }
    
    public void setTxtJurusan(String jurusan){
        outJurusan.setText(jurusan);
    }
    
    public void setDate(String date){
        outTgl_Lahir.setText(date);
    }
    
    public String getTxtNama(){
        return txtNama.getText();
    }
    
    public String getTxtNISN(){
        return txtNISN.getText();
    }
    
    public String getTxtAlamat(){
        return txtAlamat.getText();
    }
    
    public String getTxtSekolah(){
        return txtAsalSekolah.getText();
    }
    
    public String getRadioJurusan(){
        if(radioIPA.isSelected()){
            return "IPA";
        }else{
            return "IPS";
        }
    }
    
    public LocalDate getBornDate(){
        LocalDate born = LocalDate.of(
            Integer.parseInt(comboYear.getSelectedItem().toString()),
            comboMonth.getSelectedIndex()+1,
            Integer.parseInt(comboDay.getSelectedItem().toString())
        );
        return born;
    }
    
    
    public void profil(){
        Database conn = new Database();
        try {
            String SQL = "SELECT * FROM daftar_siswa WHERE username='" + akun.getUsername() + "';";
            ResultSet rs = conn.getData(SQL);
            while(rs.next()){
                setTxtNama(rs.getString("nama"));
                setTxtNISN(rs.getString("NISN"));
                setTxtAlamat(rs.getString("alamat"));
                setTxtSekolah(rs.getString("asal_sekolah"));
                setTxtJurusan(rs.getString("jurusan"));
                setDate(rs.getString("tgl_lahir"));
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Ambil Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(){
        Database conn = new Database();
        try {
            String SQL = "SELECT * FROM daftar_siswa WHERE username='" + akun.getUsername() + "';";
            ResultSet rs = conn.getData(SQL);
            while(rs.next()){
                txtNama.setText(rs.getString("nama"));
                txtNISN.setText(rs.getString("NISN"));
                txtAlamat.setText(rs.getString("alamat"));
                txtAsalSekolah.setText(rs.getString("asal_sekolah"));
                if (rs.getString("jurusan").equalsIgnoreCase("IPA")){
                    radioIPA.setSelected(true);
                }else{
                    radioIPS.setSelected(true);
                }
                String tglLahir = rs.getString("tgl_lahir");
                comboYear.setSelectedItem(tglLahir.toString().substring(0, 4));
                comboMonth.setSelectedIndex(Integer.parseInt(tglLahir.toString().substring(5, 7))-1);
                comboDay.setSelectedItem(tglLahir.toString().substring(8, 10));
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Ambil Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameUpdate = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtNama = new javax.swing.JTextField();
        comboDay = new javax.swing.JComboBox<>();
        txtNISN = new javax.swing.JTextField();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        txtAsalSekolah = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        radioIPA = new javax.swing.JRadioButton();
        radioIPS = new javax.swing.JRadioButton();
        btnBackUpdate = new javax.swing.JButton();
        btnUpdateProfil = new javax.swing.JButton();
        btnGroupJurusan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        outNama = new javax.swing.JLabel();
        outNISN = new javax.swing.JLabel();
        outTgl_Lahir = new javax.swing.JLabel();
        outAlamat = new javax.swing.JLabel();
        outAsalSekolah = new javax.swing.JLabel();
        outJurusan = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnNilai = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Update Profil");

        jLabel9.setText("Nama");

        jLabel10.setText("NISN");

        jLabel11.setText("Tanggal Lahir");

        jLabel12.setText("Alamat");

        jLabel13.setText("Asal Sekolah");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        comboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDayActionPerformed(evt);
            }
        });

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Agustus", "September", "Oktober", "November", "Desember" }));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        jLabel14.setText("Pilih Jurusan");

        btnGroupJurusan.add(radioIPA);
        radioIPA.setText("IPA");

        btnGroupJurusan.add(radioIPS);
        radioIPS.setText("IPS");

        btnBackUpdate.setText("Kembali");
        btnBackUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUpdateActionPerformed(evt);
            }
        });

        btnUpdateProfil.setText("Update");
        btnUpdateProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNama)
                            .addComponent(txtNISN)
                            .addComponent(txtAsalSekolah)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radioIPA)
                                .addGap(18, 18, 18)
                                .addComponent(radioIPS))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackUpdate)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(btnUpdateProfil)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackUpdate)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNISN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAsalSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(radioIPA)
                    .addComponent(radioIPS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnUpdateProfil)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout FrameUpdateLayout = new javax.swing.GroupLayout(FrameUpdate.getContentPane());
        FrameUpdate.getContentPane().setLayout(FrameUpdateLayout);
        FrameUpdateLayout.setHorizontalGroup(
            FrameUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FrameUpdateLayout.setVerticalGroup(
            FrameUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Profil");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 28, -1, -1));

        jLabel2.setText("Nama");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 75, -1, -1));

        jLabel3.setText("NISN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 107, -1, -1));

        jLabel4.setText("Tanggal Lahir");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 139, -1, -1));

        jLabel5.setText("Alamat");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 171, -1, -1));

        jLabel6.setText("Asal Sekolah");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 203, -1, -1));

        jLabel7.setText("Jursan Pilihan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 235, -1, -1));

        outNama.setText(":");
        jPanel1.add(outNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 75, 307, -1));

        outNISN.setText(":");
        jPanel1.add(outNISN, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 107, 307, -1));

        outTgl_Lahir.setText(":");
        jPanel1.add(outTgl_Lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 139, 307, -1));

        outAlamat.setText(":");
        jPanel1.add(outAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 171, 307, -1));

        outAsalSekolah.setText(":");
        jPanel1.add(outAsalSekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 203, 307, -1));

        outJurusan.setText(":");
        jPanel1.add(outJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 235, 307, -1));

        btnUpdate.setText("Update Profil");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        btnNilai.setText("Cek Nilai");
        btnNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNilaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 100, -1));

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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        FrameUpdate.show();
        FrameUpdate.pack();
        FrameUpdate.setLocationRelativeTo(null);
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frame_MenuSiswa menu = new Frame_MenuSiswa(akun);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNilaiActionPerformed
        Frame_TampilNilai nilai = new Frame_TampilNilai(akun);
        nilai.setVisible(true);
        nilai.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnNilaiActionPerformed

    private void btnBackUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUpdateActionPerformed
        this.setVisible(true);
        FrameUpdate.dispose();
    }//GEN-LAST:event_btnBackUpdateActionPerformed

    private void comboDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDayActionPerformed

    private void btnUpdateProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfilActionPerformed
        Database conn = new Database();
            try {
                String SQL = "UPDATE daftar_siswa SET "
                        + "NISN="
                        +"'"+getTxtNISN()+"' , nama="
                        +"'"+getTxtNama()+"' , alamat="
                        +"'"+getTxtAlamat()+"' , asal_sekolah="
                        +"'"+getTxtSekolah()+"' , tgl_lahir="
                        +"'"+getBornDate()+"' , jurusan="
                        +"'"+getRadioJurusan()+"' WHERE username='"+akun.getUsername()+"';";

                conn.Query(SQL);
                JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate");
                dispose();
                
                Frame_MenuSiswa menu = new Frame_MenuSiswa(akun);
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                FrameUpdate.dispose();
                this.dispose();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
    }//GEN-LAST:event_btnUpdateProfilActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameUpdate;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBackUpdate;
    private javax.swing.ButtonGroup btnGroupJurusan;
    private javax.swing.JButton btnNilai;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateProfil;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel outAlamat;
    private javax.swing.JLabel outAsalSekolah;
    private javax.swing.JLabel outJurusan;
    private javax.swing.JLabel outNISN;
    private javax.swing.JLabel outNama;
    private javax.swing.JLabel outTgl_Lahir;
    private javax.swing.JRadioButton radioIPA;
    private javax.swing.JRadioButton radioIPS;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtAsalSekolah;
    private javax.swing.JTextField txtNISN;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
