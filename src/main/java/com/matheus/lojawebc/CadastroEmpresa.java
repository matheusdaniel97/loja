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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/cadastroEmpresa")
public class CadastroEmpresa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("Cadastrando empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

        Date dataAbertura = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

//        //Chamando o JSP
//        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
        req.setAttribute("empresa", empresa.getNome());
//        rd.forward(req, resp);

        resp.sendRedirect("listaEmpresas");
    }
}
