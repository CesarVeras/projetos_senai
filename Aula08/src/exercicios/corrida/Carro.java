package exercicios.corrida;

public class Carro {
	private String cor;
	private double valorTotal;
	private int anoFabricacao;
	private int numero;
	private Motor motor;
	private Modelo modelo;

	public Carro() {
	}

	public Carro(String cor, double valorTotal, int anoFabricacao, int numero,
			Motor motor, Modelo modelo) {
		this.cor = cor;
		this.valorTotal = valorTotal;
		this.anoFabricacao = anoFabricacao;
		this.numero = numero;
		this.motor = motor;
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal() {
		this.valorTotal = motor.getValor() + modelo.getValor();
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return "Carro [cor=" + cor + ", valorTotal=" + valorTotal
				+ ", anoFabricacao=" + anoFabricacao + ", numero=" + numero
				+ ", motor=" + motor + ", modelo=" + modelo + "]";
	}
}
