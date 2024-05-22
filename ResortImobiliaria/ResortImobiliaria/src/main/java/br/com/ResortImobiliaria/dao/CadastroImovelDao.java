package br.com.ResortImobiliaria.dao;

import br.com.ResortImobiliaria.model.CadastroImovel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CadastroImovelDao {

    public void createImovel(CadastroImovel imovel) {

        String SQL = "INSERT INTO CADASTRO_IMOVEL(TITULO_IMOVEL, ENDERECO,NUM_QUARTOS, NUM_BANHEIROS, NUM_VAGAS, VALOR_NOITE, IMAGENS, OBS, email, telefone, id_user) VALUES (?,?,?,?,?,?,?,?,?,?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, imovel.getTituloImovel());
            preparedStatement.setString(2, imovel.getEndereco());
            preparedStatement.setString(3, imovel.getNumQuartos());
            preparedStatement.setString(4, imovel.getNumBanheiro());
            preparedStatement.setString(5, imovel.getNumVagas());
            preparedStatement.setString(6, imovel.getValorNoite());
            preparedStatement.setString(7, imovel.getImagens());
            preparedStatement.setString(8, imovel.getObs());
            preparedStatement.setString(9, imovel.getEmail());
            preparedStatement.setString(10, imovel.getTelefone());
            preparedStatement.setString(11, imovel.getIdUser());


            preparedStatement.execute();


            System.out.println("Sucesso em inserir o imovel");

            connection.close();

        } catch (Exception e) {

            System.out.print("Erro no processamento" + e.getMessage());

        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------
    public List<CadastroImovel> ListadeImoveis() {
        String SQL = "SELECT * FROM  CADASTRO_IMOVEL";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão com o banco de dados h2");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<CadastroImovel> imovel = new ArrayList<>();

            while (resultSet.next()) {
                String idCadastroImovel = resultSet.getNString("ID_CADASTRO_IMOVEL");
                String tituloImovel = resultSet.getNString("TITULO_IMOVEL");
                String endereco = resultSet.getNString("ENDERECO");
                String numQuartos = resultSet.getNString("NUM_QUARTOS");
                String numBanheiros = resultSet.getNString("NUM_BANHEIROS");
                String numVagas = resultSet.getNString("NUM_VAGAS");
                String valorNoite = resultSet.getNString("VALOR_NOITE");
                String imagem = resultSet.getString("IMAGENS");
                String obs = resultSet.getNString("OBS");
                String email = resultSet.getNString("email");
                String telefone = resultSet.getNString("telefone");
                String idUser = resultSet.getNString("id_user");

                CadastroImovel i = new CadastroImovel(idCadastroImovel, tituloImovel, endereco, numQuartos, numBanheiros, numVagas, valorNoite, imagem, obs, idUser, email, telefone);

                imovel.add(i);


            }

            System.out.println("Codigo rodando perfeitamente");

            connection.close();

            return imovel;

        } catch (SQLException e) {
            System.out.println("Erro no processamento " + e.getMessage());

            return Collections.emptyList();


        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void deleteCadastroImovelById(String CadastroImovelId) {
        String SQL = "DELETE FROM CADASTRO_IMOVEL WHERE ID_CADASTRO_IMOVEL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão com o banco de dados h2");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, CadastroImovelId);
            preparedStatement.execute();

            System.out.println("SUCESSO EM DELETAR CADASTRO IMOVEL COM ID " + CadastroImovelId);

            connection.close();


        } catch (Exception e) {
            System.out.println("ERRO AO CONECTAR AO BANCO DE DADOS");
        }
    }


    // -----------------------------------------------------------------------------------------------------------------------------------

    public void updateCadastroImovel(CadastroImovel cad) {
        String SQL = "UPDATE CADASTRO_IMOVEL SET TITULO_IMOVEL = ?, ENDERECO = ?, NUM_QUARTOS = ?, NUM_BANHEIROS = ?, NUM_VAGAS = ?, VALOR_NOITE = ?, IMAGENS = ?, OBS = ?, email = ?, telefone  = ? WHERE ID_CADASTRO_IMOVEL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso na conexão com o banco de dados");


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cad.getTituloImovel());
            preparedStatement.setString(2, cad.getEndereco());
            preparedStatement.setString(3, cad.getNumQuartos());
            preparedStatement.setString(4, cad.getNumBanheiro());
            preparedStatement.setString(5, cad.getNumVagas());
            preparedStatement.setString(6, cad.getValorNoite());
            preparedStatement.setString(7, cad.getImagens());
            preparedStatement.setString(8, cad.getObs());
            preparedStatement.setString(9, cad.getEmail());
            preparedStatement.setString(10, cad.getTelefone());
            preparedStatement.setString(11, cad.getIdCadastroImovel());

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println(rowsUpdated + " linha(s) atualizada(s)");

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar no banco de dados ");
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public CadastroImovel findImovelbyID(String id) {

        String SQL = "SELECT * FROM CADASTRO_IMOVEL WHERE ID_CADASTRO_IMOVEL = ?";


        try {


            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            CadastroImovel imovel = new CadastroImovel();
            while (resultSet.next()) {
                String idCadastroImovel = resultSet.getNString("ID_CADASTRO_IMOVEL");
                String tituloImovel = resultSet.getNString("TITULO_IMOVEL");
                String endereco = resultSet.getNString("ENDERECO");
                String numQuartos = resultSet.getNString("NUM_QUARTOS");
                String numBanheiros = resultSet.getNString("NUM_BANHEIROS");
                String numVagas = resultSet.getNString("NUM_VAGAS");
                String valorNoite = resultSet.getNString("VALOR_NOITE");
                String imagem = resultSet.getNString("IMAGENS");
                String obs = resultSet.getNString("OBS");
                String email = resultSet.getNString("email");
                String telefone = resultSet.getNString("telefone");

                imovel = new CadastroImovel(idCadastroImovel, tituloImovel, endereco, numQuartos, numBanheiros, numVagas, valorNoite, imagem, obs, email, telefone);


            }
            connection.close();

            return imovel;
        } catch (Exception e) {
            System.out.println("Erro ao consultar imovel " + e.getMessage());
            return null;
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public CadastroImovel findImovelbyIDInfo(String id) {

        String SQL = "SELECT * FROM CADASTRO_IMOVEL WHERE ID_CADASTRO_IMOVEL = ?";


        try {


            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            CadastroImovel imovel = new CadastroImovel();
            while (resultSet.next()) {

                String tituloImovel = resultSet.getNString("TITULO_IMOVEL");
                String endereco = resultSet.getNString("ENDERECO");
                String numQuartos = resultSet.getNString("NUM_QUARTOS");
                String numBanheiros = resultSet.getNString("NUM_BANHEIROS");
                String numVagas = resultSet.getNString("NUM_VAGAS");
                String valorNoite = resultSet.getNString("VALOR_NOITE");
                String obs = resultSet.getNString("OBS");
                String email = resultSet.getNString("email");
                String telefone = resultSet.getNString("telefone");
                String imagem = resultSet.getNString("IMAGENS");

                imovel = new CadastroImovel(tituloImovel, endereco, numQuartos, numBanheiros, numVagas, valorNoite, obs, email, telefone , imagem);


            }
            connection.close();

            return imovel;
        } catch (Exception e) {
            System.out.println("Erro ao consultar imovel " + e.getMessage());
            return null;
        }
    }

}