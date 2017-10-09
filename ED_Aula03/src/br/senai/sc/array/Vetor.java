package br.senai.sc.array;

public class Vetor {

	private Object[] objetos;

	private int totalDeObjetos;
	
	public Vetor() {
		objetos = new Object[100];
		totalDeObjetos = 0;
	}

	private static final String MENSAGEM_POSICAO_INVALIDA = "A posição é inválida";

	public void adiciona(Object objeto) {
		this.garantaEspaco();
		this.objetos[this.totalDeObjetos] = objeto;
		this.totalDeObjetos++;
	}

	public void adiciona(int posicao, Object objeto) {
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		for (int i = this.totalDeObjetos - 1; i >= posicao; i -= 1) {
			this.objetos[i + 1] = this.objetos[i];
		}
		this.objetos[posicao] = objeto;
		this.totalDeObjetos++;
	}

	public Object pega(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		return objetos[posicao];
	}

	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		for (int i = posicao; i < this.totalDeObjetos - 1; i++) {
			this.objetos[i] = this.objetos[i + 1];
		}
		this.totalDeObjetos--;
	}

	public boolean contem(Object objeto) {
		boolean contem = false;
		for (int i = 0; i < totalDeObjetos; i++) {
			if (objeto.equals(objetos[i])) {
				contem = true;
				break;
			}
		}
		return contem;
	}

	private void garantaEspaco() {
		if (this.totalDeObjetos == this.objetos.length) {
			Object[] novoArray = new Object[this.objetos.length * 2];
			for (int i = 0; i < this.objetos.length; i++) {
				novoArray[i] = this.objetos[i];
			}
			this.objetos = novoArray;
		}
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeObjetos;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeObjetos;
	}

	public int tamanho() {
		return totalDeObjetos;
	}

	@Override
	public String toString() {
		if (this.totalDeObjetos == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < this.totalDeObjetos - 1; i++) {
			builder.append(this.objetos[i]);
			builder.append(", ");
		}
		builder.append(this.objetos[this.totalDeObjetos - 1]);
		builder.append("]");
		return builder.toString();

	}

	public String conventionalToString() {
		if (this.totalDeObjetos == 0) {
			return "[]";
		}
		String retorno = new String();
		retorno = "[";
		for (int i = 0; i < this.totalDeObjetos - 1; i++) {
			retorno += objetos[i];
			retorno += ", ";
		}
		retorno += this.objetos[this.totalDeObjetos - 1];
		retorno += "]";
		return retorno;
	}
}
