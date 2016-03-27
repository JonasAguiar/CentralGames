package laboratorio6;


public class Noob extends Usuario{
	
	private static final int MULTIPLICAX2P = 10;
	private static final double PORCENTAGEM_DESCONTO = 15;
	public Noob(String nome, String id) throws Exception {
		super(nome, id);
	}
	
	@Override
	public void compraJogo(Jogo jogo) throws Exception{
			super.compraJogo(jogo);
			double desconto = (jogo.getPreco() * PORCENTAGEM_DESCONTO)/100;
			super.setDinheiro(jogo.getPreco() - desconto);
			super.setX2p((int)(MULTIPLICAX2P *jogo.getPreco()));
			
		}
	
	
}

