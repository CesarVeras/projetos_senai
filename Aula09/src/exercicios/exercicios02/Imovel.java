package exercicios.exercicios02;

public class Imovel {

	protected String endereco;
	protected float preco;
	
	public Imovel() {
	}

	public Imovel(String endereco, float preco) {
		this.endereco = endereco;
		this.preco = preco;
	}
	
	public  float valorFinal() {
		return preco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
