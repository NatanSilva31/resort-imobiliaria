package br.com.ResortImobiliaria.model;

public class User {

    private int idUser;
    private String name;
    private String email;
    private String docPfPj;
    private String password;

    public User() {

    }

    public User(String name, String email, String docPfPj, String password) {
        this.name = name;
        this.email = email;
        this.docPfPj = docPfPj;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocPfPj() {
        return docPfPj;
    }

    public void setDocPfPj(String docPfPj) {
        this.docPfPj = docPfPj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
