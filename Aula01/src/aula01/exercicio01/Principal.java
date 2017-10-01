package aula01.exercicio01;

public class Principal {
	
	public static void main(String[] args) {
		
		Carta c1 = new Carta();
		Carta c2 = new Carta();
		
		c1.posicaoX = 10;
		c1.posicaoY = 10;
		c1.numero = 1;
		c1.imprimirDados();
		
		c2.posicaoX = 60;
		c2.posicaoY = 10;
		c2.numero = 1;
		c2.imprimirDados();
	}
	
}
