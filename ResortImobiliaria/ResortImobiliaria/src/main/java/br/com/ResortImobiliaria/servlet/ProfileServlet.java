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
        int userId = getUserIdFromCookie(request);
        UserDao userDao = new UserDao();
        User user = new User();
        user.setIdUser(userId);
        userDao.readUser(user);


        String json = "{\"id\": " + user.getIdUser() +
                ", \"name\": \"" + user.getName() +
                "\", \"email\": \"" + user.getEmail() +
                "\", \"cpf_cnpj\": \"" + user.getDocPfPj() + "\"}";

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

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
        return -1; 
    }
}