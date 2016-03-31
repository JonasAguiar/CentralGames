package Jogo;

public class Plataforma extends Jogo{

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	public int registraJogada(int score, boolean zerou){
		super.setQuantidadeJogadas(getQuantidadeJogadas()+1);
		if(score > super.getBestScore() ){
			super.setBestScore(score);
		}
		if(zerou){
			super.setQuantidadeZeradas(getQuantidadeZeradas()+1);
			return 20;
		}return 0;
	}
	
	@Override
	public String toString() {
		final String QUEBRA_LINHA = System.getProperty("line.separator");

		return "+ " + getNome() + " - Plataforma" + QUEBRA_LINHA + "==> Jogou "
				+ getQuantidadeJogadas() + " vez(es)" + QUEBRA_LINHA + "==> Zerou "
				+ getQuantidadeZeradas() + " vez(es)" + QUEBRA_LINHA
				+ "==> Maior score: " + getBestScore() + QUEBRA_LINHA;
	}
	
}
