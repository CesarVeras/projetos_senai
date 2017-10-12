package spriteSheet.correcaoProfessor;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private static final long serialVersionUID = 1L;
	private boolean onMenu;
	private boolean onGame;
	private boolean onPause;
	private Personagem sonic;
	private Chao chao;
	private InimigoNoChao inimigoNoChao;
	private Esfera estrela;
	private Cubo cubo;
	private TelaEstatica menu;
	private TelaEstatica pause;

	public Principal() {
		addKeyListener(new KeyInputHandler());
		addMouseListener(new MouseInputHandler());
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}

	public void init() {
		menu = new TelaEstatica("Sonic Saiyan", 60, new Color(123, 126, 132,
				255),
				new Botao[] {
						new Botao("Jogar",
								Utils.getInstance().getWidth() / 2 - 150, Utils
										.getInstance().getHeight() / 2 - 120,
								300, 100, 60),
						new Botao("Sair",
								Utils.getInstance().getWidth() / 2 - 150, Utils
										.getInstance().getHeight() / 2, 300,
								100, 60) });

		pause = new TelaEstatica("Jogo Pausado", 60, new Color(123, 126, 132,
				255),
				new Botao[] {
						new Botao("Retomar",
								Utils.getInstance().getWidth() / 2 - 150, Utils
										.getInstance().getHeight() / 2 - 120,
								300, 100, 60),
						new Botao("Menu",
								Utils.getInstance().getWidth() / 2 - 150, Utils
										.getInstance().getHeight() / 2, 300,
								100, 60) });

		sonic = new Personagem();
		chao = new Chao();
		inimigoNoChao = new InimigoNoChao(Utils.getInstance().getWidth() / 2,
				Utils.getInstance().getHeight() - chao.getHeight() - 119, 112,
				119, 10);
		sonic.setWasLeft(false);
		estrela = new Esfera();
		cubo = new Cubo();
		onMenu = true;
		onGame = false;
		onPause = false;
	}

	public void gameLoop() {
		if (onMenu) {
			menu.draw(getGraphics2D());
		} else if (onGame) {
			desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils
					.getInstance().getHeight(), Color.BLACK);
			gerenciarCubo();
			gerenciarEstrela();
			gerenciarSonic();
			chao.draw(getGraphics2D());

			gerenciarInimigoNoChao();
		} else {
			pause.draw(getGraphics2D());
		}
	}

	public void aposTermino() {

	}

	public void gerenciarSonic() {
		sonic.draw(getGraphics2D());
		sonic.update();
		sonic.colisao(chao);
		if (inimigoNoChao != null) {
			sonic.colisao(inimigoNoChao);
		}
	}

	public void gerenciarCubo() {
		cubo.draw(getGraphics2D());
		cubo.update();
		cubo.colisao(chao);
		cubo.colisao(sonic);
		if (cubo.isColetado()) {
			sonic.coletouPowerUp(null);
		}
	}

	public void gerenciarEstrela() {
		estrela.draw(getGraphics2D());
		estrela.update();
		estrela.colisao(chao);
		estrela.colisao(sonic);
		if (!cubo.isColetado() && estrela.isColetado()) {
			sonic.coletouPowerUp(estrela);
		}
	}

	public void gerenciarInimigoNoChao() {
		if (sonic.getPisou()) {
			inimigoNoChao = null;
		}
		if (inimigoNoChao != null) {
			inimigoNoChao.draw(getGraphics2D());
			inimigoNoChao.update();
			inimigoNoChao.colisao(sonic);
		}
	}

	public class MouseInputHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (onMenu) {
				if (menu.getBotao(0).isPressed(e.getX(), e.getY())) {
					onMenu = false;
					onGame = true;
				}
				if (menu.getBotao(1).isPressed(e.getX(), e.getY())) {
					System.exit(0);
				}
			}
			
			if (onPause) {
				if (pause.getBotao(0).isPressed(e.getX(), e.getY())) {
					onPause = false;
					onGame = true;
				}
				if (pause.getBotao(1).isPressed(e.getX(), e.getY())) {
					init();
				}
			}
		}
	}

	public class KeyInputHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (onGame) {
				if (e.getKeyCode() == e.VK_LEFT) {
					sonic.setLeftPressed(true);
				}
				
				if (e.getKeyCode() == e.VK_RIGHT) {
					sonic.setRightPressed(true);
				}
				
				if (e.getKeyCode() == e.VK_UP) {
					sonic.setPulando(true);
				}
				
				if (e.getKeyCode() == e.VK_SPACE) {
					onGame = false;
					onPause = true;
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (onGame) {
				if (e.getKeyCode() == e.VK_LEFT) {
					sonic.setLeftPressed(false);
					sonic.setWasLeft(true);
				}
				
				if (e.getKeyCode() == e.VK_RIGHT) {
					sonic.setRightPressed(false);
					sonic.setWasLeft(false);
				}
			}
			if (e.getKeyCode() == e.VK_ESCAPE) {
				System.exit(0);
			}
		}
	}
}
