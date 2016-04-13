package Usuario;

import java.util.HashSet;
import java.util.Set;

import Exceptions.ConversaoInvalidaException;
import Jogo.Jogo;

public class Usuario {
	
	private String nome;
	private String id;
	private Set<Jogo> jogosComprados;
	private double dinheiro;
	private int x2p;
	private ITipoUsuario tipoDeUsuario;
	
	/**
	 * O metodo � o construtor da classe Usuario.
	 * @param nome
	 * @param id
	 * @throws Exception
	 */
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
		this.tipoDeUsuario = new Noob();
	}
	
	/**
	 * O metodo resgata o total gasto pelo usuario.
	 * @return totalgasto
	 */
	public double getTotalGasto(){
		double totalGasto = 0.0;
		for (Jogo jogo : jogosComprados){
			totalGasto += jogo.getPreco();
		}
		return totalGasto;
	}
	

	public void recompensar(String nomeJogo, int score, boolean zerou) throws Exception {
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p = this.x2p + this.tipoDeUsuario.recompensar(jogo, score, zerou);
			}
		}
		transformaUsuario(getX2p());
	}
	
	public void punir(String nomeJogo, int score, boolean zerou) throws Exception {
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p = this.x2p + this.tipoDeUsuario.punir(jogo, score, zerou);
			}
		}
		transformaUsuario(getX2p());
	}
	
	
	
	/**
	 * O metodo adiciona dinheiro no usuario.
	 * @param dinheiroParaAdd
	 * @throws Exception
	 */
	public void adicionaDinheiro(double dinheiroParaAdd) throws Exception{
		if(dinheiroParaAdd < 0){
			throw new Exception("O dinheiro a ser adicionado nao pode ser negativo.");
		}
		this.dinheiro += dinheiroParaAdd;
		
	}
	
	public void transformaUsuario(int x2p) throws Exception{
		if (x2p >= 1000 && tipoDeUsuario instanceof Noob) {
			tornaVeterano();
		} else if(x2p >= 1000 && tipoDeUsuario instanceof Veterano){
			throw new ConversaoInvalidaException("usuario ja eh veterano");
		} else if(x2p < 1000 && tipoDeUsuario instanceof Veterano){
			tornaNoob();
		}
	}
	
	/**
	 * O metodo adiciona um jogo comprado a lista de jogos do usuario.
	 * @param jogo
	 */
	public void adicionaJogoComprado(Jogo jogo){
		jogosComprados.add(jogo);
	}
	
	/**
	 * O metodo compra jogo da loja.
	 * @param jogo
	 * @throws Exception
	 */
	public void compraJogo(Jogo jogo) throws Exception{
		if(jogo == null){
			throw new Exception("Jogo nao pode ser nulo.");
		}
		if(jogo.getPreco() <= dinheiro){
			this.x2p += tipoDeUsuario.compraJogo(jogo);
			this.dinheiro -= jogo.getPreco();
		}else{
			throw new Exception("Usuario nao possui dinheiro suficiente.");
		}
		
	}
	
	/**
	 * O metodo registra jogada do usuario em algum jogo.
	 * @param nomeJogo
	 * @param score
	 * @param zerou
	 * @throws Exception
	 */
	public void registraJogada(String nomeJogo, int score, boolean zerou ) throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser null ou vazio");
		}
		this.x2p += getJogo(nomeJogo).registraJogada(score, zerou);
		
		
		
		
		
		
	}
	/**
	 * O metodo retorna os jogos do usuario
	 * @param nome
	 * @return
	 */
	public Jogo getJogo(String nome){
		for(Jogo jogo : jogosComprados){
			if(jogo.getNome().equals(nome)){
				return jogo;
			}
		}return null;
	}

	public void tornaVeterano(){
		this.tipoDeUsuario = new Veterano();
	}
	
	public void tornaNoob(){
		this.tipoDeUsuario = new Noob();
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

	public ITipoUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(String tipoDeUsuario) {
		if(tipoDeUsuario.equals("Veterano")){
			this.tipoDeUsuario = new Veterano();
		}
		if(tipoDeUsuario.equals("Noob")){
			this.tipoDeUsuario = new Noob();
		}
		
	}
	
	
	@Override
	public String toString() {
		final String QUEBRA_LINHA = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo jogo : jogosComprados) {
			mensagemJogos = mensagemJogos + jogo.toString() + QUEBRA_LINHA;
		}

		return getId() + QUEBRA_LINHA + getNome() + QUEBRA_LINHA + "Jogador " + tipoDeUsuario.toString() + getX2p()
				+ " x2p" + QUEBRA_LINHA + "Lista de Jogos:" + QUEBRA_LINHA + mensagemJogos
				+ "Total de preco dos jogos: R$ " + getTotalGasto() + QUEBRA_LINHA;
	}
	
	

}