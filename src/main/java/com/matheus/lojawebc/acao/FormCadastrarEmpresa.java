package com.matheus.lojawebc.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormCadastrarEmpresa implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Abrindo formulario de criacao de empresa");

        return "forward:formNovaEmpresa.jsp";

    }

}
