import java.util.ArrayList;
import java.util.HashSet;

/**
 * Aluno, que possui: nome, matrícula e curso
 *
 * @author Gabriel Santos Alves
 * */
public class Aluno {

    private String matricula;
    private String nome;
    private String curso;

    /**
     * Lista de todos os grupos em que o Aluno está cadastrado
     *
     * @param Grupo obejeto do tipo Grupo
     * */
    private HashSet<Grupo> grupos = new HashSet<>();

    /**
     * Constrói um aluno com: matrícula, nome e curso
     *
     * @param matricula do aluno
     * @param nome do aluno
     * @param curso do aluno*/
    public Aluno(String matricula, String nome, String curso){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Adiciona um novo grupo a lista de grupos
     *
     * @param grupo objeto do tipo grupo
     * */
    public void adicionaGrupo(Grupo grupo){
        this.grupos.add(grupo);
    }

    /**
     * Retorna uma lista contendo todos os grupos em que o aluno está cadastro, bem como suas capacidades
     *
     * @return lista de grupos
     * */
    public String listaGrupos() {
        String retorno = "";
        for (Grupo grupo : grupos) {
            retorno += "- " + grupo.getNome() + " " + grupo.getQuantAlunos() + "/" + grupo.getTamanhoGrupo() + "\n";
        }
        return retorno;
    }

    /**
     * Retorna a string contendo nome, matricula e curso do aluno
     *
     * @return detalhes sobre o aluno
     * */
    @Override
    public String toString(){
        String saida = "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
        return saida;
    }

    /**
     * Gera um Hash Code com base na matrícula do aluno
     *
     * @return hashCode da matrícula*/
    @Override
    public int hashCode(){
        return this.matricula.hashCode();
    }

    /**
     * Compara de dois objetos são iguais, usando a matrícula como base
     *
     * @return retorno "booleano" da verificação
     * */
    @Override
    public boolean equals(Object c){
        boolean verificacao = false;
        //verifica se objeto não é nulo
        if (c == null){ return verificacao; }
        //verifica se são da mesma classe
        if (c.getClass() != this.getClass()) { return verificacao; }
        // cria a referencia da classe para o objeto
        Aluno cAluno = (Aluno) c;
        // verifica se os atributos reevantes são iguais
        if (this.matricula.equals(cAluno.matricula)){
            verificacao = true;
        }
        return verificacao;
    }

}
