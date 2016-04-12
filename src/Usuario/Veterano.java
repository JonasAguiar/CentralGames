package Usuario;

import Jogo.Jogo;

public class Veterano implements ITipoUsuario{
	
	private static final int MULTIPLICAX2P = 15;
	private final double PORCENTAGEM_DESCONTO = 20;

	public double getPorcentagemDesconto() {
		return PORCENTAGEM_DESCONTO;
	}

	@Override
	public int compraJogo(Jogo jogo) {
		compraJogo(jogo);
		return (int)(MULTIPLICAX2P * jogo.getPreco());
		
	}

	@Override
	public String toString() {
		return "Veterano";
	}
	
	

}