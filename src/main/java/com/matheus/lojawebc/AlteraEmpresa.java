package com.matheus.lojawebc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet ("alteraEmpresa")
public class AlteraEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Alterando empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        System.out.println(id);

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        resp.sendRedirect("listaEmpresas");

    }
}
