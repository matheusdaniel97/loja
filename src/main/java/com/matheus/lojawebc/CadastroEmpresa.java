package com.matheus.lojawebc;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cadastroEmpresa")
public class CadastroEmpresa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Cadastrando empresa");

        String nomeEmpresa = req.getParameter("nome");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Empresa: " + nomeEmpresa);
        out.println("</body>");
        out.println("</html>");

    }
}
