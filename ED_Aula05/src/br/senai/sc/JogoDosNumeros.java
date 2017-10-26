package br.senai.sc;

import java.util.Random;

import javax.swing.JOptionPane;

public class JogoDosNumeros {
	
	private int tentativas;
	private int pontuacao;
	private int nivel;
	private String nomeJogador;
	private String dificuldade;
	private int[] numerosGerados;
	
	public JogoDosNumeros(String nome) {
		nivel = 1;
		pontuacao = 0;
		nomeJogador = nome;
		pedirDificuldade();
		numerosGerados = new int[3];
		if (dificuldade.equalsIgnoreCase("a")) {
			tentativas = 5;
		} else {
			tentativas = 3;
		}
	}
	
	private void pedirDificuldade() {
		do {
			dificuldade = JOptionPane.showInputDialog("Informe a dificuldade(A - Avançado/ I - Iniciante:");
		} while (!dificuldade.equalsIgnoreCase("i") && !dificuldade.equalsIgnoreCase("a"));
	}
	
	public void gerarNumero() {
		Random r = new Random();
		if (dificuldade.equalsIgnoreCase("i")) {
			numerosGerados[nivel - 1] = r.nextInt(10);
		} else {
			numerosGerados[nivel - 1] = r.nextInt(20);
		}
	}
	
	public void responder(int numero) {
		if (numero == numerosGerados[nivel - 1]) {
			if (nivel == 3) {
				vencer();
			}
			pontuacao += 10;
			nivel++;
		} else {
			tentativas--;
		}
	}
	
	private void vencer() {
		JOptionPane.showMessageDialog(null, "Você venceu!");
		System.exit(0);
	}
	
	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	public int getNumeroGerado(int posicao) {
		return numerosGerados[posicao];
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int[] getNumerosGerados() {
		return numerosGerados;
	}

	public void setNumerosGerados(int[] numerosGerados) {
		this.numerosGerados = numerosGerados;
	}
}
