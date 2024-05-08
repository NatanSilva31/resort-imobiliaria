package br.com.imobiliaria.serverlet;

import br.com.imobiliaria.dao.ContatoDao;
import br.com.imobiliaria.model.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        verificarECriarTabela();
    }

    private void verificarECriarTabela() throws ServletException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS contatos (" +
                "nome VARCHAR(255), " +
                "email VARCHAR(255), " +
                "mensagem TEXT" +
                ");";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             Statement statement = connection.createStatement()) {
            statement.execute(sqlCreate);
            System.out.println("Tabela 'contatos' verificada/criada com sucesso!");
        } catch (Exception e) {
            throw new ServletException("Erro ao criar a tabela 'contatos': " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setMensagem(mensagem);

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.adicionarContato(contato);

        response.sendRedirect("confirmacao.jsp");
    }
}
