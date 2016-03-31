package centralGames;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Operacional.Loja;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class TesteLoja {

	private Loja loja1;
	@Before
	public void setUp() {
		loja1 = new Loja();
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals(0, loja1.getUsuarios().size());
		

		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void testaCriaUsuario() {
		try {
			loja1.adicionaUsuario("Maria", "m123", "Noob");
			Assert.assertEquals(1, loja1.getUsuarios().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaVendeJogo() {
		try {
			loja1.adicionaUsuario("Maria", "m123", "Noob");
			loja1.adicionaDinheiro("Maria", 200);
			loja1.vendeJogos("Maria", "Puzzle", "Plataforma", 100);

			loja1.adicionaUsuario("Joao", "j123", "Veterano");
			loja1.adicionaDinheiro("Joao", 200);
			loja1.vendeJogos("Joao", "Batman", "Plataforma", 100);
	

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaAdicionaDinheiro() {
		try {
			loja1.adicionaUsuario("Maria", "m123", "Noob");
			loja1.adicionaDinheiro("Maria", 250.0);
			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					Assert.assertEquals(250.0, user.getDinheiro(), 0.1);
				}
			}

			loja1.adicionaDinheiro("Maria", 100.0);
			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					Assert.assertEquals(350.0, user.getDinheiro(), 0.1);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
	}

	
	@Test
	public void testaUpgrade() {
		try {
			loja1.adicionaUsuario("Maria", "m123", "Noob");

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					user.setX2p(1000);
				}
			}

			loja1.upgrade("m123");
			Assert.assertTrue(loja1.getUsuarioID("m123") instanceof Veterano);

		} catch (Exception e) {
			Assert.fail();
		}

		try {
			loja1.adicionaUsuario("Joao", "j123", "Veterano");

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Joao")) {
					user.setX2p(1000);
				}
			}

			loja1.upgrade("j123");
			Assert.fail("Esperava excecao de conversao invalida");

		} catch (Exception e) {
			Assert.assertEquals("Usuario ja e Veterano", e.getMessage());
		}

		try {
			loja1.adicionaUsuario("Jose", "zezinho", "Noob");

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Jose")) {
					user.setX2p(999);
				}
			}

			loja1.upgrade("zezinho");
			Assert.fail("Esperava excecao de pontos insuficientes");

		} catch (Exception e) {
			Assert.assertEquals("Pontos incompativeis para upgrade",
					e.getMessage());
		}
	}

	
}