package model;

public class Account {
    private String email;
    private String username;
    private String password;
    private String tipe;

    public Account() {
    }

    public Account(String email, String username, String password, String tipe) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.tipe = tipe;
    }

    public Account(String username){
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipe() {
        return tipe;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
