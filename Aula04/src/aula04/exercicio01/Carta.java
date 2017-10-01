package aula04.exercicio01;

public class Carta {
	private int posicaoX;
	private int posicaoY;
	private int numero;
	private boolean paraCima;
	private boolean acertou;
	
	public Carta() {
	}
	
	public Carta(int posicaoX, int posicaoY) {
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
	}
	
	public Carta(int posicaoX, int posicaoY, int numero) {
		this(posicaoX, posicaoY);
		setNumero(numero);
	}
	
	public void imprimirDados() {
		System.out.println("----------------------");
		System.out.println("Posição X: " + posicaoX);
		System.out.println("Posição Y: " + posicaoY);
		System.out.println("Número: " + numero);
		System.out.println("Para cima: " + paraCima + "\n");
	}
	
	public boolean mesmaCarta(Carta c) {
		return (c.posicaoX == posicaoX && c.posicaoY == posicaoY
				&& c.numero == numero && c.paraCima == paraCima);
	}
	
	public boolean numerosIguais(Carta c) {
		return (c.numero == numero);			
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		if (posicaoX > 0 && posicaoX < 330 ) {
			this.posicaoX = posicaoX;
		}
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		if (posicaoY > 0 && posicaoY < 190) {
			this.posicaoY = posicaoY;			
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0 && numero < 15) {
			this.numero = numero;			
		}
	}

	public boolean isParaCima() {
		return paraCima;
	}

	public void setParaCima(boolean paraCima) {
		this.paraCima = paraCima;
	}

	public boolean isAcertou() {
		return acertou;
	}

	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}

	public void virarCarta() {
		paraCima = !paraCima;
	}
}
