package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 *
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 *
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" +
						"(C)adastrar Contato\n" +
						"(L)istar Contatos\n" +
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar favoritos\n" +
						"(R)emover favoritos\n" +
						"(S)air\n" +
						"\n" +
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 *
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
			case "C":
				cadastraContato(agenda, scanner);
				break;
			case "L":
				listaContatos(agenda);
				break;
			case "E":
				exibeContato(agenda, scanner);
				break;
			case "F":
				exibeFavoritos(agenda);
				break;
			case "A":
				adicionaFavoritos(scanner, agenda);
				break;
			case "R":
				removeFavoritos(scanner, agenda);
				break;
			case "S":
				sai();
				break;
			default:
				System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i].nomeCompleto()));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda.
	 *
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		int posicao = recebeInteiro(scanner, "Qual contato>");
		Contato contato = agenda.getContato(posicao);
		if (contato == null){
			System.out.println("Contato invalido!");
		} else {
			System.out.println(contato.toString());
		}
	}

	/**
	 * Formata um contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda.
	 *
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		int posicao = recebeInteiro(scanner, "Posição na agenda>" );
		String nome = recebeString(scanner, "Nome> ");
		String sobrenome = recebeString(scanner, "Sobrenome> ");
		String telefone = recebeString(scanner, "Telefone> ");

		agenda.cadastraContato(posicao, nome, sobrenome, telefone);	
	}

	/**
	 * Exibe uma lista contendo os contatos favoritos
	 *
	 * @param agenda objeto do tipo agenda
	 * */
	private static void exibeFavoritos(Agenda agenda){
		Contato[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i].nomeCompleto()));
			}
		}
	}

	/**
	 * Adicona um contato da agenda, a lista de favoritos
	 *
	 * @param scanner para pedir posição do contato na agenda
	 * @param agenda objeto contendo agenda*/
	private static void adicionaFavoritos(Scanner scanner, Agenda agenda){
		int contato = recebeInteiro(scanner, "Contato>");
		int posicao = recebeInteiro(scanner, "Posição>");

		agenda.cadastraFavorito(agenda.getContato(contato), posicao, contato);
	}

	/**
	 * Remove um contato da agenda da lista de favoritos
	 *
	 * @param scanner para perdir posição do contato na lista de  favoritos
	 * @param agenda contendo a Agenda*/
	private static void removeFavoritos(Scanner scanner, Agenda agenda){
		int posicao = recebeInteiro(scanner, "Posição>");
		agenda.removeFavorito(posicao);

	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv.
	 *
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();

		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Exibe uma mensagem e recebe uma ‘string’
	 *
	 * @param scanner recebe a string
	 * @param informacaoRequisitada mensagem a ser exibida quando for receber a ‘string’
	 * @return string recebida
	 * */
	private static String recebeString(Scanner scanner, String informacaoRequisitada){
		System.out.print("\n" + informacaoRequisitada + " ");
		String entrada = scanner.nextLine();
		if (entrada.equals("")){
			entrada = null;
		}
		return  entrada;
	}

	/**
	 * Exibe uma mensagem e recebe um número inteiro
	 *
	 * @param scanner recebe o inteiro
	 * @param informacaoRequisitada mensagem a ser exibida quando for receber o inteiro
	 * @return inteiro recebido
	 * */
	private static int recebeInteiro(Scanner scanner, String informacaoRequisitada){
		System.out.print("\n" + informacaoRequisitada + " ");
		int entrada = scanner.nextInt();
		scanner.nextLine();

		return  entrada;
	}
}
