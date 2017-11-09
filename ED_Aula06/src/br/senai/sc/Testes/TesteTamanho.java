package br.senai.sc.Testes;

import br.senai.sc.LinkedList.ListaLigada;

public class TesteTamanho {
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista.tamanho());
		lista.adicionaNoComeco("Camila");
		System.out.println(lista.tamanho());
	}
}

