package br.senai.sc.array;

public class MediaPorAluno {

	public static void main(String[] args) {
		String[] nomes = { "João", "Maria", "Pedro" };
		double[][] notas = { { 10, 8, 9 }, { 7, 5, 6 }, { 8.5, 9.5, 7.5 } };
		double[] medias = new double[notas[0].length];

		for (int i = 0; i < notas.length; i++) {
			double soma = 0;
			for (int j = 0; j < notas[i].length; j++) {
				soma += notas[i][j];
			}
			medias[i] = soma/medias.length;
			System.out.println("Média de " + nomes[i] + ": " + soma / notas[i].length);
		}
	}
}
