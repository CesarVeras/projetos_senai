package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaDuplamenteLigada;

public class TesteAdicionaNoFim {
	public static void main(String[] args) {
		ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
		lista.adicionaNoFim("Rafael");
		lista.adicionaNoFim("Paulo");
		System.out.println(lista);
	}
}
