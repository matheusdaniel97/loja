package com.matheus.lojawebc;
import javax.servlet.RequestDispatcher;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("Cadastrando empresa");

        String nomeEmpresa = req.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        //Chamando o JSP
        RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
        req.setAttribute("empresa", empresa.getNome());
        rd.forward(req, resp);
    }
}
