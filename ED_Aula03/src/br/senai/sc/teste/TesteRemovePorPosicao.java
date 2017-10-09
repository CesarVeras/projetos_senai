package br.senai.sc.teste;

import br.senai.sc.array.*;

public class TesteRemovePorPosicao {

	public static void main(String[] args) {
		Produto a1 = new Produto("Travesseiro", 200);
		Produto a2 = new Produto("Colchão", 1060);
		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.remove(0);
		System.out.println(lista);
	}

}
