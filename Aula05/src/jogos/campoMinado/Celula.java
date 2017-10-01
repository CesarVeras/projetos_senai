package jogos.campoMinado;

public class Celula {
	private boolean vidara;

	private int posicaoX;
	private int posicaoY;
	private int numero;
	private int altura;
	private int alturaTela;
	private int largura;
	private int larguraTela;

	public Celula() {
	}

	public Celula(int posicaoX, int posicaoY) {
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
	}

	public Celula(int posicaoX, int posicaoY, int numero) {
		this(posicaoX, posicaoY);
		setNumero(numero);
	}

	public Celula(int posicaoX, int posicaoY, int numero, int altura,
			int largura) {
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
		setNumero(numero);
		setAltura(altura);
		setLargura(largura);
	}

	public Celula(int posicaoX, int posicaoY, int numero, int altura,
			int largura, int alturaTela, int larguraTela) {
		setAlturaTela(alturaTela);
		setLarguraTela(larguraTela);
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
		setNumero(numero);
		setAltura(altura);
		setLargura(largura);
	}
	
	public boolean foiClicada(int x, int y) {
		return ((x >= posicaoX && x <= posicaoX + largura) 
				&& (y >= posicaoY && y <= posicaoY + altura));
	}
	
	public void virarCelula() {
		setVidara(!isVidara());
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		if (posicaoX >= 0 && posicaoX <= larguraTela) {
			this.posicaoX = posicaoX;			
		}
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		if (posicaoY >= 0 && posicaoY <= alturaTela) {
			this.posicaoY = posicaoY;
		}
	}

	public boolean isVidara() {
		return vidara;
	}

	public void setVidara(boolean vidara) {
		this.vidara = vidara;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAlturaTela() {
		return alturaTela;
	}

	public void setAlturaTela(int alturaTela) {
		this.alturaTela = alturaTela;
	}

	public int getLarguraTela() {
		return larguraTela;
	}

	public void setLarguraTela(int larguraTela) {
		this.larguraTela = larguraTela;
	}
}
