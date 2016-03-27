package laboratorio6;


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
	
	
}

