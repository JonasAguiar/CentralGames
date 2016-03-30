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
	
	@Override
	public String toString() {

		final String QUEBRA_LINHA = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo jogo : getJogosComprados()) {
			mensagemJogos = mensagemJogos + jogo.toString() + QUEBRA_LINHA;
		}

		return getId() + QUEBRA_LINHA + getNome() + QUEBRA_LINHA + "Jogador Noob: " + getX2p()
				+ " x2p" + QUEBRA_LINHA + "Lista de Jogos:" + QUEBRA_LINHA + mensagemJogos
				+ "Total de preco dos jogos: R$ " + getTotalGasto() + QUEBRA_LINHA;
	}
}

