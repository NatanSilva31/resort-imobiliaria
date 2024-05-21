package br.com.ResortImobiliaria.servlet;

import br.com.ResortImobiliaria.dao.UserDao;
import br.com.ResortImobiliaria.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String jsonData = stringBuilder.toString();

        User user = objectMapper.readValue(jsonData, User.class);

        UserDao userDao = new UserDao();

        if (userDao.emailExists(user.getEmail())) {
            // Enviar resposta de erro para o frontend
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "E-mail já está em uso.");
            System.out.printf("O E-mail %s já esta em uso \n", user.getEmail());
            return;
        }
        if (userDao.docExists(user.getDocPfPj())) {
            // Enviar resposta de erro para o frontend
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "CPF/CNPJ já está em uso.");
            System.out.printf("O doc %s já esta em uso \n", user.getDocPfPj());
            return;
        }
        userDao.createUser(user);
        response.sendRedirect("/pages/login.html");
    }
}