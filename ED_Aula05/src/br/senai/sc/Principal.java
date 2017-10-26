package br.senai.sc;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		JogoDosNumeros jogo = new JogoDosNumeros(JOptionPane.showInputDialog("Informe seu nome:"));
		while (jogo.getTentativas() != 0) {
			jogo.gerarNumero();
			if (jogo.getDificuldade().equalsIgnoreCase("a")) {
				jogo.responder(Integer.valueOf(JOptionPane
						.showInputDialog("Tentativas: " + jogo.getTentativas() + "\nPontos: " + jogo.getPontuacao()
								+ "\nInforme um número de 0 a 19 \n" + jogo.getNumeroGerado(jogo.getNivel() - 1))));
			} else {
				jogo.responder(Integer.valueOf(JOptionPane
						.showInputDialog("Tentativas: " + jogo.getTentativas() + "\nPontos: " + jogo.getPontuacao()
						+ "\nInforme um número de 0 a 9 \n" + jogo.getNumeroGerado(jogo.getNivel() - 1))));
			}
		}
		JOptionPane.showMessageDialog(null, "Você perdeu!");
	}
}
