package br.senai.sc.aluno;

public class Vetor {
	private static final String MENSAGEM_POSICAO_INVALIDA = "Posição Inválida!";
	private int tamanho;
	private Aluno[] alunos;
	
	public Vetor() {
		tamanho = 0;
		alunos = new Aluno[100];
	}
	
	public void garantaEspaco() {
		if (tamanho() == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length*2];
			for (int i = 0; i < alunos.length; i++) {
				novoArray[i] = alunos[i];
			}
			alunos = novoArray;
		}
	}
	
	public void adiciona(Aluno aluno) {
		garantaEspaco();
		alunos[tamanho] = aluno;
		tamanho++;
	}
	public void adiciona(int posicao, Aluno aluno) { 
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		garantaEspaco();
		for (int i = tamanho() - 1; i >= posicao; i--) {
			alunos[i + 1] = alunos[i];
		}
		alunos[posicao] = aluno;
		tamanho++;
	}
	public Aluno pega(int posicao) { 
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		return alunos[posicao];
	} 
	public void remove(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException(MENSAGEM_POSICAO_INVALIDA);
		}
		for (int i = posicao; i < tamanho - 1; i++) {
			alunos[i] = alunos[i+1];
		}
		tamanho--;
		alunos[tamanho()] = null;
	}
	public boolean contem(Aluno aluno) { 
		boolean contem = false;
		for (int i = 0; i < tamanho ; i++) {
			if (alunos[i].equals(aluno)) {
				contem = true;
				break;
			}
		}
		return contem;
	}
	public int tamanho() {
		return tamanho;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < tamanho;
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= tamanho;
	}
	
	@Override
	public String toString() {
		if (tamanho == 0) {
			return "[]";
		}
		StringBuilder saida = new StringBuilder();
		saida.append("[");
		for (int i = 0; i < tamanho(); i++) {
			if (alunos[i] != null) {
				saida.append(alunos[i].toString());
				if (i != tamanho() - 1) {
					saida.append(", ");
				}
			}
		}
		saida.append("]");
		return saida.toString();
	}	
}
