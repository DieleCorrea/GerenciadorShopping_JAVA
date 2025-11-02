import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    public static Loja lojaCriada;
    public static Produto produtoCriado;
    private static  int opt;
    public static void main(String[] args) {
        mostraMenu();
        scanner.close();
    }

    private static void mostraMenu(){
        do {
            System.out.println("---GERENCIAR O SHOPPING---");
            System.out.println("1- Criar uma loja");
            System.out.println("2- Criar um produto");
            System.out.println("3- SAIR");
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    criarLoja();
                    break;
                case 2:
                    criarProduto();
                    break;
                case 3:
                    System.out.println("Volte sempre!\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (opt != 3);
    }

    private static void criarLoja() {
        scanner.nextLine();
        System.out.println("Nome da loja\n");
        String nomeLoja = scanner.nextLine();

        System.out.println("Quantidade de funcionários:\n");
        int qtdFunc = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Salário base dos funcionarios:\n");
        double slrBase = scanner.nextDouble();

        //System.out.println("Endereço:\n");
        //scanner.nextLine();

        LocalDate hoje = LocalDate.now();
        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        Data dataFormacao = new Data(dia, mes, ano);

        lojaCriada = new Loja(nomeLoja, qtdFunc, slrBase, null, dataFormacao);
        System.out.println("loja criada com sucesso!\n");
        mostraMenu();
    }

    private static void criarProduto(){
        scanner.nextLine();
        System.out.println("Nome do produto\n");
        String nomeProduto = scanner.nextLine();

        System.out.println("Preço do produto:\n");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Validade (dd/mm/aaaa):\n");
        String validade = scanner.nextLine();
        String[] partes = validade.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        Data dataValidade = new Data(dia, mes, ano);

//        Produto produto = new Produto(nomeProduto, precoProduto,dataValidade);
//        produto.estaVencido(dataValidade);
        produtoCriado = new Produto(nomeProduto, precoProduto,dataValidade);

        if (produtoCriado.estaVencido(dataValidade)){
            System.out.println("PRODUTO VENCIDO");
        }else{
            System.out.println("PRODUTO NÃO VENCIDO");
        }

        System.out.println("Produto criado com sucesso!\n");
        mostraMenu();
    }


}


