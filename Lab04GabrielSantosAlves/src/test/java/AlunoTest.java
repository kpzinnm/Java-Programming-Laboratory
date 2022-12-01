import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    Sistema sistema = new Sistema();

    @Test
    void testHashCode() {
        Aluno aluno = new Aluno("250", "José", "Matematica");
        String verificacao = "250";
        assertEquals(verificacao.hashCode(), aluno.hashCode());
    }

    @Test
    void testEqualsAlunosIguais() {
        Aluno aluno1 = new Aluno("250", "José", "Matematica");
        Aluno aluno2 = new Aluno("250", "José", "Matematica");
        assertEquals(true, aluno1.equals(aluno2));
    }

    @Test
    void testEqualsAlunosDiferentes() {
        Aluno aluno1 = new Aluno("250", "José", "Matematica");
        Aluno aluno2 = new Aluno("700", "Flavio", "Portugues");
        assertEquals(false, aluno1.equals(aluno2));
    }

    @Test
    void testEqualsNull() {
        Aluno aluno1 = new Aluno("250", "José", "Matematica");
        assertEquals(false, aluno1.equals(null));
    }

    @Test
    void testEqualsAlunosTiposDiferentes() {
        Aluno aluno1 = new Aluno("250", "José", "Matematica");
        assertEquals(false, aluno1.equals(sistema));
    }
}