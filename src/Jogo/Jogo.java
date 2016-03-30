package Jogo;


import java.util.HashSet;
import java.util.Set;


public abstract class Jogo {

	private String nome;
	private double preco;
	private double bestScore;
	private int quantidadeJogadas;
	private int quantidadeZeradas;
	private Set<Jogabilidade> jogabilidades;
	
	/**
	 * 
	 * @param nome
	 * @param preco
	 * @throws Exception 
	 */
	public Jogo(String nome, double preco) throws Exception{
		if(nome == null || nome.trim().equals("") ){
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if(preco < 0){
			throw new Exception("Preco nao pode ser negativo.");
		}
		
		this.nome = nome;
		this.preco = preco;
		this.bestScore = 0.0;
		this.quantidadeJogadas = 0;
		this.quantidadeZeradas = 0;
		this.jogabilidades = new HashSet<Jogabilidade>();
	}
	/**
	 * Esse metodo realiza a operacao de registrar jogadas.
	 * @param pontuacao
	 * @param zerou
	 * @throws Exception quando a pontuacao for invalida ou negativa. 
	 */
	public abstract int registraJogada(double score, boolean zerou) throws Exception;
		
		
	
	public void adicionaJogabilidade(Jogabilidade jogabilidade) throws Exception{
		if(jogabilidade == null){
			throw new Exception("Jogabilidade nao pode ser nula");
		}
		jogabilidades.add(jogabilidade);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getBestScore() {
		return bestScore;
	}

	public void setBestScore(double bestScore) {
		this.bestScore = bestScore;
	}

	public int getQuantidadeJogadas() {
		return quantidadeJogadas;
	}

	public void setQuantidadeJogadas(int quantidadeJogadas) {
		this.quantidadeJogadas = quantidadeJogadas;
	}

	public int getQuantidadeZeradas() {
		return quantidadeZeradas;
	}

	public void setQuantidadeZeradas(int quantidadeZeradas) {
		this.quantidadeZeradas = quantidadeZeradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	

	@Override
	public abstract String toString();
	
	
	
}