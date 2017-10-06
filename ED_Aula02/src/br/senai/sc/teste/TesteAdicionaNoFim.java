package br.senai.sc.teste;

import br.senai.sc.aluno.*;

public class TesteAdicionaNoFim {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("José");
		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.adiciona(new Aluno("Pedro"));
		System.out.println(lista);
	}
}
