package exercicios.exercicios02;

public class ImovelNovo extends Imovel{

	protected float precoAdicional;

	public ImovelNovo(float valorAdicional) {
		super();
	}

	public ImovelNovo(String endereco, float preco, float precoAdicional) {
		super(endereco, preco);
		this.precoAdicional = precoAdicional;
	}
	
	public float valorFinal() {
		return (preco + precoAdicional);
	}

	public float getPrecoAdicional() {
		return precoAdicional;
	}

	public void setPrecoAdicional(float precoAdicional) {
		this.precoAdicional = precoAdicional;
	}
}
