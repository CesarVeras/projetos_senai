package br.senai.sc.teste;

import br.senai.sc.aluno.*;

public class TesteRemovePorPosicao {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Rafael");
		Aluno a2 = new Aluno("Paulo");
		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.remove(0);
		System.out.println(lista);
	}

}
