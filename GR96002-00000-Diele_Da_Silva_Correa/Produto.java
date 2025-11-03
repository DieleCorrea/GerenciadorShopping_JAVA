import java.time.LocalDate;

public class Produto {
    private String nome;
    private double preco;
    private Data data;

    public Produto(String nome, double preco, Data data) {
        this.nome = nome;
        this.preco = preco;
        this.data = data;
    }

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

 public boolean estaVencido(Data dataReferencia) {
     LocalDate validade = LocalDate.of(this.data.getAno(),
             this.data.getMes(),
             this.data.getDia());

     LocalDate referencia = LocalDate.of(dataReferencia.getAno(),
             dataReferencia.getMes(),
             dataReferencia.getDia());

     return validade.isBefore(referencia);
 }

//    public boolean estaVencido(Data dataProduto) {
//        LocalDate vencimento = LocalDate.of(dataProduto.getAno(), dataProduto.getMes(), dataProduto.getDia());
//        if (vencimento.isBefore(LocalDate.now())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
