package laboratorio6;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private String nome;
	private String id;
	private Set<Jogo> jogosComprados;
	private double dinheiro;
	private int x2p;
	
	public Usuario(String nome, String id) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		if(id == null || id.trim().equals("")){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		this.nome = nome;
		this.id = id;
		this.jogosComprados = new HashSet<Jogo>();
		this.dinheiro = 0.0;
		this.x2p = 0;
	}
	
	
	public void adicionaDinheiro(double dinheiroParaAdd) throws Exception{
		if(dinheiroParaAdd < 0){
			throw new Exception("O dinheiro a ser adicionado nao pode ser negativo.");
		}
		dinheiro += dinheiroParaAdd;
		
	}
	
	public void compraJogo(Jogo jogo) throws Exception{
		if(jogo == null){
			throw new Exception("Jogo nao pode ser nulo.");
		}
		if(jogo.getPreco() <= dinheiro){
			jogosComprados.add(jogo);
		}
		
	}
	
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public void setJogosComprados(Set<Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	
	
	
	
	

}
