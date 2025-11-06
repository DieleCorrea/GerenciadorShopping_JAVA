public class Loja
{
    private String nome;
    private int quantidadeFuncionarios;
    private int salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] produtos;

   public Loja(String nome, int quantidadeFuncionarios,
               int salarioBaseFuncionario,
               Endereco endereco, Data dataFundacao,int qtdMaxima ) {
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
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

//GETERS E SETER
    public String getNome() {
        return nome;
    }
    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }
    public int getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
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
        String infoProdutos = "";
        if (produtos != null) {
            infoProdutos = "\n- Estoque de produtos (" + produtos.length + " espaços):";
            for (Produto produto : produtos) {
                if (produto != null) {
                    infoProdutos += "\n   * " + produto;
                }
            }
        }
        return "Loja{" +
                "nome='" + nome + '\'' +
                ", quantidadeFuncionarios=" + quantidadeFuncionarios +
                ", salarioBaseFuncionario=" + salarioBaseFuncionario +
                ", endereco=" + endereco +
                ", dataFundacao=" + dataFundacao +
                infoProdutos+ '}';
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
       if(quantidadeFuncionarios > 10) {
       return 'p';
       }else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30){
           return 'M';
       }else{
           return 'G';
       }
    }
    public void imprimeProdutos(){
       if(produtos != null || produtos.length == 0 ){
           System.out.println("Opa, identificado que não existe estoque ou " +
                   "que a quantidade máxima de produtos para o estoque da loja foi" +
                   " setada como '0'");
       }
       boolean temProduto = false;
       for(Produto produto : produtos){
           if (produto != null) {
               System.out.println(produto);
           temProduto = true;
           }
       }
       if (!temProduto){
           System.out.println("Estoque vazio");
       }
    }
    public boolean insereProduto(Produto produto){
        for (int i = 0; i < produtos.length ; i++) {
            if(produtos[i] == null){
                produtos[i] = produto;
                System.out.println("Produto inserido no estoque");
                return true;
            }
        }
        System.out.println("Estoque cheio");
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
}
