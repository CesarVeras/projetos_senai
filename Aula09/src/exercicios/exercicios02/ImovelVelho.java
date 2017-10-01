package exercicios.exercicios02;

public class ImovelVelho extends Imovel{
	
	protected float desconto;

	public ImovelVelho() {
		super();
	}

	public ImovelVelho(String endereco, float preco, float desconto) {
		super(endereco, preco);
		this.desconto = desconto;
	}

	public float valorFinal() {
		return (preco - desconto);
	}
	
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
}
