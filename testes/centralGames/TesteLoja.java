package centralGames;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Operacional.LojaFacade;
import Usuario.Usuario;


public class TesteLoja {

	private LojaFacade loja1;
	@Before
	public void setUp() {
		loja1 = new LojaFacade();
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
			for (Usuario usuario : loja1.getUsuarios()) {
				if (usuario.getNome().equals("Maria")) {
					Assert.assertEquals(250.0, usuario.getDinheiro(), 0.1);
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

	

	
}