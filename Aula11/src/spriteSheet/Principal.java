package spriteSheet;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private static final long serialVersionUID = 1L;
	private Personagem sonic;
	private boolean wasLeft;

	@Override
	public void init() {
		wasLeft = false;
		sonic = new Personagem(Utils.getInstance().getWidth() / 2 - 119 / 2,
				Utils.getInstance().getHeight() / 2 - 111 / 2, 119, 111, 0, 0, "imagem/sonic.png");

	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(),
				new Color(69, 125, 160, 255));
		desenharRetangulo(0, Utils.getInstance().getHeight() / 2 - 111 / 2 + sonic.getHeight() - 18,
				Utils.getInstance().getWidth(), 800, new Color(150, 209, 83, 255));
		desenharRetangulo(0, Utils.getInstance().getHeight() / 2 - 111 / 2 + sonic.getHeight() + 10						,
				Utils.getInstance().getWidth(), 800, new Color(89, 66, 28, 255));
		getGraphics2D().setColor(new Color(69, 125, 160, 255));
		getGraphics2D().fillOval(0, (Utils.getInstance().getHeight() / 2 - 111 / 2 + sonic.getHeight() + 50),
				Utils.getInstance().getWidth(), 800);
		sonic.draw(getGraphics2D());
		sonic.update(wasLeft);
	}

	@Override
	public void aposTermino() {

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
		}
	}
}
