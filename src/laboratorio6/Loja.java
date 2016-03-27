package laboratorio6;

import java.util.HashSet;
import java.util.Set;

public class Loja {

	private Set<Usuario> usuarios;
	private Set<Jogo> jogos;
	private FactoryJogo fabricaDeJogos;
	
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
				usuario.setDinheiro(usuario.getDinheiro() + dinheiroParaAdd);
			}
		}
	}
	
	public void adicionaUsuario(Usuario usuario) throws Exception{
		if(usuario == null){
			throw new Exception("Usuario nao pode ser nulo.");
		}
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
	
	
		
	
	
	public void vendeJogos(String id, String nomeJogo) throws Exception{
		for(Usuario usuario : usuarios){
			if(usuario.getId().equals(id)){
				for(Jogo jogo : jogos){
					if(jogo.getNome().equals(nomeJogo) && jogo.getPreco() <= usuario.getDinheiro()){
						String tipoJogo = jogo.getClass().getName();
						Jogo novoJogo = fabricaDeJogos.getJogo(tipoJogo, jogo.getNome(), jogo.getPreco());
						usuario.adicionaJogoComprado(novoJogo);
					}
				}
			}
		}
	}
	
	
}
