package br.senai.sc.teste;

import br.senai.sc.array.*;

public class TesteTamanhoLista {

	public static void main(String[] args) {
		Produto p1 = new Produto("Espelho", 59.9);
		Produto p2 = new Produto("Power bank", 54.9);
		Produto p3 = new Produto("Celular", 1249.9);
		Vetor lista = new Vetor();
		lista.adiciona(p1);
		lista.adiciona(p2);
		System.out.println(lista.tamanho());
		lista.adiciona(p3);
		System.out.println(lista.tamanho());
	}

}
