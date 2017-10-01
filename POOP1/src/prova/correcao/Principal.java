package prova.correcao;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.Random;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private static final long serialVersionUID = 1L;

	private Nave nave;
	private Inimigo[] inimigos;
	private Random random;
	private int velocidadeInimigos;
	private int contadorInimigos;
	private int pontuacao;
	private Chefe[] chefes;
	private Image background;
	private boolean instrucoes;

	public Principal() {
		addMouseListener(new MouseInputHandler());
		addKeyListener(new KeyInputHandler());
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}

	public void init() {
		nave = new Nave();
		inimigos = new Inimigo[100];
		chefes = new Chefe[100];
		random = new Random();
		velocidadeInimigos = 4;
		contadorInimigos = 0;
		background = carregarImagem("images/espaco.jpg");
		instrucoes = true;
		pontuacao = 0;
//		nave.setVidas(0);
	}

	public void gameLoop() {
		desenharImagem(background, 0, 0);
		instrucoes();
		if (nave.getVidas() > 0) {
			gerenciarNave();
			spawnInimigo();
			gerenciarInimigo();
			gerenciarBoss();

			desenharString("VIDAS: " + nave.getVidas(), 40, 40, Color.RED, 40);
			desenharString("PONTUAÇÃO: " + pontuacao, 220, 40, Color.BLUE, 40);
		} else {
			desenharString("VOCÊ PERDEU", Utils.getInstance().getWidth() / 2 - 200,
					Utils.getInstance().getHeight() / 2 - 60, Color.RED, 60);
			desenharString("Pressione R para recomeçar", Utils.getInstance().getWidth() / 2 - 320,
					Utils.getInstance().getHeight() / 2 + 60, Color.WHITE, 50);
			desenharString("Sua pontuação: " + pontuacao, Utils.getInstance().getWidth() / 2 - 200,
					Utils.getInstance().getHeight() / 2, Color.BLUE, 50);
		}
	}

	public void aposTermino() {
		System.exit(0);
	}

	private void instrucoes() {
		if (instrucoes) {
			JOptionPane.showMessageDialog(null,
					"Instruções: " + "\nMovimentação: setas" + "\nAtirar: Espaço" + "\nRecomeçar: R" + "\nSair: ESC");
			instrucoes = false;
		}
	}

	private void gerenciarNave() {
		nave.draw(getGraphics2D());
		nave.update();
		for (int i = 0; i < chefes.length; i++) {
			if (chefes[i] != null) {
				nave.colisao(chefes[i].getTiros());
			}
		}
	}

	private void spawnBoss() {
		for (int i = 0; i < chefes.length; i++) {
			if (chefes[i] == null) {
				chefes[i] = new Chefe();
				break;
			}
		}
	}

	private void gerenciarBoss() {
		for (int i = 0; i < chefes.length; i++) {
			if (chefes[i] != null) {
				chefes[i].draw(getGraphics2D());
				chefes[i].update();
				chefes[i].atirar();
				chefes[i].colisao();
				if (chefes[i].colisao(nave.getTiros())) {
					chefes[i] = null;
					pontuacao += 100;
				}
			}
		}
	}

	private void gerenciarInimigo() {
		for (int i = 0; i < inimigos.length; i++) {
			if (inimigos[i] != null) {
				inimigos[i].draw(getGraphics2D());
				inimigos[i].update();
				if (inimigos[i].colisao() || inimigos[i].colisao(nave) || inimigos[i].colisao(nave.getTiros())) {
					inimigos[i] = null;
					pontuacao += 10;
				}
			}
		}
	}

	private void spawnInimigo() {
		int sorteio = random.nextInt(101);
		if (sorteio < 20) {
			for (int i = 0; i < inimigos.length; i++) {
				if (inimigos[i] == null) {
					inimigos[i] = new Inimigo(velocidadeInimigos);
					contadorInimigos++;
					if (contadorInimigos == 40) {
						velocidadeInimigos++;
						contadorInimigos = 0;
						spawnBoss();
					}
					break;
				}
			}
		}
	}

	public class MouseInputHandler extends MouseAdapter {

	}

	public class KeyInputHandler extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_UP) {
				nave.setUpPressed(true);
			} else if (e.getKeyCode() == e.VK_DOWN) {
				nave.setDownPressed(true);
			}

			if (e.getKeyCode() == e.VK_LEFT) {
				nave.setLeftPressed(true);
			} else if (e.getKeyCode() == e.VK_RIGHT) {
				nave.setRightPressed(true);
			}

			if (e.getKeyCode() == e.VK_SPACE) {
				nave.atirar();
			}

			if (e.getKeyCode() == e.VK_R && nave.getVidas() < 1) {
				init();
			}

			if (e.getKeyCode() == e.VK_ESCAPE) {
				System.exit(0);
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == e.VK_UP) {
				nave.setUpPressed(false);
			} else if (e.getKeyCode() == e.VK_DOWN) {
				nave.setDownPressed(false);
			}

			if (e.getKeyCode() == e.VK_LEFT) {
				nave.setLeftPressed(false);
			} else if (e.getKeyCode() == e.VK_RIGHT) {
				nave.setRightPressed(false);
			}
		}
	}
}
