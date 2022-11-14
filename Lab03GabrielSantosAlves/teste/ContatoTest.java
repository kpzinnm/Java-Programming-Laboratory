import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;



public class ContatoTest {
	 
	private Contato contatoBase;
	 
	@BeforeEach
    void preparaContatos() {
		this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
	}

	@Test
	void testNomeCompleto() {
		String msg = "Matheus Gaudencio";
	    assertEquals (msg, this.contatoBase.nomeCompleto());
	    }
	
	@Test
	void testToString() {
		String msg = "Matheus Gaudencio\n555-5551";
	    assertEquals(msg, this.contatoBase.toString());
	}
	
	@Test
	void testToStringFavorito() {
		this.contatoBase.setFavorito(true);
		String msg = "❤️ Matheus Gaudencio\n555-5551";
	    assertEquals(msg, this.contatoBase.toString());
	}
}



