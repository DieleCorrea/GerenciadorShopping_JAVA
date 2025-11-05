import java.util.Arrays;

public class Loja
{
    private String nome;
    private int quantidadeFuncionarios;
    private int salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

   public Loja(String nome, int quantidadeFuncionarios,
               int salarioBaseFuncionario,
               Endereco endereco, Data dataFundacao,int qtdMaxima ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[qtdMaxima];

    }
    public Loja(String nome, int quantidadeFuncionarios){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
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
    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }
    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    @Override
    public String toString() {
        String infoProdutos = "";
        if (estoqueProdutos != null) {
            infoProdutos = "\n- Estoque de produtos (" + estoqueProdutos.length + " espaços):";
            for (Produto produto : estoqueProdutos) {
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
       if(estoqueProdutos != null || estoqueProdutos.length == 0 ){
           System.out.println("Opa, identificado que não existe estoque ou " +
                   "que a quantidade máxima de produtos para o estoque da loja foi" +
                   " setada como '0'");
       }
       boolean temProduto = false;
       for(Produto produto : estoqueProdutos){
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
        for (int i = 0; i < estoqueProdutos.length ; i++) {
            if(estoqueProdutos[i] == null){
                estoqueProdutos[i] = produto;
                System.out.println("Produto inserido no estoque");
                return true;
            }
        }
        System.out.println("Estoque cheio");
        return false;
    }
    public boolean removeProduto(String nomeProduto){
        for (int i = 0; i < estoqueProdutos.length; i++) {
            Produto produto = estoqueProdutos[1];
            if (produto != null && produto.getNome().equalsIgnoreCase(nomeProduto)){
                estoqueProdutos[i] = null;
                System.out.printf("Produto removido");
                return true;
            }
        }
        System.out.println("Produto " + nomeProduto + "não encontrado");
        return false;
    }
}
