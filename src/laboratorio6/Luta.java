package laboratorio6;



public class Luta extends Jogo {
	private static final double SCORE_MAXIMO = 100000; 

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
		
	}
	
	@Override
	public int registraJogada(double score, boolean zerou) throws Exception{
		if(score < 0 || score > SCORE_MAXIMO){
			throw new Exception("Score invalido.");
		}
		if(score > super.getBestScore() && zerou ){
			super.setBestScore(score); 
			super.setQuantidadeZeradas(super.getQuantidadeZeradas()+1);
			return (int)score/1000;
				}
		super.setQuantidadeJogadas(super.getQuantidadeJogadas()+1);
		return 0;
	}
	
}