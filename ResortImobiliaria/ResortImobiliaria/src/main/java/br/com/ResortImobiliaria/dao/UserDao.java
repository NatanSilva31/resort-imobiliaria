package br.com.ResortImobiliaria.dao;

import br.com.ResortImobiliaria.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {
    public void createUser(User user){

        try {
            String SQL = "INSERT INTO USUARIO (NOME_COMPLETO, EMAIL, CPF_CNPJ, SENHA) VALUES (?, ?, ?, ?)";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            if (connection != null) {
                System.out.println("Sucesso na conexão");
            } else {
                System.out.println("Falha na conexão");
                return;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getDocPfPj());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.execute();

            System.out.println("Sucesso ao adicionar usuario");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void readUser(User user) {
        try {
            String SQL = "SELECT NOME_COMPLETO, EMAIL, CPF_CNPJ FROM USUARIO WHERE ID = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, user.getIdUser());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setName(resultSet.getString("NOME_COMPLETO"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setDocPfPj(resultSet.getString("CPF_CNPJ"));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void UpdateUser(User user){
        try{
            String SQL = "UPDADE IMOBILIARIA.Usarios SET NOME_COMPLETO = ?" +
                                                          "EMAIL = ?" +
                                                          "CPF_CNPJ = ? " +
                                                          "SENHA = ?" +
                                                          "WHERE ID = ?";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            if (connection != null) {
                System.out.println("Sucesso na conexão");
            } else {
                System.out.println("Falha na conexão");
                return;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getDocPfPj());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getIdUser());

            preparedStatement.execute();

            System.out.println("Sucesso ao adicionar usuario");

            connection.close();

        }catch (Exception ex){
            System.out.println("Falha ao fazer o update no usuarios" + ex.getMessage());
        }
    }

    public void deleteUser(User user){

        try {
            String SQL = "DELETE FROM USUARIO WHERE ID = ?";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            if (connection != null) {
                System.out.println("Sucesso na conexão");
            } else {
                System.out.println("Falha na conexão");
                return;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, user.getIdUser());

            preparedStatement.execute();

            System.out.println("Sucesso em deletar o usuario");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public boolean emailExists(String email) {
        try {
            String SQL = "SELECT COUNT(*) FROM CADASTRO WHERE EMAIL = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean docExists(String doc) {
        try {
            String SQL = "SELECT COUNT(*) FROM CADASTRO WHERE DOC = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, doc);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public int getUserId(String email, String password) {
        try {
            String SQL = "SELECT ID FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("ID");
                System.out.println("Sucesso no login do usuario:" + userId); // Adiciona esta linha para imprimir o ID do usuário
                return userId;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }
}
