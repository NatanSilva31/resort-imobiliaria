package br.com.imobiliaria.serverlet;

import br.com.imobiliaria.dao.UsuarioDao;
import br.com.imobiliaria.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/add-usuario")
public class AddUsuarioServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        verificarECriarTabela();
    }

    private void verificarECriarTabela() throws ServletException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "nome VARCHAR(255), " +
                "email VARCHAR(255), " +
                "senha VARCHAR(255)" +
                ");";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             Statement statement = connection.createStatement()) {
            statement.execute(sqlCreate);
            System.out.println("Tabela 'usuarios' verificada/criada com sucesso!");
        } catch (Exception e) {
            throw new ServletException("Erro ao criar a tabela 'usuarios': " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.adicionarUsuario(usuario);

        response.sendRedirect("confirmacao.jsp");
    }
}
