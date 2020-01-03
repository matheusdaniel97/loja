package com.matheus.lojawebc.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Saindo da aplicação");

        HttpSession session = req.getSession();

        session.invalidate();

        return "redirect:entrada?acao=FormLogin";
    }
}
