public class Alimentacao extends Loja{
    private Data dataAlvara;

    public Alimentacao(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario,
                       Endereco endereco, Data dataFundacao, Data dataAlvara, int qtdMaxProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qtdMaxProdutos);
        this.dataAlvara = dataAlvara;
    }

    public Alimentacao(String nome, int quantidadeFuncionarios, Data dataAlvara) {
        super(nome, quantidadeFuncionarios);
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    @Override
    public String toString() {
        return super.toString() + " Alimentacao{" + "dataAlvara=" + dataAlvara + '}';
    }
}