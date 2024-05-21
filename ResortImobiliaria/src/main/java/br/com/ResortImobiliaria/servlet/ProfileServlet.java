package br.com.ResortImobiliaria.servlet;

import br.com.ResortImobiliaria.dao.UserDao;
import br.com.ResortImobiliaria.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera o ID do usuário do cookie
        int userId = getUserIdFromCookie(request);

        UserDao userDao = new UserDao();
        User user = new User();
        user.setIdUser(userId);

        // Usando a função readUser da UserDao para obter os dados do usuário
        userDao.readUser(user);

        // Imprimindo os dados do usuário para debug
        //System.out.println("Dados do usuário recuperados:");
        //System.out.println("ID: " + user.getIdUser());
        //System.out.println("Nome: " + user.getName());
        //System.out.println("Email: " + user.getEmail());
        //System.out.println("CPF/CNPJ: " + user.getDocPfPj());

        // Criando o JSON com os dados do usuário
        String json = "{\"id\": " + user.getIdUser() +
                ", \"name\": \"" + user.getName() +
                "\", \"email\": \"" + user.getEmail() +
                "\", \"cpf_cnpj\": \"" + user.getDocPfPj() + "\"}";

        // Configurando a resposta para JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Escrevendo o JSON na resposta
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    private int getUserIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCookie")) {
                    return Integer.parseInt(cookie.getValue());
                }
            }
        }
        return -1; // Se o cookie não for encontrado, retorna -1 ou outro valor adequado
    }
}