package com.matheus.lojawebc.servlet;

import com.matheus.lojawebc.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

/*        if(paramAcao.equals("ListaEmpresas")){

            ListaEmpresas acao = new ListaEmpresas();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("RemoveEmpresa")){

            RemoveEmpresa acao = new RemoveEmpresa();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("MostraEmpresa")){

            MostraEmpresa acao = new MostraEmpresa();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("AlteraEmpresa")){

            AlteraEmpresa acao = new AlteraEmpresa();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("CadastroEmpresa")){

            CadastroEmpresa acao = new CadastroEmpresa();
            nome = acao.executa(req, resp);

        } else if (paramAcao.equals("FormCadastrarEmpresa")){

            FormCadastrarEmpresa acao = new FormCadastrarEmpresa();
            nome = acao.executa(req, resp);

        }

 */
        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEEndereco[1]);

        }
    }
}
