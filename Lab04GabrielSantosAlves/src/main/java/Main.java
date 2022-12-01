import java.util.Scanner;

/**
 * Classe principal do sistema, responsavel pela I/O(Entrada e Saida)
 *
 * @author Gabriel Santos Alves
 * */
public class Main {

    /**
     * Método principal
     * */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Sistema sistema = new Sistema();


        while (controleMenu(input, sistema)) {}
    }

    /**
     * Monta um menu, e recebe uma "string" que representa a escolha ferente ao menu
     *
     * @param input objeto do tipo Scanner
     * @return "string" digitada pelo usuário
     * */
    private static String menu(Scanner input) {
        System.out.print("\n" +
                "(C)adastrar Aluno\n" +
                "(E)xibir Aluno\n" +
                "(N)ovo Grupo\n" +
                "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                "(O)lhaí quais Grupos o Aluno Tá.\n" +
                "(S)im, quero Fechar o Programa!\n" +
                "\n" +
                "Opção> ");
        String entrada = input.nextLine().toUpperCase();

        return entrada;
    }

    /**
     * Controla as ações do menu
     *
     * @param input objeto do tipo Scanner
     * @param sistema objeto do tipo Sistema
     * */
    private static boolean controleMenu(Scanner input, Sistema sistema) {
        boolean validacao = true;

        switch (menu(input)) {
            case "C":
                cadastraAluno(sistema);
                break;
            case "E":
                exibeAluno(sistema);
                break;
            case "N":
                cadastraGrupo(sistema);
                break;
            case "A":
                alocarAlunos(sistema);
                break;
            case "O":
                checaGrupo(sistema);
                break;
            case "S":
                System.out.println("Adeus, e obrigado pelos peixes!\uD83D\uDC2C");
                validacao = false;
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }

        return validacao;
    }

    /**
     * Gerência o método de cadastro de aluno da classe de sistema
     *
     * @param sistema objeto do tipo Sistema
     * */
    private static void cadastraAluno(Sistema sistema){
        if(sistema.cadastrarAluno(entradaString("Matrícula"), entradaString("Nome"), entradaString("Curso"))){
            System.out.println("CADASTRO REALIZADO!");
        } else {
            System.out.println("MATRICULA JÁ CADASTRADO!");
        }
    }

    /**
     * Gerência e printa o método de exibição do aluno da classe sistema
     *
     * @param sistema objeto do tipo Sistema
     * */
    private static void exibeAluno(Sistema sistema){
        System.out.println(sistema.exibirAluno(entradaString("Matrícula")));
    }

    /**
     * Gerência o cadastro de aluno, usando o método da classe sistema
     *
     * @param sistema obejeto do tipo Sistema
     * */
    private static void cadastraGrupo(Sistema sistema){
        if(sistema.criarGrupo(entradaString("Nome"), entradaString("Tamanho"))){
            System.out.println("CADASTRADO REALIZADO!\n");
        } else {
            System.out.println("GRUPO JÁ CADASTRADO!\n");
        }
    }

    /**
     * Gerência a alocação de aluno em grupos e faz a verificação da pertinência de um aluno em um grupo
     *
     * @param sistema objeto do tipo Sistema
     * */
    private static void alocarAlunos(Sistema sistema){
        String opcao = entradaString("(A)locar Aluno ou (P)ertinência a Grupo? ").toUpperCase();
        if(opcao.equals("A")){
            String retorno = sistema.adiconaAlunoGrupo(entradaString("Matricula"), entradaString("Grupo"));
            System.out.println(retorno);
        }

        else if (opcao.equals("P")) {
            String retorno = sistema.pertinenciaGrupo(entradaString("Matricula"), entradaString("Grupo"));
            System.out.println(retorno);
        }
    }

    private static void checaGrupo(Sistema sistema){
        System.out.println(sistema.checaGrupoAluno(entradaString("Matricula")));
    }

    /**
     * Exibe uma mensagem de requisição de informação e recebe uma "string"
     *
     * @param mensagem de requisição da informação
     * @return "string" digitada pelo usuário
     * */
    private static String entradaString(String mensagem){
        Scanner input = new Scanner(System.in);
        System.out.print(mensagem + ": ");

        return input.nextLine();
    }

}