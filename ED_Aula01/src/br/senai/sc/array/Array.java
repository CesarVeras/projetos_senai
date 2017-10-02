package br.senai.sc.array;

public class Array {
	 public static void main(String[] args) {
		 try {
			 int[] notas = {10, 8, 7, 9 ,7, 8};
			 System.out.println(notas[3]);
			 
			 int valores[] = {10, 9};
			 System.out.println(valores[1]);
			 
			 int[] numeros = new int[10];
			 System.out.println(numeros[0]);
			 
			 boolean b[] = new boolean[2];
			 
			 byte by[] = new byte[3];
			 
			 for (int i = 0; i < notas.length; i++) {
				System.out.println(notas[i]);
			}
			 
			 
		 } catch (Exception e) {
			 
			 e.printStackTrace();
		 }
	}
}
	