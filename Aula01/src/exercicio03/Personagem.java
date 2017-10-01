package exercicio03;

import java.util.Scanner;

public class Personagem {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Informe o nome:");
		String nome = input.nextLine();
		
		System.out.println("\nInforme o level:");
		short level = input.nextShort();
		
		System.out.println("\nInforme a posição no eixo X:");
		float posicaoX = input.nextFloat();
		
		System.out.println("\nInforme a posição no eixo Y:");
		float posicaoY = input.nextFloat();
		
		System.out.println("\nInforme o life:");
		byte life = input.nextByte();
		
		System.out.println("Nome: " + nome 
				+ "\nLevel: " + level 
				+ "\nPosição X: " + posicaoX 
				+ "\nPosição Y: " + posicaoY 
				+ "\nLife: " + life);
	}

}
