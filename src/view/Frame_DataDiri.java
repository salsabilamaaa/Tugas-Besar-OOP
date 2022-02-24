/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Account;
import model.Database;

public class Frame_DataDiri extends javax.swing.JFrame {
    Account akun;

    public Frame_DataDiri() {
        initComponents();
    }

    public Frame_DataDiri(Account user){
        this.akun = user;
        initComponents();
    }

    public String getTxtNama() {
        return txtNama.getText();
    }
    
    public String getTxtNISN() {
        return txtNISN.getText();
    }
    
    public LocalDate getDate() {
        LocalDate born = LocalDate.of(
            Integer.parseInt(comboYear.getSelectedItem().toString()),
            comboMonth.getSelectedIndex()+1,
            Integer.parseInt(comboDay.getSelectedItem().toString())
        );
        return born;
    }
    
    public String getTxtSekolah(){
        return txtAsal_Sekolah.getText();
    }
    
    public String getTxtAlamat(){
        return txtAlamat.getText();
    }

    public String getRadioButton(){
        if(RadioIPA.isSelected()){
            return "IPA";
        }else{
            return "IPS";
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupJurusan = new javax.swing.ButtonGroup();
        DataDiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RadioIPA = new javax.swing.JRadioButton();
        RadioIPS = new javax.swing.JRadioButton();
        txtNama = new javax.swing.JTextField();
        txtAsal_Sekolah = new javax.swing.JTextField();
        txtNISN = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        comboDay = new javax.swing.JComboBox<>();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataDiri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pendaftaran Calon Siswa");
        DataDiri.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 34, -1, -1));

        jLabel2.setText("Nama Lengkap");
        DataDiri.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 99, -1, -1));

        jLabel3.setText("Alamat");
        DataDiri.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 146, -1, -1));

        jLabel4.setText("Tanggal Lahir");
        DataDiri.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setText("Asal Sekolah");
        DataDiri.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel6.setText("NISN");
        DataDiri.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel7.setText("Pilih Jurusan");
        DataDiri.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        btnGroupJurusan.add(RadioIPA);
        RadioIPA.setText("IPA");
        DataDiri.add(RadioIPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        btnGroupJurusan.add(RadioIPS);
        RadioIPS.setText("IPS");
        DataDiri.add(RadioIPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));
        DataDiri.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 92, 491, 29));
        DataDiri.add(txtAsal_Sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 491, 28));
        DataDiri.add(txtNISN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 491, 28));

        btnNext.setText("Berikutnya");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        DataDiri.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 120, -1));

        comboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DataDiri.add(comboDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 56, -1));

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        DataDiri.add(comboMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 125, -1));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));
        DataDiri.add(comboYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 75, -1));

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        DataDiri.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 490, 100));

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        DataDiri.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(DataDiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (getTxtNISN().isEmpty() && getTxtNama().isEmpty() && getTxtAlamat().isEmpty() && getTxtSekolah().isEmpty() && getRadioButton().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form belum terisi lengkap", "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            Database conn = new Database();
            try {
                String SQL = "INSERT INTO daftar_siswa(NISN,nama,alamat,asal_sekolah,username,tgl_lahir,status,jurusan)"
                        + "VALUE ("
                        +"'"+getTxtNISN()+"' ,"
                        +"'"+getTxtNama()+"' ,"
                        +"'"+getTxtAlamat()+"' ,"
                        +"'"+getTxtSekolah()+"' ,"
                        +"'"+akun.getUsername()+"' ,"
                        +"'"+getDate()+"' ,"
                        +"TRUE, '"+getRadioButton()+"');";

                conn.Query(SQL);
                JOptionPane.showMessageDialog(null, "Data Berhasil DiInputkan");

                Frame_Nilai nilai = new Frame_Nilai(akun);
                nilai.setVisible(true);
                nilai.setLocationRelativeTo(null);
                dispose();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frame_MenuSiswa menu = new Frame_MenuSiswa(akun);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DataDiri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frame_DataDiri().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataDiri;
    private javax.swing.JRadioButton RadioIPA;
    private javax.swing.JRadioButton RadioIPS;
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroupJurusan;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtAsal_Sekolah;
    private javax.swing.JTextField txtNISN;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
