import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.text.Normalizer;
import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int qtdMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[Math.max(qtdMaximaLojas, 0)];
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Loja[] getLojas() {
        return lojas;
    }
    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "Shopping: " + nome +
                "\nEndereço: " + endereco +
                "\nLojas: " + Arrays.toString(lojas);
    }
//METODOS DO EXERCICIO
    public boolean insereLoja(Loja loja){
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null){
                lojas[i] = loja;
                return true;
            }
        }
        System.out.println("Não cabe mais loja");
        return false;
    }
    public boolean removeLoja(String nomeLoja){
        for (int i = 0; i < lojas.length; i++) {
            Loja loja = lojas[i];
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)){
                lojas[i] = null;
                return true;
            }
        }
        System.out.println("Loja " + nomeLoja + " não encontrada!");
        return false;
    }
    public int quantidadeLojasPorTipo(String descricaoTipo){
        if (descricaoTipo == null)return -1;

        String tipo = Normalizer
                .normalize(descricaoTipo, Normalizer.Form.NFD) //
                .replaceAll("\\p{M}", "") //remove acentos
                .toUpperCase() //deixa tudo maiusculo
                .trim(); //limpa espaços
        return switch (tipo){
            case "COSMETICO" -> (int) Arrays.stream(lojas).filter(loja -> loja instanceof Cosmetico).count();
            case "VESTUARIO" -> (int) Arrays.stream(lojas).filter(loja -> loja instanceof Vestuario).count();
            case "BIJUTERIA" -> (int) Arrays.stream(lojas).filter(loja -> loja instanceof Bijuteria).count();
            case "ALIMENTACAO" -> (int) Arrays.stream(lojas).filter(loja -> loja instanceof Alimentacao).count();
            case "INFORMATICA" -> (int) Arrays.stream(lojas).filter(loja -> loja instanceof Informatica).count();
            default -> -1;
        };
    }
    public Informatica lojaSeguroMaisCaro(){
        Informatica lojaMaisCara = null;
        double maiorSeguro = 0;

        for (Loja loja : lojas) {
            if(loja instanceof Informatica informatica){
                if (informatica.getSeguroEletronicos() > maiorSeguro){
                    maiorSeguro = informatica.getSeguroEletronicos();
                    lojaMaisCara = informatica;
                }
            }
        }
        return lojaMaisCara;
    }
}