package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteContemElemento {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista.contem("Rafael"));
		System.out.println(lista.contem("Camila"));
	}
}

