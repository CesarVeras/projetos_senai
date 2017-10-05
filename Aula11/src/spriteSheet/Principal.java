package spriteSheet;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.spec.EncodedKeySpec;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private static final long serialVersionUID = 1L;
	private Personagem sonic;
	private boolean wasLeft;
	private Chao chao;

	@Override
	public void init() {
		wasLeft = false;
		sonic = new Personagem(Utils.getInstance().getWidth() / 2 - 119 / 2, 290, 119, 111, 0, 0, "imagem/sonic.png");
		chao = new Chao(0, Utils.getInstance().getHeight() / 2, Utils.getInstance().getWidth(), 800, null, 0, 0);
	}

	@Override
	public void gameLoop() {
		desenharCenario();
		chao.draw(getGraphics2D());
		sonic.draw(getGraphics2D());
		sonic.update(wasLeft);
		controlarGravidade();
	}

	@Override
	public void aposTermino() {
	}

	public void controlarGravidade() {
		if (!sonic.colisao(chao) && !sonic.isJumping()) {
			sonic.setY(sonic.getY() + 30);
		}
	}

	public void desenharCenario() {
		desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(),
				new Color(69, 125, 160, 255));
	}

	public Principal() {
		addKeyListener(new KeyInputHandler());
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.startGame();
	}

	public class KeyInputHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_LEFT) {
				sonic.setLeftPressed(true);
			}

			if (e.getKeyCode() == e.VK_RIGHT) {
				sonic.setRightPressed(true);
			}

			if (e.getKeyCode() == e.VK_UP) {
				if (sonic.estaNoChao()) {
					sonic.setJumping(true);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == e.VK_LEFT) {
				sonic.setLeftPressed(false);
				wasLeft = true;
			}

			if (e.getKeyCode() == e.VK_RIGHT) {
				sonic.setRightPressed(false);
				wasLeft = false;
			}

			if (e.getKeyCode() == e.VK_ESCAPE) {
				System.exit(0);
			}
		}
	}
}
