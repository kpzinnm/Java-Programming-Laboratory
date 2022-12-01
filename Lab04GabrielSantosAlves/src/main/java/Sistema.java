import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe responsável pelo gerenciamento do sistema
 *
 * @author Gabriel Santos Alves
 * */
public class Sistema {
    Scanner input = new Scanner(System.in);
    Aluno aluno;
    Grupo grupo;

    /**
     * Alunos cadastrados
     * @param String matricula do aluno
     * @param Aluno objeto do tipo Aluno
     * */
    private HashMap<String, Aluno> mapaMatriculaAlunos = new HashMap();

    /**
     * Grupos cadastrados
     * @param String nome do grupo
     * @param Aluno objeto do tipo Grupo
     * */
    private HashMap<String, Grupo> mapaNomeGrupos = new HashMap();

    /**
     * Recebe ‘strings’ do tipo: matrícula, nome e curso, responsáveis por cadastrar um novo aluno.
     *
     * @param matricula do novo aluno
     * @param nome do aluno
     * @param curso do aluno
     * @return retorna um boolean, caso o aluno não exista é cadastrado e retorna 'true', caso existe
     * não é cadastrado e o retorno é 'false'
     * */
    public boolean cadastrarAluno(String matricula, String nome, String curso){
        boolean validacao = false;
        if (!(existeAluno(matricula))){
            this.mapaMatriculaAlunos.put(matricula, new Aluno(matricula, nome, curso));
            validacao = true;
        }

        return validacao;
    }

    /**
     * Busca o aluno a partir da sua matricula
     *
     * @param matricula do aluno a ser buscado
     * @return retorna as informações do aluno, ou o aviso de que o aluno não existe
     **/
    public String exibirAluno(String matricula){
        String saida;
        if (existeAluno(matricula)){
            saida = this.mapaMatriculaAlunos.get(matricula).toString();
        } else {
            saida = "ALUNO NÃO CADASTRADO";
        }

        return saida;
    }

    /**
     * Cria um grupo
     *
     * @param nome do grupo
     * @param tamanho do grupo, quantidade de alunos maxima
     * @return "true" caso seja possível criar, ou false se o grupo já existir
     * */
    public boolean criarGrupo(String nome, String tamanho){
        boolean validacao = false;
        if (!(existeGrupo(nome))){
            this.mapaNomeGrupos.put(nome.toUpperCase(), new Grupo(nome, tamanho));
            validacao = true;
        }

        return validacao;
    }

    /**
     * Retorna os grupos que o aluno está cadastrado, como também a ocupação do mesmo
     *
     * @param matricula do aluno
     * @return lista de grupos do aluno
     * */
    public String checaGrupoAluno(String matricula){
        String retorno = "";
        if (existeAluno(matricula)){
            retorno = this.mapaMatriculaAlunos.get(matricula).listaGrupos();
        }

        return retorno;
    }

    /**
     * Aloca um aluno em um determinado grupo já registrado
     *
     * @param matricula do aluno
     * @param grupo nome do grupo
     * @return a situação referente ao cadastro
     * */
    public String adiconaAlunoGrupo(String matricula, String grupo){
        if (existeAluno(matricula) && existeGrupo(grupo) && this.mapaNomeGrupos.get(grupo.toUpperCase()).podeAdicionarAlunos()){
            this.mapaNomeGrupos.get(grupo.toUpperCase()).adicionaAluno(this.mapaMatriculaAlunos.get(matricula));
            this.mapaMatriculaAlunos.get(matricula).adicionaGrupo(this.mapaNomeGrupos.get(grupo.toUpperCase()));
            return  "ALUNO ALOCADO";
        }
        if (!(existeAluno(matricula))) { return "ALUNO NÃO CADASTRADO"; }
        if (!(existeGrupo(grupo))) { return "GRUPO NÃO CADASTRADO"; }
        if (!(this.mapaNomeGrupos.get(grupo.toUpperCase()).podeAdicionarAlunos())) { return "GRUPO CHEIO"; }

        return null;
    }

    /**
     * Verifica se um aluno pertence a um determinado grupo
     *
     * @param matricula do aluno
     * @param grupo nome do grupo
     * @return a situação de permanência do aluno no grupo
     * */
    public String pertinenciaGrupo(String matricula, String grupo){
        String retorno = "";

        if (existeAluno(matricula) && existeGrupo(grupo)){
            if (this.mapaNomeGrupos.get(grupo.toUpperCase()).existeAluno(this.mapaMatriculaAlunos.get(matricula))){
                retorno = "ALUNO PERTENCE AO GRUPO.";
            }
            else {
                retorno = "ALUNO NÃO PERTENCE AO GRUPO.";
            }
        }
        else if (!(existeGrupo(grupo))) { retorno = "GRUPO NÃO CADASTRADO.\n"; }
        else if (!(existeAluno(matricula))) { retorno = "ALUNO NÃO ENCONTRADO.\n"; }

        return retorno;
    }

    /**
     * Verifica se o aluno foi cadastrado
     *
     * @param matricula do aluno
     * @return verficação "boleana"
     * */
    private boolean existeAluno(String matricula) {
        return this.mapaMatriculaAlunos.containsKey(matricula);
    }

    /**
     * Verifica se o grupo foi cadastrado
     *
     * @param nomeGrupo nome do grupo
     * @return verficação "boleana"
     * */
    private boolean existeGrupo(String nomeGrupo) {
        return this.mapaNomeGrupos.containsKey(nomeGrupo.toUpperCase());
    }
}
