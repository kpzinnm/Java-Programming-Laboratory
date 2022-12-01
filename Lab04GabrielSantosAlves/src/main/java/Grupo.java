import java.util.ArrayList;
import java.util.HashSet;

/**
 * Grupo representa um conjunto limitado de alunos agrupados em um grupo com tema e objetivo especifico
 *
 * @author Gabriel Santos Alves*/
public class Grupo {

    private String nome;
    private String tamanhoGrupo;
    private int quantAlunos;

    /**
     * Lista de alunos cadastrados no Grupo
     *
     * @param objeto do tipo Aluno
     * */
    private HashSet<Aluno> alunos = new HashSet<>();

    /**
     * Constrói um Grupo, a partir de um nome e tamanho
     *
     * @param nome do grupo
     * @param tamanhoGrupo quantidade máxima de alunos
     * */
    public Grupo(String nome, String tamanhoGrupo){
        this.nome = nome;
        if (tamanhoGrupo.equals("")){
            this.tamanhoGrupo = "infinito";
        } else {
            this.tamanhoGrupo = tamanhoGrupo;
        }
        this.quantAlunos = 0;
    }

    /**
     * Adicona um novo aluno ao grupo
     *
     * @param aluno obejeto do tipo Aluno
     * */
    public void adicionaAluno(Aluno aluno){
        if (podeAdicionarAlunos() && !(existeAluno(aluno))){
            this.alunos.add(aluno);
            quantAlunos++;
        }
    }

    /**
     * Verifica se um determinado aluno está cadastrado no grupo
     *
     * @param aluno objeto do tipo aluno
     * */
    public boolean existeAluno(Aluno aluno){
        boolean validacao = false;
        for (Aluno aluno1 : alunos){
            if (aluno1.equals(aluno1)){
                validacao = true;
            }
        }
        return validacao;
    }

    /**
     * Retorna a quantidade de alunos cadastrado no grupo
     *
     * @return quantidade de alunos
     * */
    public int getQuantAlunos(){ return this.quantAlunos; }

    /**
     * Retorna o tamanho total do grupo
     *
     * @return tamanho do grupo
     * */
    public String getTamanhoGrupo(){ return this.tamanhoGrupo; }

    /**
     * Retorna o nome do grupo
     *
     * @return nome do grupo
     * */
    public String getNome(){ return this.nome; }

    /**
     * Verifica se o grupo ainda possui capacidade de armazenar um novo aluno
     *
     * @return se o grupo está cheio*/
    public boolean podeAdicionarAlunos(){
        boolean validacao = true;
        if (tamanhoGrupo.equals("infinito")) { }
        else if (quantAlunos == Integer.parseInt(tamanhoGrupo)){
            validacao = false;
        }

        return validacao;
    }
}
