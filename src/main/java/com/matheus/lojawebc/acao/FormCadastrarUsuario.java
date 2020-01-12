package com.matheus.lojawebc.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormCadastrarUsuario implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Abrindo formulario de cadastro");

        return "forward:formNovoUsuario.jsp";

    }

}
