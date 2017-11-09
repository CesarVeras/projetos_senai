package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteAdicionaNoComeco {
	public static void main(String[] args) {

		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista.toString());
	}
}

