package exercicios.exercicio01;

public class Ingresso {
	
	protected float valor;
	
	public Ingresso() {
	}
	
	public Ingresso(float valor) {
		this.valor = valor;
	}
	
	public void imprimeValor() {
		System.out.println("Valor do ingresso: R$" + valor);
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
