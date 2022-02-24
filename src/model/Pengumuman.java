package model;

public class Pengumuman extends CalonSiswa{
    private String nama, NISN, asal_sekolah, jurusan, username;
    private String nolulus = "";

    public Pengumuman(String nama, String NISN, String nolulus){
        super(nama, NISN);
        this.nolulus = nolulus;
    }
    
    public Pengumuman(String nama, String NISN, String asal_sekolah, String jurusan, String no_lulus, String username) {
        this.nama = nama;
        this.NISN = NISN;
        this.nolulus = no_lulus;
        this.asal_sekolah = asal_sekolah;
        this.jurusan = jurusan;
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public String getNISN() {
        return NISN;
    }

    public String getAsal_sekolah() {
        return asal_sekolah;
    }

    public String getNoLulus() {
        return nolulus;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getUsername() {
        return username;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNISN(String NISN) {
        this.NISN = NISN;
    }

    public void setAsal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
    }

    public void setNoLulus(String nolulus) {
        this.nolulus = nolulus;
    }

    public void setJurusan(String Jurusan) {
        this.jurusan = Jurusan;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
