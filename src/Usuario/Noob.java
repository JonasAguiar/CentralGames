package Usuario;

import Jogo.Jogabilidade;
import Jogo.Jogo;

public class Noob implements ITipoUsuario{

	private static final int MULTIPLICAX2P = 10;
	private static final double PORCENTAGEM_DESCONTO = 15;
	
	public static double getPorcentagemDesconto() {
		return PORCENTAGEM_DESCONTO;
	}

	@Override
	public int compraJogo(Jogo jogo) {
		compraJogo(jogo);
		return (int)(MULTIPLICAX2P *jogo.getPreco());
		
	}

	@Override
	public String toString() {
		return "Noob";
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) throws Exception {
		int x2p = 0;
		
		x2p = x2p + jogo.registraJogada(scoreObtido, zerou);
		

		if (jogo.getJogabilidade().equals(Jogabilidade.ONLINE)) {
			x2p = x2p - 10;
		}
		if (jogo.getJogabilidade().equals(Jogabilidade.COMPETITIVO)) {
			x2p = x2p - 20;
		}
		
		return x2p;
		
		
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) throws Exception {
		int x2p = 0;
		x2p = x2p + jogo.registraJogada(scoreObtido, zerou);

		if (jogo.getJogabilidade().equals(Jogabilidade.OFFLINE)) {
			x2p = x2p + 30;
		}
		if (jogo.getJogabilidade().equals(Jogabilidade.MULTIPLAYER)) {
			x2p = x2p + 20;
		}
		return x2p;
	}
	
	
	
	

}