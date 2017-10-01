package jogo;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Pong extends Game {

	private static final long serialVersionUID = 1L;
	private boolean ganhou;
	private boolean perdeu;
	private boolean menu;

	private int sair;

	private Barra barraEsquerda;
	private Barra barraDireita;

	private Bola2 bola;
	
	private Jogador p1;
	private Jogador p2;

	private Object[] respostas;

	public Pong() {
		addMouseListener(new MouseControl());
		addKeyListener(new KeyControl());
	}

	public static void main(String[] args) {
		Pong jogo = new Pong();
		jogo.startGame();
	}

	public void init() {
		respostas = new Object[] { "Sim", "Não" };
		menu = false;

		barraEsquerda = new Barra(40, 100, 100, 20, 10);
		barraEsquerda.setPosicaoY(Utils.getInstance().getHeight() / 2
				- barraEsquerda.getPosicaoY() / 2);

		barraDireita = new Barra(this.getWidth() - 60, 100, 100, 20, 10);
		barraDireita.setPosicaoY(Utils.getInstance().getHeight() / 2
				- barraDireita.getPosicaoY() / 2);

		bola = new Bola2(10, 10);
		
		p1 = new Jogador("P1");
		p2 = new Jogador("P2");

	}

	public void gameLoop() {
		if (menu) {
			// Em menu

		} else {
			// Em jogo
			if (!ganhou && !perdeu) {
				// jogando
				desenharRetangulo(0, 0, this.getWidth(), this.getHeight(),
						Color.BLACK);
				barraEsquerda.draw(getGraphics2D());
				barraDireita.draw(getGraphics2D());
				bola.draw(getGraphics2D());
				barraEsquerda.update();
				barraDireita.update();
				bola.draw(getGraphics2D());
				bola.update();
				bola.colisao(p1, p2);
				bola.colisao(barraEsquerda);
				bola.colisao(barraDireita);
				desenharString(p1.getNome(), Utils.getInstance().getWidth()/4 - 20, 200, Color.GREEN, 40);
				desenharString(String.valueOf(p1.getPontos()), Utils.getInstance().getWidth()/4 - 20, 250);
				
			} else if (ganhou) {
				desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.BLACK);

			} else {
				// perdeu
			}
		}

	}

	public void aposTermino() {
	}

	public class MouseControl extends MouseAdapter {
		public void MousePressed(MouseEvent e) {
			if (menu) {
				// Em menu
			} else {
				// Em jogo

			}
		}
	}

	public class KeyControl extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				sair = JOptionPane.showOptionDialog(null,
						"Deseja realmente sair?", "Sair", 0, 3, null,
						respostas, respostas[1]);
				if (sair == 0) {
					System.exit(0);
				}
			}

			if (menu) {
				// Em menu
			} else {
				// Em jogo
				if (e.getKeyCode() == KeyEvent.VK_W) {
					barraEsquerda.setSubir(true);
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					barraEsquerda.setDescer(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					barraDireita.setSubir(true);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					barraDireita.setDescer(true);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				barraEsquerda.setSubir(false);
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				barraEsquerda.setDescer(false);
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				barraDireita.setSubir(false);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				barraDireita.setDescer(false);
			}
		}
	}
}
