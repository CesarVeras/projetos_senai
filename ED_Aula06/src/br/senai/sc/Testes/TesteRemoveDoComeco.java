package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteRemoveDoComeco {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rita");
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista);
		lista.removeDoComeco();
		System.out.println(lista);
		lista.removeDoComeco();
		System.out.println(lista);
		lista.removeDoComeco();
		System.out.println(lista);
//		lista.removeDoComeco();
	}
}

