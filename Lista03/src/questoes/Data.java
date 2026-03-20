package questoes;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
        if (ano < 1) {
            throw new IllegalArgumentException("Ano inválido: " + ano);
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido: " + mes);
        }
        int maxDias = diasNoMes(mes, ano);
        if (dia < 1 || dia > maxDias) {
            throw new IllegalArgumentException(
                "Dia inválido: " + dia + " para " + mes + "/" + ano +
                " (máximo: " + maxDias + ")"
            );
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
	
	private static int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return eBissexto(ano) ? 29 : 28;
            default: return 0;
        }
    }
	
	private static boolean eBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
	
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
    
    public void avancar() {
        dia++;
        if (dia > diasNoMes(mes, ano)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                ano++;
            }
        }
    }
    
    public boolean eMaisAntiga(Data outra) {
        if (this.ano != outra.ano) return this.ano < outra.ano;
        if (this.mes != outra.mes) return this.mes < outra.mes;
        return this.dia < outra.dia;
    }

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
    
}
