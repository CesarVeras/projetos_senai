package aula01.exercicio01;
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
		System.out.println("Posi��o X: " + posicaoX);
		System.out.println("Posi��o Y: " + posicaoY);
		System.out.println("N�mero: " + numero);
		System.out.println("Para cima: " + paraCima + "\n");
	}
}
