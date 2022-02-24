package model;

public class Registrasi extends Pengumuman{
    private String nama;
    private String NISN;
    private String nolulus;
    
    public Registrasi(String nama, String NISN, String nolulus) {
        super(nama, NISN, nolulus);
    }

    public String getNama() {
        return nama;
    }

    public String getNISN() {
        return NISN;
    }

    public String getNo_lulus() {
        return nolulus;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNISN(String NISM) {
        this.NISN = NISM;
    }

    public void setNo_lulus(String no_lulus) {
        this.nolulus = no_lulus;
    }
    
}
