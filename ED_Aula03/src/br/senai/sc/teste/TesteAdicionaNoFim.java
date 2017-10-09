package br.senai.sc.teste;

import br.senai.sc.array.Produto;
import br.senai.sc.array.Vetor;

public class TesteAdicionaNoFim {

	public static void main(String[] args) {
		Produto p1 = new Produto("Papel", 0.5);
		Produto p2 = new Produto("Tesoura", 4.5);
		Vetor lista = new Vetor();
		lista.adiciona(p1);
		lista.adiciona(p2);
		System.out.println(lista);
	}
}
