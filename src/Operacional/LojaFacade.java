package Operacional;

import java.util.HashSet;
import java.util.Set;

import Jogo.Jogo;
import Usuario.Usuario;

public class LojaFacade {
	
	private Set<Usuario> usuarios;
	private LojaController controller;
	
	public LojaFacade(){
		this.usuarios = new HashSet<Usuario>();
	}

	public Jogo criaJogo(String tipoJogo, String nome, double preco){
		try {
			return controller.criaJogo(tipoJogo, nome, preco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void adicionaUsuario(String nome, String id, String tipoUsuario){
		try {
			controller.adicionaUsuario(nome, id, tipoUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeUsuario(String nome){
		try {
			controller.removeUsuario(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vendeJogos(String id, String nomeJogo, String tipoJogo, double preco){
		try {
			controller.vendeJogos(id, nomeJogo, tipoJogo, preco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuarioID(String id){
		return controller.getUsuarioID(id);
	}
	
	public void adicionaDinheiro(String id, double dinheiroParaAdd){
		try {
			controller.adicionaDinheiro(id, dinheiroParaAdd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	
}