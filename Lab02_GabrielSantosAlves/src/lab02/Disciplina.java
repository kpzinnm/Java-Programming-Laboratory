package lab02;

import java.util.Arrays;

/**
 * Representa uma disciplina, onde a disciplina possui nome, 4 notas e a quantidade de horas que
 um aluno se dedicou a ela. 
 * Além desses atributos, possui a característica de determinar se um aluno passou por média.
 * 
 * @author Gabriel Alves
 */
public class Disciplina {

    /**
    * Nome da disciplina a ser cadastrada, no formato String
    * */
    private String nomeDisciplina;

    /**
    * Horas de estudos que o estudante dedicou a disciplina, valor pode ser incrementado, no formato inteiro
    * */
    private int horasEstudo;

    /**
    * Media aritmética do estudante na disciplina, no formato de ponto flutuante
    * */
    private double media;

    /**
    * Array de ponto flutuante, contendo as 4 notas do estudante
    * */
    private double[] notas = new double[4];

    /**
     * Constrói um objeto Disciplina, onde é passado como parâmetro o nome da disciplina
     * 
     * @param nomeDisciplina representa o nome da disciplina
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }
    
    /** 
     * Incrementa uma quantidade de horas na variável horasEstudo.
     * 
     * @param horas valor a ser incrementado a variável horasEstudo.
     */
    public void cadastraHoras(int horas){
        this.horasEstudo += horas;
    }

    
    /** 
     * Cadastra uma nova nota ao aluno, a nota é definida em uma posição especifica do array, 
     que é determinada pelo parâmetro nota.
     * 
     * @param nota posição no array em que a nova nota vai ser atribuída.
     * @param valorNota valor na nota.
     */
    public void cadastraNota(int nota, double valorNota){
        this.notas[nota-1] = valorNota;
    }

    
    /** 
     * Retorna um teste para saber se o aluno foi aprovado por média, esse teste
     leva em conta se a média das notas do aluno é maior ou igual a 7.
     *
     * @return boolean valor referente ao teste descrito a cima.
     */
    public boolean aprovado(){
        boolean taAprovado = false;
        media = calcularMedia(this.notas);
        if (media >= 7){
            taAprovado = true;
        }

        return taAprovado;
    }

    
    /** 
     * Retorna uma String com as informações totais da Disciplina no seguinte formato:
     * <nome da disciplina> <horas de estudo> <média das notas> <todas as 4 notas do aluno>
     * 
     * @return String contendo as informações do objeto.
     */
    public String toString(){
        media = calcularMedia(this.notas);
        String retornoMetodo = this.nomeDisciplina + " " + this.horasEstudo + " " + media + " " + Arrays.toString(this.notas);

        return retornoMetodo;
    }

    /** 
     * Método auxiliar que retorna a média aritmética das 4 notas do aluno.
     * 
     * @param notas array contendo as 4 notas do estudante
     * @return double média aritmética das 4 notas.
     */
    private double calcularMedia(double[] notas){
        double media = 0;
        for (int i = 0; i < notas.length; i++){
            media += notas[i];
        }

        return media/notas.length;
    }
    
}
