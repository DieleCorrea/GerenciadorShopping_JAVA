import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
   private static final Scanner scanner = new Scanner(System.in);

    private static  int opt;
    public static void main(String[] args) {
        mostraMenu();
//        testeShopping();
        scanner.close();
    }

    private static void mostraMenu(){
        do {
            System.out.println("---GERENCIAR O SHOPPING---");
            System.out.println("1- Criar uma loja");
            System.out.println("2- Criar um produto");
            System.out.println("3- Mostrar loja criada e produtos pertencentes");
            System.out.println("3- SAIR");
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    Loja.criarLoja();
                    break;
                case 2:
                    Loja.criarProduto();
                    break;
                case 3:
                    Loja.mostrarDadosLoja();
                    break;
                case 4:
                    System.out.println("Volte sempre!\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (opt != 4);
    }

    public static void testeShopping() {
        //Criar o endereço do shopping
        Endereco enderecoShopping = new Endereco(
                "Av. Central", "Porto Alegre", "RS",
                "Brasil", "90560-000", "1000", "Próximo ao parque"
        );

        //Criar o shopping com capacidade para 5 lojas
        Shopping shopping = new Shopping("Shopping das Estrelas", enderecoShopping, 5);

        //Criar datas para fundação e alvarás
        Data dataFundacao1 = new Data(1, 2, 2020);
        Data dataFundacao2 = new Data(15, 3, 2019);
        Data dataFundacao3 = new Data(10, 8, 2021);
        Data dataFundacao4 = new Data(25, 12, 2022);
        Data dataAlvara = new Data(20, 8, 2021);

        //Criar lojas de tipos diferentes (usando os construtores reais)
        Loja loja1 = new Informatica("TechMaster", 10, 3000, enderecoShopping, dataFundacao1, 15000.0, 20);
        Loja loja2 = new Vestuario("FashionUp", 5, 2500, enderecoShopping, dataFundacao2, true, 15);
        Loja loja3 = new Alimentacao("Delícia Express", 8, 2200, enderecoShopping, dataFundacao3, dataAlvara, 10);
        Loja loja4 = new Cosmetico("Beleza Pura", 6, 2800, enderecoShopping, dataFundacao4, 50.0, 12);
        Loja loja5 = new Cosmetico("Diele cosmeticos", 2, 5000, enderecoShopping, dataFundacao4, 50.0, 12);

        //Inserir lojas no shopping
        shopping.insereLoja(loja1);
        shopping.insereLoja(loja2);
        shopping.insereLoja(loja3);
        shopping.insereLoja(loja4);
        shopping.insereLoja(loja5);

        //Mostrar informações gerais do shopping
        System.out.println("=== INFORMAÇÕES DO SHOPPING ===");
        System.out.println(shopping);

        //Testar método quantidadeLojasPorTipo
        System.out.println("\n=== QUANTIDADE DE LOJAS POR TIPO ===");
        System.out.println("Informática: " + shopping.quantidadeLojasPorTipo("Informatica"));
        System.out.println("Vestuário: " + shopping.quantidadeLojasPorTipo("Vestuario"));
        System.out.println("Alimentação: " + shopping.quantidadeLojasPorTipo("Alimentacao"));
        System.out.println("Cosmético: " + shopping.quantidadeLojasPorTipo("Cosmetico"));

        //Testar método lojaSeguroMaisCaro
        System.out.println("\n=== LOJA COM SEGURO MAIS CARO ===");
        Informatica lojaMaisCara = shopping.lojaSeguroMaisCaro();
        if (lojaMaisCara != null) {
            System.out.println("Loja: " + lojaMaisCara.getNome() +
                    " | Seguro: R$ " + lojaMaisCara.getSeguroEletronicos());
        } else {
            System.out.println("Nenhuma loja de informática encontrada.");
        }

        // Testar remoção de loja
        System.out.println("\n=== REMOVENDO LOJA 'FashionUp' ===");
        boolean removida = shopping.removeLoja("FashionUp");
        System.out.println(removida ? "Loja removida com sucesso!" : "Não foi possível remover a loja.");

        // Mostrar lista de lojas restantes
//        System.out.println("\nLojas restantes: " + Arrays.toString(shopping.getLojas()));
        System.out.println("\nDados shopping com lojas restantes\n" + shopping);
    }


}


