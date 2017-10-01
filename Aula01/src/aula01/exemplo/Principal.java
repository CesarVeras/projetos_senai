package aula01.exemplo;

public class Principal {
	
	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		
		pessoa1.nome = "Felipe";
		pessoa1.cpf = "111.111.111-11";
		pessoa1.idade = 20;
		pessoa1.telefone = "11111-1111";
		pessoa1.email = "felipe@hotmail.com";
		pessoa1.imprimirDados();
		
		pessoa2.nome = "Karol";
		pessoa2.cpf = "222.222.222-22";
		pessoa2.idade = 16;
		pessoa2.telefone = "22222-2222";
		pessoa2.email = "karoleta@hotmail.com";
		pessoa2.imprimirDados();
		
		
		
	}
	
}
