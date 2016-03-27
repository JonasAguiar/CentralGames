package laboratorio6;


public class Plataforma extends Jogo{

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	public int registraJogada(double score, boolean zerou){
		if(zerou){
			super.setQuantidadeZeradas(getQuantidadeZeradas()+1);
			super.setQuantidadeJogadas(getQuantidadeJogadas()+1);
			return 20;
		}return 0;
	}
}
