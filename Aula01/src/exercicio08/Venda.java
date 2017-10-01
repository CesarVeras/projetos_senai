package exercicio08;

import java.util.Scanner;

public class Venda {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Informe a data da venda:");
		String dataVenda = input.nextLine();
		
		System.out.println("\nInforme o nome do produto:");
		String nomeProduto = input.nextLine();
		
		System.out.println("\nInforme o valor da venda:");
		float valorVenda = input.nextFloat();
		
		System.out.println("\nInforme o vendedor:");
		input.nextLine();
		String vendedor = input.nextLine();
		
		System.out.println("Data da venda: " + dataVenda 
				+ "\nNome do produto: " + nomeProduto 
				+ "\nValor da venda: " + valorVenda 
				+ "\nNome do vendedor: " + vendedor);
	}
}
