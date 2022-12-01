import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {
    Sistema sistema = new Sistema();

    @BeforeEach
    void cadastroAlunosPadra() {
        sistema.cadastrarAluno("200", "Lili Camposh", "Computação");
        sistema.cadastrarAluno("250", "Gabriel Reyes", "Computação");
        sistema.cadastrarAluno("202", "Angela Ziegler", "Medicina");
        sistema.cadastrarAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    @org.junit.jupiter.api.Test
    void cadastrarAlunoJaCadastrado() {
        assertEquals(false, sistema.cadastrarAluno("200", "Jose Silva", "Fisíca"));
    }

    @org.junit.jupiter.api.Test
    void exibirAlunoComSucesso() {
        String validacao = "Aluno: 200 - Lili Camposh - Computação";
        assertEquals(validacao, sistema.exibirAluno("200"));
    }

    @org.junit.jupiter.api.Test
    void exibirAlunoMatriculaInexistente() {
        assertEquals("ALUNO NÃO CADASTRADO", sistema.exibirAluno("900"));
    }

    @org.junit.jupiter.api.Test
    void criarGrupoSemRestricao() {
        assertEquals(true, sistema.criarGrupo("Programação OO", ""));
    }

    @org.junit.jupiter.api.Test
    void criarGrupoComRestricao() {
        assertEquals(true, sistema.criarGrupo("Listas", "10"));
    }

    @org.junit.jupiter.api.Test
    void criarGrupoComNomeDuplicado() {
        sistema.criarGrupo("Listas", "10");
        assertEquals(false, sistema.criarGrupo("Listas", "15"));
    }

    @org.junit.jupiter.api.Test
    void checaGrupoAlunoSemGrupo() {
        assertEquals("", sistema.checaGrupoAluno("202"));
    }

    @org.junit.jupiter.api.Test
    void checaGrupoAlunoComGrupos() {
        sistema.criarGrupo("Programação OO", "10");
        sistema.criarGrupo("Listas", "10");
        sistema.adiconaAlunoGrupo("250", "Listas");
        sistema.adiconaAlunoGrupo("250", "Programação OO");
        String verificacao = """
                - Programação OO 1/10
                - Listas 1/10
                """;
        assertEquals(verificacao, sistema.checaGrupoAluno("250"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoeSemRestricaoComSucesso() {
        sistema.criarGrupo("Programação OO", "");
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("202", "Programação OO"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoeComRestricaoComSucesso() {
        sistema.criarGrupo("Programação OO", "1");
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoAlunoJaAlocado() {
        sistema.criarGrupo("Programação OO", "5");
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
        assertEquals("- Programação OO 1/5\n", sistema.checaGrupoAluno("200"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoAlunoNaoCadastrado() {
        sistema.criarGrupo("Programação OO", "5");
        assertEquals("ALUNO NÃO CADASTRADO", sistema.adiconaAlunoGrupo("856", "Programação OO"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoGrupoNaoCadastrado() {
        assertEquals("GRUPO NÃO CADASTRADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
    }

    @org.junit.jupiter.api.Test
    void adiconaAlunoGrupoCheio() {
        sistema.criarGrupo("Programação OO", "1");
        assertEquals("ALUNO ALOCADO", sistema.adiconaAlunoGrupo("200", "Programação OO"));
        assertEquals("GRUPO CHEIO", sistema.adiconaAlunoGrupo("201", "Programação OO"));
    }

    @org.junit.jupiter.api.Test
    void pertinenciaGrupoComSucesso() {
        sistema.criarGrupo("Listas", "");
        sistema.adiconaAlunoGrupo("250", "Listas");
        assertEquals("ALUNO PERTENCE AO GRUPO.", sistema.pertinenciaGrupo("250", "Listas"));
    }

    @org.junit.jupiter.api.Test
    void pertinenciaGrupoAlunoNaoPertenceGrupo() {
        sistema.criarGrupo("Listas", "");
        sistema.criarGrupo("Programação OO", "");
        sistema.adiconaAlunoGrupo("250", "Programação OO");
        assertEquals("ALUNO NÃO PERTENCE AO GRUPO.", sistema.pertinenciaGrupo("250", "Listas"));
    }

    @org.junit.jupiter.api.Test
    void pertinenciaGrupoNaoCadastrado() {
        assertEquals("GRUPO NÃO CADASTRADO.\n", sistema.pertinenciaGrupo("250", "Listas"));
    }

    @org.junit.jupiter.api.Test
    void pertinenciaGrupoAlunoNaoCadastrado() {
        sistema.criarGrupo("Listas", "");
        assertEquals("ALUNO NÃO ENCONTRADO.\n", sistema.pertinenciaGrupo("960", "Listas"));
    }
}