package aula02.exercicio01;

public class Carta {
	public int posicaoX;
	public int posicaoY;
	public int numero;
	public boolean paraCima;

	public void virarCarta() {
		paraCima = !paraCima;
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
}
