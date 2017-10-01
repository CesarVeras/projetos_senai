package aula01.exemplo;

public class Pessoa {
	String nome;
	String cpf;
	int idade;
	String telefone;
	String email;
	
	public void fazerAniversario() {
		idade++;
	}
	
	public int anoDeNascimento(int ano) {
		return (ano - idade);
	}
	
	public void imprimirDados() {
		System.out.println("---------------------");
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("Idade: " + idade);
		System.out.println("Telefone: " + telefone);
		System.out.println("Email: " + email + "\n");
	}
}	
