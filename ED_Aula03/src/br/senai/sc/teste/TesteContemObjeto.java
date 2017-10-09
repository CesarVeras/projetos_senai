package br.senai.sc.teste;

import br.senai.sc.array.*;

public class TesteContemObjeto {

	public static void main(String[] args) {
		Produto p1 = new Produto("Leite", 2.5);
		Produto p2 = new Produto("Sabonete", 3.6);
		Vetor lista = new Vetor();
		lista.adiciona(p1);
		lista.adiciona(p2);
		System.out.println(lista.contem(p1));
		System.out.println(lista.contem(p2));
		String texto = "Palavra";
//		lista.adiciona(texto);s
		System.out.println(lista.contem(texto));
	}

}
