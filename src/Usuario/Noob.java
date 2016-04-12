package Usuario;

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
	
	
	
	

}