import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {
	
	private Agenda agenda = new Agenda();

	@Test
	void testCadastraContatoPosicaoVazia() {
		assertEquals (true, this.agenda.cadastraContato(1, "Matheus" , "Gaudencio" , "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoExistente() {
		this.agenda.cadastraContato(1, "Matheus" , "Gaudencio" , "(83) 99999-0000");
		assertEquals (true, this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(85) 99999-0000"));
	}

	@Test
	void testCadastraContatoNomeRepetido() {
		this.agenda.cadastraContato(1, "Matheus" , "Gaudencio" , "(83) 99999-0000");
		assertEquals (false, this.agenda.cadastraContato(3, "Matheus" , "Gaudencio" , "(85) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoNomeVazio() {
		assertEquals (false, this.agenda.cadastraContato(3, "" , "Gaudencio" , "(85) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoSobrenomeVazio() {
		assertEquals (true, this.agenda.cadastraContato(3, "Matheus" , "" , "(85) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoTelefoneVazio() {
		assertEquals (false, this.agenda.cadastraContato(3, "Matheus" , "Gaudencio" , ""));
	}
	
	@Test
	void testCadastraContatoLimite() {
		assertEquals (true, this.agenda.cadastraContato(100, "Gabriel" , "Alves" , "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoAcimaLimite() {
		assertEquals (false, this.agenda.cadastraContato(101, "Gabriel" , "Alves" , "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoAbaixoLimite() {
		assertEquals (false, this.agenda.cadastraContato(-1, "Gabriel" , "Alves" , "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraFavorito() {
		this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(83) 99999-0000");
		assertEquals (true, this.agenda.cadastraFavorito(this.agenda.getContato(1), 1, 1));
	}
	
	@Test
	void testCadastraFavoritoPosicaoInvalida() {
		this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(83) 99999-0000");
		assertEquals (false, this.agenda.cadastraFavorito(this.agenda.getContato(1), 14, 1));
	}
	
	@Test
	void testCadastraFavoritoContatoInvalida() {
		this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(83) 99999-0000");
		assertEquals (false, this.agenda.cadastraFavorito(this.agenda.getContato(1), 1, 14));
	}
	
	@Test
	void testRemoveFavorito() {
		this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(83) 99999-0000");
		this.agenda.cadastraFavorito(this.agenda.getContato(1), 1, 1);
		assertEquals (true, this.agenda.removeFavorito(1));
	}
	
	@Test
	void testRemoveFavoritoPosicaoInvalida() {
		this.agenda.cadastraContato(1, "Gabriel" , "Alves" , "(83) 99999-0000");
		this.agenda.cadastraFavorito(this.agenda.getContato(1), 1, 1);
		assertEquals (false, this.agenda.removeFavorito(5));
	}
}
