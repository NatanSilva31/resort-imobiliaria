package br.com.imobiliaria.serverlet;

import br.com.imobiliaria.dao.ImovelDao;
import br.com.imobiliaria.model.Imovel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-imovel")
public class AddImovelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar os parâmetros do formulário
        String titulo = request.getParameter("titulo");
        String endereco = request.getParameter("endereco");
        String tipo = request.getParameter("tipo");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");
        String comentarios = request.getParameter("comentarios");

        // Criar um objeto Imovel com os dados do formulário
        Imovel imovel = new Imovel();
        imovel.setTitulo(titulo);
        imovel.setEndereco(endereco);
        imovel.setTipo(tipo);
        imovel.setPreco(preco);
        imovel.setDescricao(descricao);
        imovel.setStatus(status);
        imovel.setComentarios(comentarios);

        // Inserir o imóvel no banco de dados
        ImovelDao imovelDao = new ImovelDao();
        imovelDao.adicionarImovel(imovel);

        // Redirecionar para uma página de confirmação ou outra página de destino
        response.sendRedirect("confirmacao.jsp");
    }
}
