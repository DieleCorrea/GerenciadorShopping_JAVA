public class Loja
{
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
//CONSTRUTORES
    public Loja(String nome,int quantidadeFuncionarios,double salarioBaseFuncionario){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    public Loja(String nome,int quantidadeFuncionarios){
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
    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    @Override
    public String toString() {
        return "Loja{" +
                "nome='" + nome + '\'' +
                ", quantidadeFuncionarios=" + quantidadeFuncionarios +
                ", salarioBaseFuncionario=" + salarioBaseFuncionario +
                '}';
    }

//METODOS DOS EXERCICIOS

    public double gastosComSalario(){
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
}
