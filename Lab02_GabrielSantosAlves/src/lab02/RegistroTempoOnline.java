package lab02;

/**
 * Registra a quantidade de tempo online que um determinado estudante dedicou a uma disciplina.
 * Todo estudante tem que definir pelo menos o nome da disciplina, outra opção seria adicionar
 o nome e o tempo esperado na disciplina.
 *
 * @author Gabriel Alves
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina. No formato String.
     */
    private String nomeDisciplina;
    
    /**
     * Tempo gasto online. No formato inteiro, refere-se a quantidade de horas total que um estudante
     dedicou a uma disciplina.
     */
    private int tempoGastoOnline;

    /**
     * Tempo online esperado. No formato inteiro, refere-se a quantidade total de horas que um estudante
     tem que dedicar a uma disciplina. A quantidade esperada, é duas vezes a carga horaria da disciplina.
     */
    private int tempoOnlineEsperado;

    /**
     * Constrói o registro de tempo online a partir do nome da disciplina.
     * O tempo online esperado é duas vezes a carga horaria da disciplina,
     a carga horaria padrão é 60 horas.
     *
     * @param nomeDisciplina nome da disciplina, formato String
     */
    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 60 * 2;
    }

    /**
     * Constrói o registro de tempo online a partir do nome da disciplina e o tempo online esperado.
     * O tempo esperado online sendo definido, pressupõe que já foi feito o calculo de duas vezes a
     carga horária da disciplina.
     *
     * @param nomeDisciplina nome da disciplina, formato String
     * @param tempoOnlineEsperado tempo online esperado em uma determinada disciplina, formato inteiro.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona o valor do parâmetro (tempo) ao atributo tempoGastoOnline.
     * 
     * @param tempo tempo a ser adicionado, formato inteiro.
     */
    public void adicionaTempoOnline(int tempo){
        this.tempoGastoOnline = this.tempoGastoOnline + tempo;
    }
    
    /**
     * Valida se o estudante dedicou a quantidade total de horas esperada e retorna o resultado da validação.
     * 
     * @return booaleno com o resultado da validação.
     */
    public boolean atingiuMetaTempoOnline(){
        boolean atingiuMeta = false;
        if (tempoGastoOnline >= tempoOnlineEsperado){
            atingiuMeta = true;
        }

        return atingiuMeta;
    }

    /**
     * Retorna uma String formatada seguindo o seguinte modelo.
     * <Nome da disciplina> <tempo total gasto online>/<tempo online esperado>
     * 
     * @return retorna uma String seguindo o modelo a cima.
     */
    public String toString(){
        String retornoMetodo = nomeDisciplina + " " + tempoGastoOnline + "/" + tempoOnlineEsperado;

        return retornoMetodo;
    }
}
