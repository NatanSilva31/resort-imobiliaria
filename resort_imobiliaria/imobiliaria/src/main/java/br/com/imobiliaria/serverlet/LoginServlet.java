package br.com.imobiliaria.serverlet;
import br.com.imobiliaria.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http .HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.validarCredenciais(email, senha)) {
            // Se as credenciais estiverem corretas, redireciona para a próxima página
            response.sendRedirect(request.getContextPath() + "./TelaUsuario/Form.html");
        } else {
            // Se as credenciais estiverem incorretas, redireciona de volta para a página de login com mensagem de erro
            response.sendRedirect("login.jsp?erro=credenciais_incorretas");
        }
    }
}
