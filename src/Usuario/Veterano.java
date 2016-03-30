package Usuario;

import java.util.Set;

import Jogo.Jogo;

public class Veterano extends Usuario {

	private static final int MULTIPLICAX2P = 15;
	private static final double PORCENTAGEM_DESCONTO = 20;
	
	public Veterano(String nome, String id) throws Exception {
		super(nome, id);

	}
	
	public Veterano(String nome, String id, Set<Jogo> jogosComprados, double dinheiro, int x2p) throws Exception {
		super(nome, id, jogosComprados, dinheiro, x2p);

	}
	
	@Override
	public void compraJogo(Jogo jogo) throws Exception{
		super.compraJogo(jogo);
		double desconto = (jogo.getPreco() * PORCENTAGEM_DESCONTO)/100;
		super.setDinheiro(jogo.getPreco()- desconto);
		super.setX2p(super.getX2p() + (int)(MULTIPLICAX2P * jogo.getPreco()));
		
	}
	
	
	public String toString(){

		final String QUEBRA_LINHA = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo jogo : getJogosComprados()) {
			mensagemJogos = mensagemJogos + jogo.toString() + QUEBRA_LINHA;
		}

		return getId() + QUEBRA_LINHA + getNome() + QUEBRA_LINHA + "Jogador Veterano: " + getX2p()
				+ " x2p" + QUEBRA_LINHA + "Lista de Jogos:" + QUEBRA_LINHA + mensagemJogos
				+ "Total de preco dos jogos: R$ " + getTotalGasto() + QUEBRA_LINHA;
	}
}

