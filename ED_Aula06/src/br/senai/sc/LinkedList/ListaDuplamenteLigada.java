package br.senai.sc.LinkedList;

public class ListaDuplamenteLigada {
	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	public ListaDuplamenteLigada() {
		totalDeElementos = 0;
	}

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
		if(totalDeElementos > 0) {
			primeira.setAnterior(nova);
		}
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
			nova.setAnterior(ultima);
			ultima.setProximoElemento(nova);
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
			Celula anterior = ultima.getAnterior();
			Celula nova = new Celula(elemento, anterior.getProximoElemento());
			anterior.setProximoElemento(nova);
			totalDeElementos++;
		}
	}

	public Object pega(int posicao) {
		return pegaCelula(posicao).getElemento();
	}

	public void removeDoComeco() {
		if (!posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (totalDeElementos > 1) {
			primeira.getProximoElemento().setAnterior(null);
		}
		primeira = primeira.getProximoElemento();
		totalDeElementos--;
		if (totalDeElementos == 0) {
			ultima = null;
		}
	}

	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProximoElemento();
			Celula proxima = atual.getProximoElemento();
			anterior.setProximoElemento(proxima);
			proxima.setAnterior(anterior);
			this.totalDeElementos--;
		}
	}
	
	public void removeDoFim() {
		if(!posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (totalDeElementos == 1) {
			removeDoComeco();
		} else {
			Celula penultima = ultima.getAnterior(); 
			penultima.setProximoElemento(null);
			this.ultima = penultima;
			this.totalDeElementos--;
		}
	}

	public int tamanho() {
		return totalDeElementos;
	}

	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProximoElemento();
		}
		return false;

	}


	private Celula pegaCelula(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (posicao == 0) {
			return primeira;
		}
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximoElemento();
		}
		return atual;
	}
	
	public Celula pegarCelula(int posicao) {
		return pegaCelula(posicao);
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	public String toString() {
		if (totalDeElementos == 0) {
			return "[]";
		}
		StringBuilder texto = new StringBuilder();
		Celula atual = primeira;
		texto.append("[");
		while (atual.getProximoElemento() != null) {
			texto.append(atual.getElemento());
			atual = atual.getProximoElemento();
			texto.append(",");
		}
		texto.append(atual.getElemento());
		texto.append("]");
		return texto.toString();
	}
}
