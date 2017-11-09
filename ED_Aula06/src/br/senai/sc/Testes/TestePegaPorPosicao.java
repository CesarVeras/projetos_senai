package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TestePegaPorPosicao {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Paulo");
		lista.adicionaNoComeco("Rafael");
		System.out.println(lista.pega(0));
		System.out.println(lista.pega(1));
	}
}

