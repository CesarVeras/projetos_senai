package br.senai.sc.teste;

import br.senai.sc.aluno.*;

public class TesteAdicionaNoFim {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Jo�o");
		Aluno a2 = new Aluno("Jos�");
		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.adiciona(a2);
		System.out.println(lista);
	}
}
