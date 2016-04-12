package Usuario;

import Jogo.Jogo;

public interface ITipoUsuario {

	int compraJogo(Jogo jogo);
	String toString();
	int recompensar(Jogo jogo, int scoreObtido, boolean zerou) throws Exception;
	int punir(Jogo jogo, int scoreObtido, boolean zerou) throws Exception;
}