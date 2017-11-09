package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteRemovePorPosicao {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		lista.adicionaNoComeco("Camila");
		lista.remove(1);
		System.out.println(lista);
	}
}

