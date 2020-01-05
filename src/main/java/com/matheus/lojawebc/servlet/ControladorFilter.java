package com.matheus.lojawebc.servlet;

import com.matheus.lojawebc.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ControladorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filtro de controlador");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String paramAcao = req.getParameter("acao");

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



    @Override
    public void destroy() {

    }
}
