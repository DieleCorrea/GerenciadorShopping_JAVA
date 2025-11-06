public class Bijuteria extends Loja{
    private double metaVendas;

    public Bijuteria(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double metaVendas, int qtdMaxProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, qtdMaxProdutos);
        this.metaVendas = metaVendas;
    }

    public Bijuteria(String nome, int quantidadeFuncionarios, double metaVendas) {
        super(nome, quantidadeFuncionarios);
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String toString() {
        return super.toString() + "Bijuteria{" + "metaVendas=" + metaVendas + '}';
    }
}
