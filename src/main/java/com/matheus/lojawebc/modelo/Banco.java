package com.matheus.lojawebc.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> lista = new ArrayList<>();
    private static List<Usuario> listaUsuario = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static{
        //Criando duas empresas estaticas
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Matheus LTDA");
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Matheus SA");
        lista.add(empresa);
        lista.add(empresa2);

        //Criando dois usuários estáticos
        Usuario usuario = new Usuario();
        usuario.setLogin("Matheus");
        usuario.setSenha("Matheus123");
        Usuario usuario2 = new Usuario();
        usuario2.setLogin("Daniel");
        usuario2.setSenha("Daniel123");
        listaUsuario.add(usuario);
        listaUsuario.add(usuario2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(chaveSequencial++);
        lista.add(empresa);
    }

    public List<Empresa> getEmpresas(){
        return Banco.lista;
    }

    public void removeEmpresa(Integer id) {
        Iterator<Empresa> it = lista.iterator();

        while(it.hasNext()) {
            Empresa emp = it.next();
            if(emp.getId() == id){
                it.remove();
            }
        }
    }

    public Empresa buscaEmpresaId(Integer id) {
        for (Empresa empresa:lista
             ) {
            if(empresa.getId()==id){
                return empresa;
            }
        }
        return null;
    }

    public Usuario existeusuario(String login, String senha) {
        for (Usuario usuario:listaUsuario
             ) {
            if(usuario.validaLogin(login, senha)){
                return usuario;
            }
        }
        return null;
    }
}
