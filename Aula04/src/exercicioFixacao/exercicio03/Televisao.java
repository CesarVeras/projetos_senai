package exercicioFixacao.exercicio03;

public class Televisao {

	private String marca;
	private int polegadas;
	private int canalAtual;
	private boolean ligada;

	public Televisao() {
	}

	public Televisao(String marca, int polegadas, int canalAtual, boolean ligada) {
		this.marca = marca;
		this.polegadas = polegadas;
		this.canalAtual = canalAtual;
		this.ligada = ligada;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPolegadas() {
		return polegadas;
	}

	public void setPolegadas(int polegadas) {
		if (polegadas == 28 || polegadas == 32 || polegadas == 40
				|| polegadas == 42) {
			this.polegadas = polegadas;
		}
	}

	public int getCanalAtual() {
		return canalAtual;
	}

	public void setCanalAtual(int canalAtual) {
		if (isLigada()) {
			this.canalAtual = canalAtual;
		}
	}

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		if (isLigada() != ligada) {
			this.ligada = ligada;
		}
	}
}
