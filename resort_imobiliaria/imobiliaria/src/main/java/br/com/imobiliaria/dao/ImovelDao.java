package br.com.imobiliaria.dao;

import br.com.imobiliaria.model.Imovel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImovelDao {

    public void adicionarImovel(Imovel imovel) {
        String sql = "INSERT INTO imoveis (titulo, endereco, tipo, preco, descricao, status, comentarios) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, imovel.getTitulo());
            preparedStatement.setString(2, imovel.getEndereco());
            preparedStatement.setString(3, imovel.getTipo());
            preparedStatement.setDouble(4, imovel.getPreco());
            preparedStatement.setString(5, imovel.getDescricao());
            preparedStatement.setString(6, imovel.getStatus());
            preparedStatement.setString(7, imovel.getComentarios());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso ao gravar o imóvel no banco");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar o imóvel no banco: " + e.getMessage());
            // Tratar a exceção apropriadamente, como lançar uma exceção personalizada ou registrar em log
        }
    }
}
