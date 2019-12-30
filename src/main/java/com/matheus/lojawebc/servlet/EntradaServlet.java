package com.matheus.lojawebc.servlet;

import com.matheus.lojawebc.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");

        if(paramAcao.equals("ListaEmpresas")){

            ListaEmpresas acao = new ListaEmpresas();
            acao.executa(req, resp);

        } else if (paramAcao.equals("RemoveEmpresa")){

            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(req, resp);

        } else if (paramAcao.equals("MostraEmpresa")){

            MostraEmpresa acao = new MostraEmpresa();
            acao.executa(req, resp);

        } else if (paramAcao.equals("AlteraEmpresa")){

            AlteraEmpresa acao = new AlteraEmpresa();
            acao.executa(req, resp);

        } else if (paramAcao.equals("CadastroEmpresa")){

            CadastroEmpresa acao = new CadastroEmpresa();
            acao.executa(req, resp);

        }
    }
}
