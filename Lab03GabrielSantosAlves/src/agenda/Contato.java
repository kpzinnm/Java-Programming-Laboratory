package agenda;


/**
 * O contato que vai ser adicionado a agenda
 *
 * @author Gabriel Santos Alves
 *
 * */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    public Contato(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.favorito = false;
    }

    /**
     * Instancia um nome valor booleano para favorito
     *
     * @param valor booleano que vai determinar se o contato é favorito ou não
     * */
    public void setFavorito(boolean valor) { this.favorito = valor; }

    /**
     * Retorna uma ‘string’ nome completo montado a partir da concatenação do 'nome' com 'sobrenome'
     *
     * @return nome completo do contato
     * */
    public String nomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    /**
     * Método 'toString' sobrescrito, montando uma 'string' a partir do 'nome', 'sobrenome' e 'telefone'.
     * Caso o contato seja favorito, o caractere '❤' é adicionado no incio.
     *
     * @return 'string'  montada
     * */
    @Override
    public String toString(){
        String saida = this.nome + " " + this.sobrenome + "\n" + this.telefone;
        if (favorito){
            saida = "❤️ " + saida;
        }

        return saida;
    }

    /**
     * Método 'hashCode' sobrescrito, usando o 'nomeCompleto()' como novo parâmetro
     *
     * @return código inteiro do 'hashCode'
     * */
    @Override
    public int hashCode(){
        return this.nomeCompleto().hashCode();
    }

    /**
     * Método 'equals' sobrescrito, usando o 'nomeCompleto()' como parâmetro de comparação
     *
     * @return booleano do comparativo dos objetos
     * */
    @Override
    public boolean equals(Object c){
        boolean verificacao = false;
        //verifica se objeto não é nulo
        if (c == null){ return verificacao; }
        //verifica se são da mesma classe
        if (c.getClass() != this.getClass()) { return verificacao; }
        // cria a referência da classe para o objeto
        Contato cContato = (Contato) c;
        // verifica se os atributos reevantes são iguais
        if (this.nomeCompleto().equals(cContato.nomeCompleto())){
            verificacao = true;
        }
        return verificacao;
    }
}

