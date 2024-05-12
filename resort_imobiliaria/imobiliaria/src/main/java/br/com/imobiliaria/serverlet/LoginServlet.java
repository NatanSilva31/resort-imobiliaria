package br.com.imobiliaria.serverlet;
import br.com.imobiliaria.dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder; // Importe a classe URLDecoder

import org.json.JSONObject; // Importe a classe correta

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha as credenciais do corpo da solicitação JSON
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String json = buffer.toString();
    
        // Decodifique os parâmetros URL-encoded
        String[] params = json.split("&");
        String email = null;
        String senha = null;
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                if ("email".equals(pair[0])) {
                    email = URLDecoder.decode(pair[1], "UTF-8");
                } else if ("senha".equals(pair[0])) {
                    senha = URLDecoder.decode(pair[1], "UTF-8");
                }
            }
        }
    
        // Imprima o email e a senha
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
    
        // Crie um objeto JSON com os parâmetros email e senha
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
    
        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.validarCredenciais(email, senha)) {
            // Se as credenciais estiverem corretas, redirecione para a próxima página
            response.sendRedirect(request.getContextPath() + "/CadastroImovel/Form.html");
        } else {
            // Se as credenciais estiverem incorretas, retorne um status 401 (Unauthorized)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Credenciais incorretas');");
            out.println("window.history.back();");
            out.println("</script>");
        }
        
    }
}    
