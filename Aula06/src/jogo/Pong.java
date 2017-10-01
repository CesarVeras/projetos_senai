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

	private Bola bola;

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

		bola = new Bola(Utils.getInstance().getWidth() / 2, Utils.getInstance()
				.getHeight() / 2, 50, 50, 10, 10);
		bola.setGoingRight(true);
		bola.setGoingUp(true);

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
				bola.update(barraEsquerda, barraDireita);
				desenharString(String.valueOf(bola.getPontosP1()), (Utils
						.getInstance().getWidth() / 2) / 2, 150, Color.GREEN,
						60);
				desenharString(String.valueOf(bola.getPontosP2()),
						Utils.getInstance().getWidth()/2 + (Utils.getInstance().getWidth()/2)/2, 150);
				desenharRetangulo(Utils.getInstance().getWidth() / 2 - 7, 0,
						15, Utils.getInstance().getHeight(), Color.GREEN);
				if (bola.getPontosP1() == 10) {
					ganhou = true;
				}
				if (bola.getPontosP2() == 10) {
					ganhou = true;
				}
			} else if (ganhou) {
				desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.BLACK);
				if (bola.getPontosP1() == 10) {
					desenharString("Player 1 venceu!", (Utils
							.getInstance().getWidth() / 2) / 2, 150, Color.GREEN,
							40);
					finalizarJogo();
				} else {
					desenharString("Player 2 venceu!", (Utils
							.getInstance().getWidth() / 2) / 2, 150, Color.GREEN,
							40);
					finalizarJogo();
				}
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
