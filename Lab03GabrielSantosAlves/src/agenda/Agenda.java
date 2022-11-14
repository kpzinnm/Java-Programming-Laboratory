package agenda;

import java.util.Scanner;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 *
 * @author nazareno
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 101;

	private Contato[] contatos; // array contendo objetos de tipo contato

	private Contato[] favoritos; // array contendo os contatos favoritos

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}

	/**
	 * Acessa a lista de contatos mantida.
	 *
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() { return this.contatos.clone(); }

	/**
	 * Acessa a lista de contatos favoritos
	 *
	 * @return O array de contatos favoritos
	 * */
	public Contato[] getFavoritos() { return this.favoritos.clone(); }

	/**
	 * Acessa os dados de um contato específico.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		Contato saida = null;
		if (temContato(posicao)){
			saida =  contatos[posicao];
		}

		return saida;
	}

	/**
	 * Verifica se o nome completo existe dentro da agenda
	 *
	 * @param nome do contato
	 * @param sobrenome do contato
	 * @return retorna se existe ou não o contato na agenda
	 * */
	public boolean temNomesAgenda(String nome, String sobrenome){
		boolean saida = false;
		for (int i = 0; i < contatos.length; i++) {
			String nomeCompleto = nome + " " + sobrenome;
			if(contatos[i] != null && nomeCompleto.equals(contatos[i].nomeCompleto())){
				saida = true;
			}
		}
		return saida;
	}

	/**
	 * Verifica se o contato possado existe na agenda
	 *
	 * @param posicao posição do contato na agenda a ser verificado
	 * @return retorna true caso a aperação seja realizada
	 * */
	public boolean temContato(int posicao){
		boolean validacao = false;
		if ((posicao > 0 && posicao <= contatos.length) && contatos[posicao] != null){
			validacao = true;

		}

		return validacao;
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 *
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return retorna true caso a aperação seja realizada 
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		boolean saida = false;
		
		if (posicao <= 0 || posicao > 100) {
			System.out.println("\nPosição inválida");
		}
		else if (nome == null || nome == "" || telefone == null || telefone == "") {
			System.out.println("\nContato invalido!");
		}
		else if (temNomesAgenda(nome, sobrenome)) {
			System.out.println("\nContato ja cadastrado");
		}
		else {
			this.contatos[posicao] = new Contato(nome,sobrenome, telefone);
			saida = true;
		}
		
		return saida;
	}

	/**
	 * Cadastra um contato da agenda no array de favoritos
	 *
	 * @param contato objeto contendo o contato
	 * @param posicao da lista de favoritos onde o contato vai ser registrado
	 * @return retorna true caso a aperação seja realizada
	 * */
	public boolean cadastraFavorito(Contato contato, int posicao, int posContato){
		boolean saida = false;
		
		if ((posicao > 0 && posicao <=10) && temContato(posContato)){
			this.favoritos[posicao] = contato;
			contato.setFavorito(true);
			saida = true;
		}
		else {
			System.out.println("Posição ou contato inválido");
		}
		
		
		return saida;
	}

	/**
	 * Remove um contato da lista de favoritos
	 *
	 * @param posicao no array de favoritos onde o contato se encontra*
	 * @return retorna true caso a aperação seja realizada
	 */
	public boolean removeFavorito(int posicao){
		boolean saida = false;
		
		if ((posicao > 0 && posicao <=10) && (favoritos[posicao] != null)) {
			this.favoritos[posicao].setFavorito(false);
			this.favoritos[posicao] = null;	
			saida = true;
		}
		else {
			System.out.println("Posição ou contato inválido");
		}
		
		return saida;
		
	}

}
