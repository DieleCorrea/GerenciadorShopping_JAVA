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
            if(lojaCriada != null && produtoCriado != null){
                Data dataTeste = new Data(20,10,2023);
                if (produtoCriado.estaVencido(dataTeste)){
                    System.out.println("PRODUTO VENCIDO");
                }else{
                    System.out.println("PRODUTO NÃO VENCIDO");
                }
                System.out.println("Informações da loja criada: " + lojaCriada.toString() + "\n");
            }
        } while (opt != 3);
    }

    private static void criarLoja() {
        scanner.nextLine();
        System.out.print("Nome da loja: ");
        String nomeLoja = scanner.nextLine();

        System.out.print("Quantidade de funcionários: ");
        int qtdFunc = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Salário base dos funcionarios: ");
        int slrBase = scanner.nextInt();

        System.out.print("Quantidade máxima de produtos no estoque: ");
        int qtdMaxProduto = scanner.nextInt();
        scanner.nextLine();

        scanner.nextLine();
        System.out.println("\n--- Endereço da loja ---");
        Endereco endereco = criarEnderecoLoja();

        LocalDate hoje = LocalDate.now();
        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        Data dataFormacao = new Data(dia, mes, ano);

        lojaCriada = new Loja(nomeLoja, qtdFunc, slrBase, endereco, dataFormacao, qtdMaxProduto);
        System.out.println("loja criada com sucesso!\n");
    }

    private static void criarProduto(){
        scanner.nextLine();
        System.out.print("Nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Validade (dd/mm/aaaa): ");
        String validade = scanner.nextLine();
        String[] partes = validade.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        Data dataValidade = new Data(dia, mes, ano);
        produtoCriado = new Produto(nomeProduto, precoProduto,dataValidade);
        System.out.println("Produto criado com sucesso!\n");
    }

    private static Endereco criarEnderecoLoja(){
        System.out.print("Nome da rua: ");
        String rua = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        return  new Endereco(rua, cidade, estado, pais, cep, numero, complemento);
    }

}


