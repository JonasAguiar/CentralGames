package centralGames;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Exceptions.EntradaInvalidaException;
import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.Rpg;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class TesteUsuario {

	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Usuario user4;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Jogabilidade> j1;
	private HashSet<Jogabilidade> j2;
	private HashSet<Jogabilidade> j3;

	@Before
	public void setUp() throws Exception {
		try {
			user1 = new Noob("Maria", "m123");
			user2 = new Veterano("Joao", "j123");

			jogo1 = new Plataforma("Pluzze", 100);

			jogo2 = new Luta("Fight", 50.0);

			jogo3 = new Rpg("Medieval", 70);

		} catch (EntradaInvalidaException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals("Maria", user1.getNome());
			Assert.assertEquals("m123", user1.getId());
			Assert.assertEquals(0.0, user1.getDinheiro(), 0.1);
			Assert.assertEquals(0, user1.getX2p());
			Assert.assertEquals(0.0, user1.getTotalGasto(), 0.1);

			Assert.assertEquals("Joao", user2.getNome());
			Assert.assertEquals("j123", user2.getId());
			Assert.assertEquals(0.0, user2.getDinheiro(), 0.1);
			Assert.assertEquals(0, user2.getX2p());
			Assert.assertEquals(0.0, user2.getTotalGasto(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaUsuarioInvalido() throws Exception {
		try {
			user3 = new Noob("", "abc");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("String especificada e invalida", e.getMessage());
		}

		try {
			user4 = new Veterano("Fulano", "");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("String especificada e invalida", e.getMessage());
		}
	}

	

	@Test
	public void testaAdicionaJogo() {
		try {
			user1.setDinheiro(250);
			user1.adicionaJogoComprado(jogo1);
			user1.setX2p(1000);
			Assert.assertEquals(100, user1.getTotalGasto(), 0.1);
			Assert.assertEquals(1, user1.getJogosComprados().size());
			Assert.assertEquals(250.0, user1.getDinheiro(), 0.1);
			Assert.assertEquals(1000, user1.getX2p());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaToString() {
		try {
			user1.setDinheiro(2500);
			user1.adicionaJogoComprado(jogo1);
			user1.adicionaJogoComprado(jogo2);

			final String EOL = System.getProperty("line.separator");
			String mensagemJogos = "";
			for (Jogo j : user1.getJogosComprados()) {
				mensagemJogos = mensagemJogos + j.toString() + EOL;
			}
			String mensagem = "m123" + EOL + "Maria" + EOL
					+ "Jogador Noob: 1514 x2p" + EOL + "Lista de Jogos:" + EOL
					+ mensagemJogos + "Total de preco dos jogos: R$ 150.0"
					+ EOL;
			Assert.assertEquals(mensagem, user1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}

