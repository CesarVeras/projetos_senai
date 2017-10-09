package br.senai.sc.teste;

import br.senai.sc.array.*;

public class TestePegaPorPosicao {

	public static void main(String[] args) {
		Produto p1 = new Produto("Notebook", 2060);
		Produto p2 = new Produto("Ventilador", 199.9);
		Vetor lista = new Vetor();
		lista.adiciona(p1);
		lista.adiciona(p2);
		Produto produto1 = (Produto)lista.pega(0);
		Produto produto2 = (Produto)lista.pega(1);
		System.out.println(produto1);
		System.out.println(produto2);
		lista.pega(12);
	}

}
