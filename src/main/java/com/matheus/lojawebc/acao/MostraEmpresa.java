package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;
import com.matheus.lojawebc.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Mostrando dados da empresa");

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaId(id);

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);
        return "forward:formAlteraEmpresa.jsp";
    }
}
