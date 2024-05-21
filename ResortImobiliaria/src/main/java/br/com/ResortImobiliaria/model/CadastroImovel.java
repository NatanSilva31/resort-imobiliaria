package br.com.ResortImobiliaria.model;

public class CadastroImovel {
    private String idCadastroImovel;
    private String tituloImovel;
    private String endereco;
    private String numQuartos;
    private String numBanheiro;
    private String numVagas;
    private String valorNoite;
    private String imagens;
    private String obs;
    private String idUser;

    private String email;

    private String telefone;


    public CadastroImovel(){

    }

    public CadastroImovel(String tituloImovel, String endereco, String numQuartos, String numBanheiro, String numVagas, String valorNoite, String imagens, String obs, String idUser, String email, String telefone) {
        this.tituloImovel = tituloImovel;
        this.endereco = endereco;
        this.numQuartos = numQuartos;
        this.numBanheiro = numBanheiro;
        this.numVagas = numVagas;
        this.valorNoite = valorNoite;
        this.imagens = imagens;
        this.obs = obs;
        this.idUser = idUser;
        this.email = email;
        this.telefone = telefone;
    }

    public CadastroImovel(String tituloImovel, String endereco, String numQuartos, String numBanheiro, String numVagas, String valorNoite, String obs, String email, String telefone, String imagens) {
        this.tituloImovel = tituloImovel;
        this.endereco = endereco;
        this.numQuartos = numQuartos;
        this.numBanheiro = numBanheiro;
        this.numVagas = numVagas;
        this.valorNoite = valorNoite;
        this.obs = obs;
        this.email = email;
        this.telefone = telefone;
        this.imagens = imagens;
    }

    public CadastroImovel(String idCadastroImovel, String tituloImovel, String endereco, String numQuartos, String numBanheiro, String numVagas, String valorNoite, String imagens, String obs, String idUser, String email, String telefone) {
        this.idCadastroImovel = idCadastroImovel;
        this.tituloImovel = tituloImovel;
        this.endereco = endereco;
        this.numQuartos = numQuartos;
        this.numBanheiro = numBanheiro;
        this.numVagas = numVagas;
        this.valorNoite = valorNoite;
        this.imagens = imagens;
        this.obs = obs;
        this.idUser = idUser;
        this.email = email;
        this.telefone = telefone;
    }



    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTituloImovel() {
        return tituloImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumQuartos() {
        return numQuartos;
    }

    public String getNumBanheiro() {
        return numBanheiro;
    }

    public String getNumVagas() {
        return numVagas;
    }

    public String getValorNoite() {
        return valorNoite;
    }

    public String getImagens() {
        return imagens;
    }

    public String getObs() {
        return obs;
    }

    public String getIdCadastroImovel() {
        return idCadastroImovel;
    }

    public String getIdUser() {
        return idUser;
    }
}

