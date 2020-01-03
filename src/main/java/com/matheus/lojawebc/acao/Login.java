package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;
import com.matheus.lojawebc.modelo.Empresa;
import com.matheus.lojawebc.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Login implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Banco banco = new Banco();
        Usuario usuario = banco.existeusuario(login,senha);

        if(usuario!=null){
            System.out.println("Logando: " + login);
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresas";
        } else{
            System.out.println("Os dados de usuário estão inválidos");
            return "redirect:entrada?acao=FormLogin";
        }




    }
}
