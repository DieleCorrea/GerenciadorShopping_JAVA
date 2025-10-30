public class Produto {
    private String nome;
    private double preco;
    private Data data;
//CONTRUTOR
    public Produto(String nome, double preco, Data data) {
        this.nome = nome;
        this.preco = preco;
        this.data = data;
    }
//ACESSO E TOSTRING
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
 //VALIDAÇÕES
    public boolean estaVencido(Data dataProduto){
        if(dataProduto. > Data)
        return true;
    }
}
