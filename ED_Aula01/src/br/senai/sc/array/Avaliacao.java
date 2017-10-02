package br.senai.sc.array;

public class Avaliacao {
	public static void main(String[] args) {
		// String[] alunos = {"João", "Maria", "Pedro"};
		// float[] notas = {10f, 8.5f, 7.8f};
		//
		// for (int i = 0; i < notas.length; i++) {
		// System.out.println(alunos[i] + ": " + notas[i]);
		// }
		Aluno[] alunos = { 
				new Aluno("João", 10f), 
				new Aluno("Maria", 8.5f), 
				new Aluno("Pedro", 7.8f),
				};
		
		for (int i = 0; i < alunos.length; i++) {
			System.out.println(alunos[i].getNome() + ": " + alunos[i].getNota());
		}
	}
}
