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
		this.dinheiro += dinheiroParaAdd;
		
	}
	
	public void compraJogo(Jogo jogo) throws Exception{
		if(jogo == null){
			throw new Exception("Jogo nao pode ser nulo.");
		}
		if(jogo.getPreco() <= dinheiro){
			jogosComprados.add(jogo);
		}
		
	}
	
	
	public void registraJogada(String nomeJogo, double score, boolean zerou ) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser null ou vazio");
		}
		this.x2p += getJogo(nomeJogo).registraJogada(score, zerou);
		
		
		
	}
	
	public Jogo getJogo(String nome){
		for(Jogo jogo : jogosComprados){
			if(jogo.getNome().equals(nome)){
				return jogo;
			}
		}return null;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
	
	

}
