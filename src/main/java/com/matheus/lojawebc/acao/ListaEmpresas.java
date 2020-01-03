package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;
import com.matheus.lojawebc.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Listando empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";

    }

}
