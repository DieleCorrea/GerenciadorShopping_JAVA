import java.time.LocalDate;

public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public Data getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
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
                ", data=" + dataValidade +
                '}';
    }

    public boolean estaVencido(Data dataReferencia) {
     LocalDate validade = LocalDate.of(this.dataValidade.getAno(),
             this.dataValidade.getMes(),
             this.dataValidade.getDia());

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
