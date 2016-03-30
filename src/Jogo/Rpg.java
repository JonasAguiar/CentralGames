package Jogo;

public class Rpg extends Jogo {

	public Rpg(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	
	public int registraJogada(){
		return 10;
	}


	@Override
	public int registraJogada(double score, boolean zerou) throws Exception {
		super.setQuantidadeJogadas(getQuantidadeJogadas() + 1);
		return 10;
	}
	
	@Override
	public String toString() {
		final String QUEBRA_LINHA = System.getProperty("line.separator");

		return "+ " + getNome() + " - RPG" + QUEBRA_LINHA + "==> Jogou "
				+ getQuantidadeJogadas() + " vez(es)" + QUEBRA_LINHA + "==> Zerou "
				+ getQuantidadeZeradas() + " vez(es)" + QUEBRA_LINHA
				+ "==> Maior score: " + getBestScore() + QUEBRA_LINHA;
	}
}

