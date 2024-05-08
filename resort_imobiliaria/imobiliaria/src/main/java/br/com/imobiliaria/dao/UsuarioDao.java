package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso ao gravar o usuário no banco");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar o usuário no banco: " + e.getMessage());
            // Tratar a exceção apropriadamente, como lançar uma exceção personalizada ou registrar em log
        }
    }
    public boolean validarCredenciais(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE EMAIL = ? AND SENHA = ?";
    
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
    
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Retorna true se houver um usuário com as credenciais fornecidas
        } catch (SQLException e) {
            System.out.println("Erro ao validar as credenciais: " + e.getMessage());
            return false;
        }
    }
    
}

