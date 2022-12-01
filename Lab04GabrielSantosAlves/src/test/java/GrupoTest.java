import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    Sistema sistema = new Sistema();

    @Test
    void getQuantAlunos() {
        Grupo grupo = new Grupo("Listas", "");
        Aluno aluno = new Aluno("456", "José", "Matematica");
        grupo.adicionaAluno(aluno);
        assertEquals(1, grupo.getQuantAlunos());
    }

    @Test
    void getTamanhoGrupoSemRestricao() {
        Grupo grupo = new Grupo("Listas", "");
        assertEquals("infinito", grupo.getTamanhoGrupo());
    }

    @Test
    void getTamanhoGrupoComRestricao() {
        Grupo grupo = new Grupo("Listas", "10");
        assertEquals("10", grupo.getTamanhoGrupo());
    }

    @Test
    void getNome() {
        Grupo grupo = new Grupo("Listas", "10");
        assertEquals("Listas", grupo.getNome());
    }

    @Test
    void podeAdicionarAlunosComSucessoGrupoSemRestricao() {
        Grupo grupo = new Grupo("Listas", "");
        Aluno aluno = new Aluno("456", "José", "Matematica");
        grupo.adicionaAluno(aluno);
        assertEquals(true, grupo.podeAdicionarAlunos());
    }

    @Test
    void podeAdicionarAlunosComSucessoGrupoComRestricao() {
        Grupo grupo = new Grupo("Listas", "10");
        Aluno aluno = new Aluno("456", "José", "Matematica");
        grupo.adicionaAluno(aluno);
        assertEquals(true, grupo.podeAdicionarAlunos());
    }

    @Test
    void naoPodeAdicionarAlunosGrupoCheio() {
        Grupo grupo = new Grupo("Listas", "1");
        Aluno aluno = new Aluno("456", "José", "Matematica");
        grupo.adicionaAluno(aluno);
        assertEquals(false, grupo.podeAdicionarAlunos());
    }
}