package centralGames;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.EntradaInvalidaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.Rpg;

public class TesteJogo {

	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private Jogo jogo4;
	private Jogo jogo5;
	
	@Before
	public void setUp() throws Exception {
		try {
			
			Jogo jogo1 = new Plataforma("Puzzle", 15.00);
			jogo1.adicionaJogabilidade(Jogabilidade.ONLINE);

			
			Jogo jogo2 = new Rpg("Batman", 12.00);
			jogo2.adicionaJogabilidade(Jogabilidade.COMPETITIVO);

			
			Jogo jogo3 = new Luta("Cruzader", 29.00);
			jogo3.adicionaJogabilidade(Jogabilidade.COOPERATIVO);

		} catch (EntradaInvalidaException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals("Puzzle", jogo1.getNome());
			Assert.assertEquals(15.0, jogo1.getPreco(), 0.1);
			Assert.assertEquals(Jogabilidade.ONLINE, jogo1.getJogabilidade());

			Assert.assertEquals("Batman", jogo2.getNome());
			Assert.assertEquals(12.0, jogo2.getPreco(), 0.1);
			Assert.assertEquals(Jogabilidade.COMPETITIVO, jogo2.getJogabilidade());

			Assert.assertEquals("Cruzader", jogo3.getNome());
			Assert.assertEquals(29.0, jogo3.getPreco(), 0.1);
			Assert.assertEquals(Jogabilidade.COOPERATIVO, jogo3.getJogabilidade());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaJoga() {
		try {
			Assert.assertEquals(0, jogo1.registraJogada(600, false));
			Assert.assertEquals(1, jogo1.getQuantidadeJogadas());
			Assert.assertEquals(0, jogo1.getQuantidadeZeradas());

			Assert.assertEquals(20, jogo1.registraJogada(200, true));
			Assert.assertEquals(2, jogo1.getQuantidadeJogadas());
			Assert.assertEquals(1, jogo1.getQuantidadeZeradas());

			Assert.assertEquals(20, jogo1.registraJogada(601, true));
			Assert.assertEquals(3, jogo1.getQuantidadeJogadas());
			Assert.assertEquals(2, jogo1.getQuantidadeZeradas());

			Assert.assertEquals(10, jogo2.registraJogada(3000, false));

			Assert.assertEquals(4, jogo3.registraJogada(4000, true));

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaJogoInvalido() throws Exception {
		try {
			Jogo jogo4 = new Plataforma("", 10.0);
		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("String especificada e invalida", e.getMessage());
		}
		try {
			Jogo jogo5 = new Rpg("ManieHam", -1);
		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("Dado especificado e invalido", e.getMessage());
		}
	}

	@Test
	public void testaToString() {
		try {
			jogo1.registraJogada(100, true);

			final String EOL = System.getProperty("line.separator");
			String mensagem = "+ Puzzle - Plataforma" + EOL
					+ "==> Jogou 1 vez(es)" + EOL + "==> Zerou 1 vez(es)" + EOL
					+ "==> Maior score: 100" + EOL;
			Assert.assertEquals(mensagem, jogo1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}

}