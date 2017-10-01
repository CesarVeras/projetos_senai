package exercicios.corrida;

import java.util.Arrays;

public class Corrida {
	private String nome;
	private Pista pista;
	private Carro[] carros;
	
	public Corrida() {
	}

	public Corrida(String nome, Pista pista, Carro[] carros) {
		this.nome = nome;
		this.pista = pista;
		this.carros = carros;
	}
	
	public void adicionarCarro(Carro carro) {
		//TODO
	}
	
	public void removerCarro(int numero) {
		//TODO
	}
	
	public void listarCarrosParticipantes() {
		//TODO
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public Carro[] getCarros() {
		return carros;
	}
	
	public Carro getCarro(int numero) {
		//TODO
		return null;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}

	@Override
	public String toString() {
		return "Corrida [nome=" + nome + ", pista=" + pista + ", carros="
				+ Arrays.toString(carros) + "]";
	}
}
