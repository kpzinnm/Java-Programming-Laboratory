package lab02;

/**
 *  Representação do estado do estudante, sendo ele cansado ou descansado.
 *  Estado esse definido pela quantidade total de horas de descanso em relação a uma determinada 
 quantidade de semanas.
 *
 * @author Gabriel Alves
 */
public class Descanso {
    
    /**
     * Status Geral do estudante qualquer. No formato de String, sendo ele cansado ou descansado.
     */
    private String StatusGeral;
    
    /**
     * Números de Semanas. No formato inteiro, representa a quantidade de semanas total em que o aluno esta
     em uma determinada tarefa. 
     */
    private int NumerosSemanas;
    
    /**
     * Horas de Descanso. No formato inteiro, representa a quantidade total de descanso em horas em uma 
     quantidade X de semanas.
     */
    private int HorasDescanso;

    /**
     * Constrói o Descanso, definindo o aluno como cansado por padrão.
     */
    public Descanso(){
        this.StatusGeral = "cansado";
    }

    /**
     * Retorna o valor em formato String contido em StatusGeral.
     * 
     * @return a String contida em StatusGeral.
     */
    public String getStatusGeral() {
        return StatusGeral;
    }

    /**
     * Define o valor passando em parâmetro na variável HorasDescanso.
     * 
     * @param valor representa a quantidade de descanso total, no formato inteiro.
     */
    public void defineHorasDescanso(int valor){
        this.HorasDescanso = valor;
    }

    /**
     * Define o valor passando em parâmetro na variável 'NumerosSemanas'.
     * 
     * @param valor que representa a quantidade total de números de semana, no formato inteiro.
     */
    public void defineNumeroSemanas(int valor){
        this.NumerosSemanas = valor;
        defineStatusGeral();    
    }

    /**
     * Define o StatusGeral, a partir do comparativo entre as Horas de Descanso total pelo Numero de Semanas
     multiplicado por 26, esse calculo representa a quantidade total de descanso que o aluno deveria ter
     de acordo com a quantidade de semanas.
     */
    private void defineStatusGeral(){
        if (HorasDescanso >= NumerosSemanas * 26){
            this.StatusGeral = "descansado";
        } else {
            this.StatusGeral = "cansado";
        }
    }

}
