package br.com.ResortImobiliaria.servlet;

import br.com.ResortImobiliaria.dao.CadastroImovelDao;
import br.com.ResortImobiliaria.model.CadastroImovel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-cadastroImovel")
public class DeleteCadastroImvovel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CadastroImovelId = req.getParameter("id");

        new CadastroImovelDao().deleteCadastroImovelById(CadastroImovelId);

        resp.sendRedirect("/painel-imovel");
    }
}
