public class Informatica  extends Loja{
   private double seguroEletronicos;

    public Informatica(String nome, int quantidadeFuncionarios, int salarioBaseFuncionario, Endereco endereco, Data dataFundacao, double seguroEletronicos, int qtdMaxProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao,qtdMaxProdutos);
        this.seguroEletronicos = seguroEletronicos;
    }
    public Informatica(String nome, int quantidadeFuncionarios, double seguroEletronicos) {
        super(nome, quantidadeFuncionarios);
        this.seguroEletronicos = seguroEletronicos;
    }

    @Override
    public String toString() {
        return super.toString() + "Informatica{" + "seguroEletronicos=" + seguroEletronicos + '}';
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }
    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }

}