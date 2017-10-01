package exercicios.exercicio01;

public class CamaroteInferior extends IngressoVip {

	private String localizacao;

	public CamaroteInferior() {
		super();
	}

	public CamaroteInferior(float valor, float valorAdicional,
			String localizacao) {
		super(valor, valorAdicional);
		this.localizacao = localizacao;
	}
	
	public void imprimirLocalizacao() {
		System.out.println("Localização: " + localizacao);
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
