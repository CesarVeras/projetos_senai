package br.senai.sc.aluno;

import java.util.Arrays;

public class Vetor {
	private int tamanho;
	private Aluno[] alunos;
	
	public Vetor() {
		tamanho = 0;
		alunos = new Aluno[100];
	}
	
	public void adiciona(Aluno aluno) { 
		alunos[tamanho] = aluno;
		tamanho++;
	}
	public void adiciona(int posicao, Aluno aluno) { 
		if (posicao <= alunos.length) {
			if (alunos[posicao] != null) {
				adiciona(alunos[posicao]);
				alunos[posicao] = aluno;
			} else {
				alunos[posicao] = aluno;
				tamanho++;
			}
		}
	}
	public Aluno pega(int posicao) { 
		if (posicao <= alunos.length && alunos[posicao] != null) {
			return alunos[posicao];
		}
		return null;
	} 
	public void remove(int posicao) {
		if (posicao <= alunos.length) {
			if (alunos[posicao] != null) {
				for (int i = posicao	; i < tamanho - 1; i++) {
					alunos[i] = alunos[i+1];
				}
			}
			tamanho--;
		}
	}
	public boolean contem(Aluno aluno) { 
		if (aluno != null) {
			for (int i = 0; i < alunos.length; i++) {
				if (alunos[i] != null && alunos[i].equals(aluno)) {
					return true;
				}
			}
		}
		return false;
	}
	public int tamanho() {
		return tamanho;
	}
	
	@Override
	public String toString() {
		String saida = "[";
		for (int i = 0; i < tamanho(); i++) {
			if (alunos[i] != null) {
				saida += alunos[i].toString();
				if (i != tamanho() - 1) {
					saida +=  ", ";
				}
			}
		}
		saida+="]";
		return saida;
	}	
}
