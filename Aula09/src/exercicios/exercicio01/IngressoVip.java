package exercicios.exercicio01;

public class IngressoVip extends Ingresso {

	private float valorAdicional;
	
	public IngressoVip() {
		super();
	}
	
	public IngressoVip(float valor, float valorAdicional) {
		super(valor);
		this.valorAdicional = valorAdicional;
	}

	public void imprimeValor() {
		System.out.println("Valor do Ingresso VIP: R$" + valorFinal());
	}
	
	public float valorFinal() {
		return (valor + valorAdicional);
	}
	
	public float getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(float valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
}
