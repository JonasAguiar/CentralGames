package Jogo;


import java.util.HashSet;
import java.util.Set;

import Exceptions.StringInvalidaException;


public abstract class Jogo {

	private String nome;
	private double preco;
	private int bestScore;
	private int quantidadeJogadas;
	private int quantidadeZeradas;
	private Set<Jogabilidade> jogabilidades;
	
	/**
	 * Esse metodo cria o objeto de referencia jogo.
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
		this.bestScore = 0;
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
	public abstract int registraJogada(int score, boolean zerou) throws Exception;
		
		
	
	public void adicionaJogabilidade(Jogabilidade jogabilidade) throws Exception{
		if(jogabilidade == null){
			throw new StringInvalidaException("Jogabilidade nao pode ser nula");
		}
		jogabilidades.add(jogabilidade);
	}
	/**
	 * Esse metodo retorna as jogabilidades dos jogos do usuario.
	 * @return jogabilidade
	 */
	public Jogabilidade getJogabilidade(){
		for(Jogabilidade jogabilidade: jogabilidades){
			return jogabilidade;
		}return null;
	}
	
	/**
	 * gets e sets
	 */
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

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
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