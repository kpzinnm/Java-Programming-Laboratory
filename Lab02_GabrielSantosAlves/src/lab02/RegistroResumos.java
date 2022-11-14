package lab02;

/**
 * Registra resumos dentro de uma  estrutura de dados de espaço limitada, os resumos
 são separados por 'tema' e o 'resumo'.
 *
 * @author Gabriel Alves
 */
public class RegistroResumos {

  /**
   * Matriz de Strings que contem os resumos, os inces [x][0] se refere ao 'tema' e o [x][1] ao 'resumo', a incognita
   'x' é a posição da linha.
   * */
  private String[][] resumos;

  /**
   * Posição da linha em que deve ser definido o novo resumo, 'linha' refere-se a relação de linha/coluna em uma matriz.
   * */
  private int posicaoLinhaArray;

  /**
   * Constrói um objeto que possui uma capacidade maxima de resumos.
   *
   * @param quantResumos refere-se a capacidade total de resumos que podem ser armazenados
   * */
  public RegistroResumos(int quantResumos){
    this.resumos = new String[quantResumos][2];
    this.posicaoLinhaArray = 0;

  }

  /**
   * Adiciona um novo resumo a matriz de resumos, verifica o tamanho do array, se a posição da linha for igual ao tamanho
   do array a posição é zerada, após adiciona a nova posição da linha em que
   a matriz ira definir o próximo resumo.
   *
   * @param tema adiciona um tema a posição [x][0] na matriz
   * @param resumo adiciona um resumo a posição [x][1] na matriz*/
  public void adiciona(String tema, String resumo){
    if (this.posicaoLinhaArray == this.resumos.length) {
      posicaoLinhaArray = 0;
    }
    this.resumos[posicaoLinhaArray][0] = tema;
    this.resumos[posicaoLinhaArray++][1] = resumo;

  }

  /**
   * Retorna uma ‘String’ contendo a quantidade total de resumos cadastrados e os seus respectivos temas
   *
   * @return saída das informações descritas.
   * */
  public String imprimeResumos(){
    String saida = "- " + this.conta() + " resumo(s) cadastrado(s)\n- ";

    for (int i = 0; i < this.conta(); i++){
      if (i <= (this.conta() - 2)){
        saida += this.resumos[i][0] + " | ";
      } else {
        saida += this.resumos[i][0];
      }
    }

    return saida;
  }

  /**
   * Retorna um array de 'String', as colunas 'tema' e 'resumo' são concatenadas em
   * um único elemento dentro do novo array.
   * 
   * @return array de Strings com elementos da matriz formatado
   * */
  public String[] pegaResumos(){
    String[] resumoLista = new String[this.resumos.length];
    for (int i = 0; i < this.resumos.length; i++){
      resumoLista[i] = this.resumos[i][0] +": "+ this.resumos[i][1];
    }

    return resumoLista;
  }

  /**
   * Retorna o numero de resumos registrado na matriz
   * 
   * @return quantResumos quantidade de resumos registrado.
   */
  public int conta(){
    int quantResumos = 0;
    for(int i = 0; i < this.resumos.length; i++){
      if (this.resumos[i][0] != null){
        quantResumos++;
      }
    }

    return quantResumos;
  }

  /**
   * Retorna um booleano referente a consulta de um tema especificado em 'buscaTema'
   dentro na matriz de resumos. O tema é buscado na coluna [x][0] da  matriz.
   *
   * @param buscaTema tema especifico a ser procurado dentro da matriz
   * @return retorna um valor booleano caso aja ou não o tema procurado.
   */
  public boolean temResumo(String buscaTema){
    boolean validacao = false;
    for (int i = 0; i < this.conta(); i++){
      if (buscaTema.equals(this.resumos[i][0])){
        validacao = true;
      }
    }

    return validacao;
  }
  
}
