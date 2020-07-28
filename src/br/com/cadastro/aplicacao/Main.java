package br.com.cadastro.aplicacao;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Usuario;
//import br.com.cadastro.model;

public class Main {

	public static void main(String[] args) {
	
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setId(59);
		usuario.setName("hulk");
		usuario.setEmail("hulk@gmail.com");
		usuario.setPassword("12394567");
		usuario.setPhone(81-99886766);
		
		usuarioDao.save(usuario);
		
		// visualização dos registros do banco TODOS

		for(Usuario u : usuarioDao.getUsuario()){
			System.out.println("Usuario: " + u.getName());
		}

	}

}
