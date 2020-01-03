package com.matheus.lojawebc.servlet;

import com.matheus.lojawebc.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");

        HttpSession session = req.getSession();
        boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin"));

        if(acaoProtegida & usuarioNaoLogado){
            resp.sendRedirect("entrada?acao=FormLogin");
            return;
        }

        String nome;
        String nomeDaClasse = "com.matheus.lojawebc.acao." + paramAcao;

        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req, resp);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEEndereco[1]);

        }
    }
}
