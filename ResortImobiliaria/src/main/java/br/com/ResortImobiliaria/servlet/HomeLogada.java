package br.com.ResortImobiliaria.servlet;


import br.com.ResortImobiliaria.dao.CadastroImovelDao;
import br.com.ResortImobiliaria.model.CadastroImovel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HomeLogada")
public class HomeLogada extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CadastroImovel> imoveis = new CadastroImovelDao().ListadeImoveis();
        req.setAttribute("imoveis", imoveis);

        req.getRequestDispatcher("homeLogada.jsp").forward(req, resp);


    }




}