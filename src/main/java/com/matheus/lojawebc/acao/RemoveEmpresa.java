package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Removendo empresa");

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);
        System.out.println("removendo empresa de Id = " + id);

        return "redirect:entrada?acao=ListaEmpresas";

    }

}
