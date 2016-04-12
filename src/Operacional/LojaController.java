package Operacional;

import Exceptions.DadoInvalidoException;
import Exceptions.EntradaInvalidaException;
import Exceptions.StringInvalidaException;
import Jogo.Jogo;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;


public class LojaController {

	private FactoryJogo fabricaDeJogos;
	private LojaFacade lojaFacade;
	
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
		for(Usuario usuario : lojaFacade.getUsuarios()){
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
			Usuario usuario = new Usuario(nome, id);
			lojaFacade.getUsuarios().add(usuario);
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
		if(lojaFacade.getUsuarios().contains(nome)){
			lojaFacade.getUsuarios().remove(nome);
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
			for(Usuario usuario : lojaFacade.getUsuarios()){
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
			for(Usuario usuario : lojaFacade.getUsuarios()){
				if(usuario.getId().equals(id) && usuario.getX2p() >= 1000){
					if(usuario.getTipoDeUsuario() instanceof Veterano){
						throw new Exception("Usuario ja eh veterano.");
					}else if(usuario.getTipoDeUsuario() instanceof Noob){
						usuario.setTipoDeUsuario("Veterano");
					}
					
				}
			}
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void downgrade(String id) throws StringInvalidaException{
		if(id == null || id.trim().equals("")){
			throw new StringInvalidaException("ID nao pode ser nulo ou vazio.");
		}
		try {
			for(Usuario usuario : lojaFacade.getUsuarios()){
				if(usuario.getId().equals(id) && usuario.getX2p() >= 1000){
					if(usuario.getTipoDeUsuario() instanceof Noob){
						throw new Exception("Usuario ja eh noob.");
					}else if(usuario.getTipoDeUsuario() instanceof Veterano){
						usuario.setTipoDeUsuario("Noob");
					}
			}
		}
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	/**
	 * O metodo retorna o usuario atraves do ID.
	 * @param id
	 * @return
	 */
	public Usuario getUsuarioID(String id){
		for (Usuario usuario : lojaFacade.getUsuarios()){
			if(usuario.getId().equals(id)){
				return usuario;
			} 
		}
		return null;
	}
	
	
}