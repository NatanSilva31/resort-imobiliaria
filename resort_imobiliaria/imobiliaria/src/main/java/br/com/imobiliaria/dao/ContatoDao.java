package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDao {

    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, email, mensagem) VALUES (?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setString(3, contato.getMensagem());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso ao gravar o contato no banco");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar o contato no banco: " + e.getMessage());
            // Tratar a exceção apropriadamente, como lançar uma exceção personalizada ou registrar em log
        }
    }
}
