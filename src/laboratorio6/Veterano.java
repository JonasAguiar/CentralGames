package laboratorio6;

public class Veterano extends Usuario {

	private static final int MULTIPLICAX2P = 15;
	private static final double PORCENTAGEM_DESCONTO = 20;
	public Veterano(String nome, String id) throws Exception {
		super(nome, id);

	}
	
	@Override
	public void compraJogo(Jogo jogo) throws Exception{
		super.compraJogo(jogo);
		double desconto = (jogo.getPreco() * PORCENTAGEM_DESCONTO)/100;
		super.setDinheiro(jogo.getPreco()- desconto);
		super.setX2p(super.getX2p() + (int)(MULTIPLICAX2P * jogo.getPreco()));
		
	}
	
}

