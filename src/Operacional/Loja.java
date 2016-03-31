package Operacional;

import java.util.HashSet;
import java.util.Set;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaInvalidaException;
import Exceptions.StringInvalidaException;
import Jogo.Jogo;
import Usuario.Usuario;
import Usuario.Veterano;

public class Loja {

	private Set<Usuario> usuarios;
	private FactoryJogo fabricaDeJogos;
	private FactoryUsuario fabricaDeUsuarios;
	
	/**
	 * Metodo construtor de loja
	 */
	public Loja(){
		this.usuarios = new HashSet<Usuario>();
	}
	/**
	 * O metodo adiciona dinheiro ao usuario.
	 * @param id
	 * @param dinheiroParaAdd
	 * @throws Exception
	 */
	public void adicionaDinheiro(String id, double dinheiroParaAdd) throws Exception{
		if(id == null || id.trim().equals("")){
			throw new StringInvalidaException("ID nao pode ser nulo ou vazio.");
		}
		if(dinheiroParaAdd < 0){
			throw new DadoInvalidoException("O dinheiro a ser adicionado nao pode ser negativo.");
		}
		for(Usuario usuario : usuarios){
			if(usuario.getId().equals(id)){
				usuario.adicionaDinheiro(dinheiroParaAdd);
			}
		}
	}
	
	/**
	 * O metodo cria e adiciona usuario a lista de usuarios da loja.
	 * @param nome
	 * @param id
	 * @param tipoUsuario
	 * @throws Exception
	 */
	public void adicionaUsuario(String nome, String id, String tipoUsuario ) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new StringInvalidaException("Nome nao pode ser vazio ou nulo.");
		}
		if(id == null || id.trim().equals("")){
			throw new DadoInvalidoException("Nome nao pode ser vazio ou nulo.");
		}
		try {
			Usuario usuario = fabricaDeUsuarios.criaUsuario(tipoUsuario, nome, id);
			usuarios.add(usuario);
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	/**
	 * O metodo remove um usuario da lista de usuarios.
	 * @param nome
	 * @throws Exception
	 */
	public void removeUsuario(String nome) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new StringInvalidaException("nome nao pode ser nulo ou vazio");
		}
		if(usuarios.contains(nome)){
			usuarios.remove(nome);
		}
	}
	
	/**
	 * O metodo cria um jogo.
	 * @param tipoJogo
	 * @param nome
	 * @param preco
	 * @return
	 * @throws Exception
	 */
	public Jogo criaJogo(String tipoJogo, String nome, double preco) throws Exception{
		Jogo jogo = fabricaDeJogos.getJogo(tipoJogo, nome, preco);
		return jogo;
	}
		
		
	
	/**
	 * O metodo vende um jogo ao usuario.
	 * @param id
	 * @param nomeJogo
	 * @param tipoJogo
	 * @param preco
	 * @throws Exception
	 */
	public void vendeJogos(String id, String nomeJogo, String tipoJogo, double preco) throws Exception{
		try {
			Jogo jogo = fabricaDeJogos.getJogo(tipoJogo, nomeJogo, preco);
			for(Usuario usuario : usuarios){
				if(usuario.getId().equals(id)){
					usuario.compraJogo(jogo);
						}
					}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
	/**
	 * O metodo faz o upgrade do usuario, upcast de noob para veterano.
	 * @param id
	 * @throws Exception
	 */
	public void upgrade(String id) throws Exception{
		if(id == null || id.trim().equals("")){
			throw new StringInvalidaException("ID nao pode ser nulo ou vazio.");
		}
		try {
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
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * O metodo retorna o usuario atraves do ID.
	 * @param id
	 * @return
	 */
	public Usuario getUsuarioID(String id){
		for (Usuario usuario : usuarios){
			if(usuario.getId().equals(id)){
				return usuario;
			} 
		}
		return null;
	}
	/**
	 * O metodo retorna os usuarios
	 * @return usuarios
	 */
	public Set<Usuario> getUsuarios(){
		return usuarios;
	}
	
}
