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

	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Jogabilidade> j1;
	private HashSet<Jogabilidade> j2;
	private HashSet<Jogabilidade> j3;

	@Before
	public void setUp() throws Exception {
		try {
			usuario1 = new Usuario("Maria", "m123");
			usuario2 = new Usuario("Joao", "j123");

			jogo1 = new Plataforma("Pluzze", 100);
			jogo2 = new Luta("Fight", 50.0);
			jogo3 = new Rpg("Cruzader", 70);

		} catch (EntradaInvalidaException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals("Maria", usuario1.getNome());
			Assert.assertEquals("m123", usuario1.getId());
			Assert.assertEquals(0.0, usuario1.getDinheiro(), 0.1);
			Assert.assertEquals(0, usuario1.getX2p());
			Assert.assertEquals(0.0, usuario1.getTotalGasto(), 0.1);

			Assert.assertEquals("Joao", usuario2.getNome());
			Assert.assertEquals("j123", usuario2.getId());
			Assert.assertEquals(0.0, usuario2.getDinheiro(), 0.1);
			Assert.assertEquals(0, usuario2.getX2p());
			Assert.assertEquals(0.0, usuario2.getTotalGasto(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaUsuarioInvalido() throws Exception {
		try {
			usuario3 = new Usuario("", "abc");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("String especificada e invalida", e.getMessage());
		}

		try {
			usuario4 = new Usuario("Fulano", "");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaInvalidaException e) {
			Assert.assertEquals("String especificada e invalida", e.getMessage());
		}
	}

	

	@Test
	public void testaAdicionaJogo() {
		try {
			usuario1.setDinheiro(250);
			usuario1.adicionaJogoComprado(jogo1);
			usuario1.setX2p(1000);
			Assert.assertEquals(100, usuario1.getTotalGasto(), 0.1);
			Assert.assertEquals(1, usuario1.getJogosComprados().size());
			Assert.assertEquals(250.0, usuario1.getDinheiro(), 0.1);
			Assert.assertEquals(1000, usuario1.getX2p());

		} catch (Exception e) {
			Assert.fail();
		}
	}


	@Test
	public void testRecompensa() {
		try {
			usuario1.adicionaJogoComprado(jogo2);
			usuario1.recompensar("Fight", 4000, false);
			Assert.assertEquals(514, usuario1.getX2p());
			Assert.assertTrue(usuario1.getTipoDeUsuario() instanceof Noob);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testPunir() {
		try {
			usuario1.adicionaJogoComprado(jogo2);
			usuario1.punir("Cruzader", 500, true);
			Assert.assertEquals(1010, usuario1.getX2p());
			Assert.assertTrue(usuario1.getTipoDeUsuario() instanceof Noob);

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testaToString() {
		try {
			usuario1.setDinheiro(2500);
			usuario1.adicionaJogoComprado(jogo1);
			usuario1.adicionaJogoComprado(jogo2);

			final String EOL = System.getProperty("line.separator");
			String mensagemJogos = "";
			for (Jogo j : usuario1.getJogosComprados()) {
				mensagemJogos = mensagemJogos + j.toString() + EOL;
			}
			String mensagem = "m123" + EOL + "Maria" + EOL
					+ "Jogador Noob: 1514 x2p" + EOL + "Lista de Jogos:" + EOL
					+ mensagemJogos + "Total de preco dos jogos: R$ 150.0"
					+ EOL;
			Assert.assertEquals(mensagem, usuario1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}

