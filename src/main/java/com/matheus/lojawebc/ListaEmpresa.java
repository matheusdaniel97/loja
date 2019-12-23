package com.matheus.lojawebc;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listaEmpresas")
public class ListaEmpresa extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);
        for (Empresa empresa : lista) {
            System.out.println(empresa.getNome());
        }

        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(req, resp);
    }
}
