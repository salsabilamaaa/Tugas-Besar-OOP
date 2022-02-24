package view;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Admin;
import model.CalonSiswa;
import model.Database;
import model.Nilai;

public class Frame_Pengumuman extends javax.swing.JFrame {
    Admin admin = new Admin("admin@gmail.com", "admin", "admin", "admin");
    Database conn = new Database();
    public Frame_Pengumuman() {
        initComponents();
        addTable();
    }
    
    public void addTable(){
        ArrayList<CalonSiswa> siswalist = new ArrayList<>();
        CalonSiswa siswa;
        try {
            String SQL = "SELECT * FROM daftar_siswa INNER JOIN nilaisiswa ON nilaisiswa.username=daftar_siswa.username INNER JOIN account ON nilaisiswa.username=account.username";
            ResultSet rs = conn.getData(SQL);
            Nilai raport;
            while(rs.next()){
                raport = new Nilai(rs.getFloat("bindo"), rs.getFloat("bing"), rs.getFloat("mtk"), rs.getFloat("ipa"), rs.getFloat("ips"), rs.getFloat("pkn"));
                siswa = new CalonSiswa(rs.getString("nama"), rs.getString("NISN"), rs.getString("alamat"), rs.getString("asal_sekolah"), rs.getString("jurusan"), rs.getDate("tgl_lahir"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("tipe"), raport, rs.getBoolean("status"));
                siswalist.add(siswa);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Ambil Data", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            String SQL = "SELECT * FROM nilaistandar";
            ResultSet rs = conn.getData(SQL);
            while(rs.next()){
                admin.setNilaiStandarSekolah(rs.getFloat("umum"));
                System.out.println("Umum : " + admin.getNilaiStandarSekolah());
                admin.setNilaiStandarIPA(rs.getFloat("ipa"));
                System.out.println("IPA  : " + admin.getNilaiStandarIPA());
                admin.setNilaiStandarIPS(rs.getFloat("ips"));
                System.out.println("IPS  : " + admin.getNilaiStandarIPS());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Ambil Data Nilai Standar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        for(CalonSiswa s : siswalist){
            float umum = s.getRaport().getAvgUmum();
            float jurusan = s.getRaport().getAvgJurusan(s.getJurusan());
            
            if(umum >= admin.getNilaiStandarSekolah()){
                s.setStatus(true);
                if(s.getJurusan().equalsIgnoreCase("ipa")){
                    if(jurusan >= admin.getNilaiStandarIPA()){
                        s.setStatus(true);
                        System.out.println(s.getNama() + " : " + jurusan + " TRUE ");
                    }else{
                        s.setStatus(false);
                        System.out.println(s.getNama() + " : " + jurusan + " FALSE ");
                    }
                }else{
                    if(jurusan >= admin.getNilaiStandarIPS()){
                        s.setStatus(true);
                        System.out.println(s.getNama() + " : " + jurusan + " TRUE ");
                    }else{
                        s.setStatus(false);
                        System.out.println(s.getNama() + " : " + jurusan + " FALSE ");
                    }
                }
            }else{
                s.setStatus(false);
            }
        }
        insertPengumuman(siswalist);
        DefaultTableModel model = (DefaultTableModel)tablePengumuman.getModel();
        Object[] row = new Object[8];
        for(int i=0; i < siswalist.size(); i++){
            row[0] = siswalist.get(i).getNama();
            row[1] = siswalist.get(i).getNISN();
            row[2] = siswalist.get(i).getAsal_sekolah();
            row[3] = siswalist.get(i).getJurusan();
            row[4] = siswalist.get(i).isStatus();
            
            model.addRow(row);
        }
    }

    public void insertPengumuman(ArrayList<CalonSiswa> siswa){
        String start = "TRUNCATE TABLE pengumuman";
        conn.Query(start);
        try {
            int no = 0;
            for(int i=0; i < siswa.size(); i++){
                if (siswa.get(i).isStatus().equalsIgnoreCase("Lulus")){
                    String SQL = "INSERT INTO pengumuman (nama, NISN, username, asal_sekolah, jurusan, noLulus) "
                        + "VALUES ('"
                        + siswa.get(i).getNama() + "', '"
                        + siswa.get(i).getNISN() + "', '"
                        + siswa.get(i).getUsername() + "', '"
                        + siswa.get(i).getAsal_sekolah() + "', '"
                        + siswa.get(i).getJurusan() + "', '"
                        + "102122" + String.valueOf(no) + "')";
                    conn.Query(SQL);
                    no++;
                }else{
                    String SQL = "INSERT INTO pengumuman (nama, NISN, username, asal_sekolah, jurusan, noLulus) "
                        + "VALUES ('"
                        + siswa.get(i).getNama() + "', '"
                        + siswa.get(i).getNISN() + "', '"
                        + siswa.get(i).getUsername() + "', '"
                        + siswa.get(i).getAsal_sekolah() + "', '"
                        + siswa.get(i).getJurusan() + "', NULL )";
                    conn.Query(SQL);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Insert Pengumuman Siswa", "Error", JOptionPane.ERROR_MESSAGE);
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
                "Nama", "NISN", "Asal Sekolah", "Jurusan", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePengumuman.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePengumuman);

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
                        .addGap(0, 175, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
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
        Frame_MenuAdmin admin = new Frame_MenuAdmin();
        
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePengumuman;
    // End of variables declaration//GEN-END:variables
}
