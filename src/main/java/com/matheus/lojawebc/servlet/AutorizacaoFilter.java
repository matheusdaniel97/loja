package com.matheus.lojawebc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("entrada")

public class AutorizacaoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filtro de autorizacao");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String paramAcao = req.getParameter("acao");

        HttpSession session = req.getSession();
        boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin") || paramAcao.equals("FormCadastrarUsuario") || paramAcao.equals("CadastrarUsuario"));

        if(acaoProtegida & usuarioNaoLogado){
            resp.sendRedirect("entrada?acao=FormLogin");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
