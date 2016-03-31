package Operacional;

import Jogo.Jogo;
import Jogo.Plataforma;
import Jogo.Rpg;

public class FactoryJogo {
	
	
	/**
	 * O metodo é utlizado para criacao de jogos de diferentes tipos.
	 * @param tipoJogo
	 * @param nomeJogo
	 * @param preco
	 * @return
	 * @throws Exception
	 */
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
