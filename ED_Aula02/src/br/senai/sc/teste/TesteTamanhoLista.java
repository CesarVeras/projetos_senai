package br.senai.sc.teste;

import br.senai.sc.aluno.Aluno;
import br.senai.sc.aluno.Vetor;

public class TesteTamanhoLista {
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		a1.setNome("Rafael"); 
		a2.setNome("Paulo");
		Vetor lista = new Vetor();
		lista.adiciona(a1); 
		lista.adiciona(a2);
		System.out.println(lista.tamanho()); 
		lista.adiciona(a3);
		System.out.println(lista.tamanho()); 
	} 

}
