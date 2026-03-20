package questoes;

public class Calculo {
	public double x;
	public double y;
	
	public Calculo(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
    public void calcular() {
        System.out.println("\n===== Resultados das Operações =====");
        System.out.printf("%.2f + %.2f = %.2f%n",   x, y, x + y);
        System.out.printf("%.2f - %.2f = %.2f%n",   x, y, x - y);
        System.out.printf("%.2f * %.2f = %.2f%n",   x, y, x * y);
 
        if (y != 0) {
            System.out.printf("%.2f / %.2f = %.2f%n", x, y, x / y);
            System.out.printf("%.2f %% %.2f = %.2f%n", x, y, x % y);
            if (x % y == 0) {
                System.out.printf("%.2f é DIVISÍVEL por %.2f%n", x, y);
            } else {
                System.out.printf("%.2f NÃO é divisível por %.2f%n", x, y);
            }
        } else {
            System.out.println("Divisão e resto: impossível (divisão por zero)");
        }
        System.out.println("====================================\n");
    }
 
    public void gerarRaiz() {
        System.out.println("\n===== Raízes =====");
        if (x >= 0) {
            System.out.printf("√%.2f = %.4f%n", x, Math.sqrt(x));
        } else {
            System.out.printf("√%.2f = não existe (número negativo)%n", x);
        }
        if (y >= 0) {
            System.out.printf("√%.2f = %.4f%n", y, Math.sqrt(y));
        } else {
            System.out.printf("√%.2f = não existe (número negativo)%n", y);
        }
        System.out.println("==================\n");
    }
 
    public void gerarPotencia() {
        System.out.println("\n===== Potência =====");
        System.out.printf("%.2f ^ %.2f = %.4f%n", x, y, Math.pow(x, y));
        System.out.println("====================\n");
    }
	
}
