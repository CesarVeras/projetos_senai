package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteAdicionaPorPosicao {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		System.out.println(lista);
	}
}
