package exercicios.corrida;

public class Modelo {
	private String nome;
	private int quantidadePortas;
	private double valor;
	private int anoModelo;
	private Marca marca;
	
	public Modelo() {
	}

	public Modelo(String nome, int quantidadePortas, double valor,
			int anoModelo, Marca marca) {
		this.nome = nome;
		this.quantidadePortas = quantidadePortas;
		this.valor = valor;
		this.anoModelo = anoModelo;
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(int quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String toString() {
		return "Modelo [nome=" + nome + ", quantidadePortas="
				+ quantidadePortas + ", valor=" + valor + ", anoModelo="
				+ anoModelo + ", marca=" + marca + "]";
	}
}
