package Operacional;

import java.util.HashSet;
import java.util.Set;

import Jogo.Jogo;
import Usuario.Usuario;
import Usuario.Veterano;

public class Loja {

	private Set<Usuario> usuarios;
	private FactoryJogo fabricaDeJogos;
	private FactoryUsuario fabricaDeUsuarios;
	
	public Loja(){
		this.usuarios = new HashSet<Usuario>();
	}
	
	public void adicionaDinheiro(String id, double dinheiroParaAdd) throws Exception{
		if(id == null || id.trim().equals("")){
			throw new Exception("ID nao pode ser nulo ou vazio.");
		}
		if(dinheiroParaAdd < 0){
			throw new Exception("O dinheiro a ser adicionado nao pode ser negativo.");
		}
		for(Usuario usuario : usuarios){
			if(usuario.getId().equals(id)){
				usuario.adicionaDinheiro(dinheiroParaAdd);
			}
		}
	}
	
	public void adicionaUsuario(String nome, String id, String tipoUsuario ) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser vazio ou nulo.");
		}
		if(id == null || id.trim().equals("")){
			throw new Exception("Nome nao pode ser vazio ou nulo.");
		}
		Usuario usuario = fabricaDeUsuarios.criaUsuario(tipoUsuario, nome, id);
		usuarios.add(usuario);
		
	}
	
	
	
	
	public void removeUsuario(String nome) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("nome nao pode ser nulo ou vazio");
		}
		if(usuarios.contains(nome)){
			usuarios.remove(nome);
		}
	}
	
	public Jogo criaJogo(String tipoJogo, String nome, double preco) throws Exception{
		Jogo jogo = fabricaDeJogos.getJogo(tipoJogo, nome, preco);
		return jogo;
	}
		
		
	
	//falta exception
	public void vendeJogos(String id, String nomeJogo, String tipoJogo, double preco) throws Exception{
		Jogo jogo = fabricaDeJogos.getJogo(tipoJogo, nomeJogo, preco);
		for(Usuario usuario : usuarios){
			if(usuario.getId().equals(id)){
				usuario.compraJogo(jogo);
					}
				}

		
	}
	
	
	public void upgrade(String id) throws Exception{
		if(id == null || id.trim().equals("")){
			throw new Exception("ID nao pode ser nulo ou vazio.");
		}
		for(Usuario usuario : usuarios){
			if(usuario.getId().equals(id) && usuario.getX2p() >= 1000){
				String tipoUsuario = usuario.getClass().getName();
				if(tipoUsuario.equals("Veterano")){
					throw new Exception("Usuario ja eh veterano.");
				}else if(tipoUsuario.equals("Noob")){
					Usuario novoUsuario = new Veterano(usuario.getNome(), usuario.getId());
					novoUsuario.setJogosComprados(usuario.getJogosComprados());
					novoUsuario.setDinheiro(usuario.getDinheiro());
					novoUsuario.setX2p(usuario.getX2p());
					usuarios.remove(usuario);
					usuarios.add(novoUsuario);	
				}
				
			}
		}
	}
	
}
