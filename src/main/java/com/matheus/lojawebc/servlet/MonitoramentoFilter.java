package com.matheus.lojawebc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filtro de monitoramento");

        long antes = System.currentTimeMillis();

        String acao = servletRequest.getParameter("acao");

        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execucao da acao " + acao + ": " + (depois - antes));

    }

    @Override
    public void destroy() {

    }
}
