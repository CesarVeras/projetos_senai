package exercicios.exercicios03;

public class Administrador extends Empregado{
	private float ajudaDeCusto;

	public Administrador(String nome, String endereco, String telefone,
			int codigoSetor, float salarioBase, float imposto,
			float ajudaDeCusto) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		this.ajudaDeCusto = ajudaDeCusto;
	}

	public float calcularSalario() {
		return super.calcularSalario() + ajudaDeCusto;
	}
	
	public float getAjudaDeCusto() {
		return ajudaDeCusto;
	}

	public void setAjudaDeCusto(float ajudaDeCusto) {
		this.ajudaDeCusto = ajudaDeCusto;
	}

	@Override
	public String toString() {
		return super.toString() + "\nAdministrador [ajudaDeCusto=" + ajudaDeCusto + "]";
	}
	
	
}
