package exercicios.corrida;

public class Pista {
	private String nome;
	private double distancia;
	private String cidade;
	private int capacidadeCarros;
	
	public Pista() {
	}

	public Pista(String nome, double distancia, String cidade,
			int capacidadeCarros) {
		this.nome = nome;
		this.distancia = distancia;
		this.cidade = cidade;
		this.capacidadeCarros = capacidadeCarros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCapacidadeCarros() {
		return capacidadeCarros;
	}

	public void setCapacidadeCarros(int capacidadeCarros) {
		this.capacidadeCarros = capacidadeCarros;
	}

	public String toString() {
		return "Pista [nome=" + nome + ", distancia=" + distancia + ", cidade="
				+ cidade + ", capacidadeCarros=" + capacidadeCarros + "]";
	}
}
