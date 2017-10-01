package exercicio01;

import java.util.Scanner;

public class Pessoa {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Informe o nome:");
		String nome = input.nextLine();
		
		System.out.println("\nInforme a data de nascimento:");
		String dataNascimento = input.nextLine();
		
		System.out.println("\nInforme a idade:");
		int idade = input.nextInt();
		input.nextLine();
		
		System.out.println("\nInforme a profiss„o:");
		String profissao = input.nextLine();
		
		System.out.println("\nInforme o sexo:");
		String sexo = input.nextLine();
		
		System.out.println("\n… maior de idade?");
		boolean maioridade = input.nextBoolean();
		
		System.out.println("Nome: " + nome 
				+ "\nData de Nascimento: " + dataNascimento 
				+ "\nIdade: " + idade 
				+ "\nProfiss„o: " + profissao 
				+ "\nSexo: " + sexo 
				+ "\n… maior de idade?" + maioridade);
	}
}
