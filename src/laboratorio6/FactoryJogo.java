package laboratorio6;

public class FactoryJogo {
	
	
	
	public Jogo getJogo(String tipoJogo, String nomeJogo, double preco) throws Exception{
		if(tipoJogo == null){
			throw new Exception("Nao pode ser criado jogo nulo.");
		}
		if(tipoJogo.equals("Rpg")){
			Jogo novoJogo = new Rpg(nomeJogo, preco);
			return novoJogo;
		}else if(tipoJogo.equals("Luta")){
			Jogo novoJogo = new Rpg(nomeJogo, preco);
			return novoJogo;
		}else if(tipoJogo.equals("Plataforma")){
			Jogo novoJogo = new Plataforma(nomeJogo, preco);
			return novoJogo;
		}
		return null;
		
	}

}
