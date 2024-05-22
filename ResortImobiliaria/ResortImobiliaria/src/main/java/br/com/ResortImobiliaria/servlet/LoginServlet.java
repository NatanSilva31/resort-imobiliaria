package br.com.ResortImobiliaria.servlet;

import br.com.ResortImobiliaria.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        // Verificar as credenciais do usuário no banco de dados
        int userId = userDao.getUserId(email, password);

        if (userId != -1) {
            // Criar uma sessão e armazenar informações do usuário, incluindo o ID
            Cookie loginCookie = new Cookie("userCookie", String.valueOf(userId));
            loginCookie.setMaxAge(30*60); //setting cookie to expiry in 30 mins
            response.addCookie(loginCookie);

            // Redirecionar para a página do perfil do usuário
            response.sendRedirect("/pages/profile.html");
        } else {
            // Enviar resposta de erro para o frontend
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail ou senha inválidos.");
        }
    }
}