package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;
import com.matheus.lojawebc.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroEmpresa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Cadastrando empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

        Date dataAbertura = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        req.setAttribute("empresa", empresa.getNome());

        return "redirect:entrada?acao=ListaEmpresas";


    }
}
