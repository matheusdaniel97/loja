package com.matheus.lojawebc.acao;

import com.matheus.lojawebc.modelo.Banco;
import com.matheus.lojawebc.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarUsuario implements Acao{

        public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            System.out.println("Cadastrando usuario");

            String login = req.getParameter("login");
            String senha = req.getParameter("senha");

            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);

            Banco banco = new Banco();
            banco.adicionaUsuario(usuario);

            req.setAttribute("usuario", usuario.getLogin());

            return "redirect:entrada?acao=FormLogin";
        }
}

