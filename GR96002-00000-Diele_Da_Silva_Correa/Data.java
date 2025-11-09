public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        // Validar a data
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! Definindo data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    private boolean validarData(int dia, int mes, int ano) {
        // Verificar se o mês é válido
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Verificar se o dia é válido
        if (dia < 1) {
            return false;
        }

        // Verificar o número máximo de dias por mês
        int diasNoMes = obterDiasNoMes(mes, ano);
        return dia <= diasNoMes;
    }
    private int obterDiasNoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Fevereiro: 29 dias se bissexto, 28 caso contrário
                return verificaAnoBissexto(ano) ? 29 : 28;
            default:
                return 0;
        }
    }
    public boolean verificaAnoBissexto() {
        return verificaAnoBissexto(this.ano);
    }
    private boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", dia, mes, ano);
    }

    // Getters e Setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}