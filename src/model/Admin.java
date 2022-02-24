package model;

public class Admin extends Account{
    private float NilaiStandarSekolah;
    private float NilaiStandarIPA;
    private float NilaiStandarIPS;
    
    public Admin(String email, String username, String password, String tipe) {
        super(email, username, password, tipe);
    }

    public float getNilaiStandarSekolah() {
        return NilaiStandarSekolah;
    }

    public float getNilaiStandarIPA() {
        return NilaiStandarIPA;
    }

    public float getNilaiStandarIPS() {
        return NilaiStandarIPS;
    }

    public void setNilaiStandarSekolah(float NilaiStandarSekolah) {
        this.NilaiStandarSekolah = NilaiStandarSekolah;
    }

    public void setNilaiStandarIPA(float NilaiStandarIPA) {
        this.NilaiStandarIPA = NilaiStandarIPA;
    }

    public void setNilaiStandarIPS(float NilaiStandarIPS) {
        this.NilaiStandarIPS = NilaiStandarIPS;
    }
}