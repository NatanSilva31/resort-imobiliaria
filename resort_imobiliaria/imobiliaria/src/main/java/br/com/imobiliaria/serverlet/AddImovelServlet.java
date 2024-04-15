package br.com.imobiliaria.serverlet;

import br.com.imobiliaria.dao.ImovelDao;
import br.com.imobiliaria.model.Imovel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/add-imovel")
public class AddImovelServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        verificarECriarTabela();
    }

    private void verificarECriarTabela() throws ServletException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS imoveis (" +
                "titulo VARCHAR(255), " +
                "endereco VARCHAR(255), " +
                "tipo VARCHAR(50), " +
                "preco DOUBLE, " +
                "descricao TEXT, " +
                "status VARCHAR(50), " +
                "comentarios TEXT" +
                ");";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             Statement statement = connection.createStatement()) {
            statement.execute(sqlCreate);
            System.out.println("Tabela 'imoveis' verificada/criada com sucesso!");
        } catch (Exception e) {
            throw new ServletException("Erro ao criar a tabela 'imoveis': " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String endereco = request.getParameter("endereco");
        String tipo = request.getParameter("tipo");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");
        String comentarios = request.getParameter("comentarios");

        Imovel imovel = new Imovel();
        imovel.setTitulo(titulo);
        imovel.setEndereco(endereco);
        imovel.setTipo(tipo);
        imovel.setPreco(preco);
        imovel.setDescricao(descricao);
        imovel.setStatus(status);
        imovel.setComentarios(comentarios);

        ImovelDao imovelDao = new ImovelDao();
        imovelDao.adicionarImovel(imovel);

        response.sendRedirect("confirmacao.jsp");
    }
}
