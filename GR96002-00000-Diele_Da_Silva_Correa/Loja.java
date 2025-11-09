import java.time.LocalDate;
import java.util.Scanner;
public class Loja
{
    private String nome;
    private int quantidadeFuncionarios;
    private int salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] produtos;
    public static Loja lojaCriada;
    public static Produto produtoCriado;
    private static final Scanner scanner = new Scanner(System.in);


    public Loja(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, Data dataFundacao,int qtdMaxima ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.produtos = new Produto[qtdMaxima];

    }
    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
    }
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int salarioBaseFuncionario) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.salarioBaseFuncionario = -1;
        this.produtos = new Produto[5];
    }

//GETERS E SETER
    public String getNome() {
        return nome;
    }
    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    public void setSalarioBaseFuncionario(int salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    public int getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }
    public Data getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Produto[] getProdutos() {
        return produtos;
    }
    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n==============================")
                .append("\n🏬 INFORMAÇÕES DA LOJA")
                .append("\n==============================")
                .append("\n📛 Nome: ").append(nome)
                .append("\n👥 Funcionários: ").append(quantidadeFuncionarios)
                .append("\n💰 Salário base: ").append(salarioBaseFuncionario)
                .append("\n📍 Endereço: ").append(endereco)
                .append("\n📅 Fundação: ").append(dataFundacao);

        if (produtos != null) {
            sb.append("\n📦 Capacidade do estoque: ").append(produtos.length).append(" produtos");
        }

        return sb.toString();
    }

    //METODOS DOS EXERCICIO
    public int gastosComSalario(){
        if(salarioBaseFuncionario != -1){
            return  quantidadeFuncionarios * salarioBaseFuncionario;
        }else{
            return -1;
        }
    }
    public char tamanhoDaLoja(){
       if(quantidadeFuncionarios < 10) {
       return 'P';
       }else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30){
           return 'M';
       }else{
           return 'G';
       }
    }
    public void imprimeProdutos(){
       boolean temProduto = false;
       for(Produto produto : produtos){
           if (produto != null) {
               System.out.println(produto);
           temProduto = true;
           }
       }
    }
    public static void criarLoja() {
        if(lojaCriada != null){
            System.out.println("Loja ja criada");
        }else{
            //scanner.nextLine();
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
    }

    public boolean insereProduto(Produto produto){
    for (int i = 0; i < produtos.length ; i++) {
        if(produtos[i] == null){
            produtos[i] = produto;
            System.out.println("-> Produto inserido no estoque");
            return true;
        }
    }
    System.out.println("--> ATENÇÃO: Estoque cheio\n");
    return false;
}
    public boolean verificarEspacoEstoque(){
        for (Produto produto : produtos) {
            if (produto == null) {
                return true;
            }
        }
        return false;
    }
    public boolean removeProduto(String nomeProduto){
        for (int i = 0; i < produtos.length; i++) {
            Produto produto = produtos[i];
            if (produto != null && produto.getNome().equalsIgnoreCase(nomeProduto)){
                produtos[i] = null;
                System.out.printf("Produto removido");
                return true;
            }
        }
        System.out.println("Produto " + nomeProduto + "não encontrado");
        return false;
    }
    public static void criarProduto(){
        if(lojaCriada == null){
            System.out.println("AVISO: Para criar um produto, precisa criar uma loja antes\n\n");
        }else {
            if (lojaCriada.verificarEspacoEstoque()) {
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
                produtoCriado = new Produto(nomeProduto, precoProduto, dataValidade);
                lojaCriada.insereProduto(produtoCriado);
                Data dataTeste = new Data(20,10,2023);
                if (produtoCriado.estaVencido(dataTeste)){
                    System.out.println("-> PRODUTO VENCIDO");
                }else{
                    System.out.println("-> PRODUTO NÃO VENCIDO");
                }
                System.out.println("Produto criado com sucesso!\n");
            }else{
                System.out.println("ATENÇÃO: Estoque cheio!\n");
            }
        }
    }

    public static Endereco criarEnderecoLoja(){
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
    public static void mostrarDadosLoja(){
        if(lojaCriada != null ){
            System.out.println(lojaCriada.toString());
            System.out.printf("GASTOS COM SALARIO:" + lojaCriada.gastosComSalario() + "\n");
            System.out.println("PRODUTO(S): ");
            lojaCriada.imprimeProdutos();
            System.out.println();
        }else{
            System.out.println("Nenhuma loja criada ate o momento");
        }
    }
}
