package br.senai.sc.teste;

import br.senai.sc.array.*;

public class TesteAdicionaPorPosicao {

	public static void main(String[] args) {
		Produto p1 = new Produto("Vassoura", 20);
		Produto p2 = new Produto("Chinelo", 60);
		Produto p3 = new Produto("Mochila", 99.9);
		Vetor lista = new Vetor();
		lista.adiciona(p1);
		lista.adiciona(0, p2);
		lista.adiciona(1, p3);
		System.out.println(lista);
	}

}
