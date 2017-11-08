package br.senai.sc.LinkedList;

public class ListaLigada {
	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;
	
	public ListaLigada() {
		totalDeElementos = 0;
	}

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
		primeira = nova;
		if (totalDeElementos == 0) {
			ultima = primeira;
		}
		totalDeElementos++;
	}
	
	public void adicionaNoFim(Object elemento) {
		if (totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			ultima.setProximoElemento(nova);
			ultima = nova;
			ultima = nova;
			totalDeElementos++;
		}
	}
	
	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) {
			adicionaNoComeco(elemento);
		} else if (posicao == totalDeElementos) {
			adicionaNoFim(elemento);
		} else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula nova = new Celula(elemento, anterior.getProximoElemento());
			anterior.setProximoElemento(nova);
			totalDeElementos++;
		}
	}

	public Object pega(int posicao) {
		return null;
	}

	public void remove(int posicao) {
	}

	public int tamanho() {
		return totalDeElementos;
	}

	public boolean contem(Object o) {
		return false;
	}

	public void removeDoFim() {
	}

	private Celula pegaCelula(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximoElemento();
		}
		return atual;
	}

	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	public String toString() {
		StringBuilder texto = new StringBuilder();
		Celula atual = primeira;
		texto.append("[");
		while(atual.getProximoElemento() != null) {
			texto.append(atual.getElemento());
			atual = atual.getProximoElemento();
			texto.append(",");
		}
		texto.append(atual.getElemento());
		texto.append("]");
		return texto.toString();
	}
}
