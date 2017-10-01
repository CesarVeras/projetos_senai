package exercicios.corrida;

public class Motor {
	private double potencia;
	private double velocidadeMaxima;
	private String tipoCombustivel;
	private double valor;
	
	public Motor() {
	}

	public Motor(double potencia, double velocidadeMaxima,
			String tipoCombustivel, double valor) {
		this.potencia = potencia;
		this.velocidadeMaxima = velocidadeMaxima;
		this.tipoCombustivel = tipoCombustivel;
		this.valor = valor;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String toString() {
		return "Motor [potencia=" + potencia + ", velocidadeMaxima="
				+ velocidadeMaxima + ", tipoCombustivel=" + tipoCombustivel
				+ ", valor=" + valor + "]";
	}
}
