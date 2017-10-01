package exercicios.exercicios03;

public class Vendedor extends Empregado{
	private float valorVendas;
	private float comissao;

	public Vendedor(String nome, String endereco, String telefone,
			int codigoSetor, float salarioBase, float imposto,
			float valorVendas, float comissao) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		this.valorVendas = valorVendas;
		this.comissao = comissao;
	}

	public float calcularSalario() {
		return super.calcularSalario() + (valorVendas * comissao / 100);
	}

	public float getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return super.toString() + "\nOperario [valorVendas=" + valorVendas
				+ ", comissao=" + comissao + "]";
	}
}
