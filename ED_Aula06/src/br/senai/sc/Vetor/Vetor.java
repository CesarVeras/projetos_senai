package br.senai.sc.Vetor;

import java.util.ArrayList;
import java.util.List;

public class Vetor {
	private List<Aluno> alunos;
	
	public Vetor() {
		alunos = new ArrayList<Aluno>();
	}

	public void adiciona(int posicao, Aluno aluno) {
		alunos.add(posicao, aluno);
	}

	public Aluno pega(int posicao) {
		return alunos.get(posicao);
	}

	public void remove(int posicao) {
		alunos.remove(posicao);
	}

	public boolean contem(Aluno aluno) {
		return alunos.contains(aluno);
	}

	public int tamanho() {
		return alunos.size();
	}
}
