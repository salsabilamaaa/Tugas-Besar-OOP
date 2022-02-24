package model;

import java.util.Date;

public class CalonSiswa extends Account{
    private String nama, NISN, alamat, asal_sekolah, jurusan;
    private Account akun;
    private Date tgl_lahir;
    private boolean status;
    private Nilai Raport;

    public CalonSiswa() {
    }
    
    public CalonSiswa(String nama, String NISN){
        this.nama = nama;
        this.NISN = NISN;
    }
    public CalonSiswa(String email, String username, String password, String tipe) {
        super(email, username, password, tipe);
    }

    public CalonSiswa(String nama, String NISN, String asal_sekolah, String jurusan, String username){
        super(username);
        this.nama = nama;
        this.NISN = NISN;
        this.asal_sekolah = asal_sekolah;
        this.jurusan = jurusan;
    }
    public CalonSiswa(String nama, String NISN, String alamat, String asal_sekolah, String jurusan, Date tgl_lahir, String email, String username, String password, String tipe) {
        super(email, username, password, tipe);
        this.nama = nama;
        this.NISN = NISN;
        this.alamat = alamat;
        this.asal_sekolah = asal_sekolah;
        this.jurusan = jurusan;
        this.tgl_lahir = tgl_lahir;
    }
    
    public CalonSiswa(String nama, String NISN, String alamat, String asal_sekolah, String jurusan, Date tgl_lahir, String email, String username, String password, String tipe, Nilai Raport, boolean status) {
        super(email, username, password, tipe);
        this.nama = nama;
        this.NISN = NISN;
        this.alamat = alamat;
        this.asal_sekolah = asal_sekolah;
        this.jurusan = jurusan;
        this.tgl_lahir = tgl_lahir;
        this.Raport = Raport;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public String getNISN() {
        return NISN;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getAsal_sekolah() {
        return asal_sekolah;
    }

    public String getJurusan() {
        return jurusan;
    }

    public Account getAkun() {
        return akun;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public String isStatus() {
        if(status){
            return "LULUS";
        }else{
            return "TIDAK LULUS";
        }
    }

    public Nilai getRaport() {
        return Raport;
    }    

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNISN(String NISN) {
        this.NISN = NISN;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setAsal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setAkun(Account akun) {
        this.akun = akun;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRaport(Nilai Raport) {
        this.Raport = Raport;
    }

}
