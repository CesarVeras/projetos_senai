package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteRemoveDoFim {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		lista.removeDoFim();

		System.out.println(lista);
	}
}
