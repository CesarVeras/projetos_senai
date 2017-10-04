package br.senai.sc.teste;
import br.senai.sc.aluno.*;

public class TesteAdicionaPorPosicao {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Rafael");
		Aluno a2 = new Aluno("Paulo");
		Aluno a3 = new Aluno("Ana");
		Vetor lista = new Vetor();
		lista.adiciona(a1); 
		lista.adiciona(0, a2); 
		lista.adiciona(1, a3);
		System.out.println(lista);
	}
}
