package model;

public class Nilai {
    private float bindo;
    private float bing;
    private float mtk;
    private float ipa;
    private float ips;
    private float pkn;
    private float avgUmum;
    private float avgJurusan;

    public Nilai(float bindo, float bing, float mtk, float ipa, float ips, float pkn) {
        this.bindo = bindo;
        this.bing = bing;
        this.mtk = mtk;
        this.ipa = ipa;
        this.ips = ips;
        this.pkn = pkn;
    }

    public float getBindo() {
        return bindo;
    }

    public float getBing() {
        return bing;
    }

    public float getIpa() {
        return ipa;
    }

    public float getIps() {
        return ips;
    }

    public float getMtk() {
        return mtk;
    }

    public float getPkn() {
        return pkn;
    }
    
    public float getAvgJurusan(String jurusan) {
        averageJurusan(jurusan);
        return avgJurusan;
    }

    public float getAvgUmum() {
        averageUmum();
        return avgUmum;
    }

    public void setBindo(float bindo) {
        this.bindo = bindo;
    }

    public void setBing(float bing) {
        this.bing = bing;
    }

    public void setIpa(float ipa) {
        this.ipa = ipa;
    }

    public void setIps(float ips) {
        this.ips = ips;
    }

    public void setMtk(float mtk) {
        this.mtk = mtk;
    }

    public void setPkn(float pkn) {
        this.pkn = pkn;
    }
    
    public void setAvgJurusan(float avgJurusan) {
        this.avgJurusan = avgJurusan;
    }

    public void setAvgUmum(float avgUmum) {
        this.avgUmum = avgUmum;
    }
    
    public void averageUmum(){
        this.avgUmum = (this.bindo + this.bing + this.mtk + this.ipa + this.ips + this.pkn)/6;
    }
    
    public void averageJurusan(String jurusan){
        if (jurusan.equalsIgnoreCase("ipa")){
            this.avgJurusan = (this.mtk + this.ipa)/2;
        }else{
            this.avgJurusan = (this.ips + this.pkn)/2;
        }
    }
}
