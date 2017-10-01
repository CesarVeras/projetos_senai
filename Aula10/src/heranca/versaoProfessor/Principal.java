package heranca.versaoProfessor;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private static final long serialVersionUID = 1L;
	private Nave nave;
	private Inimigo[] inimigos;
	private Random random;
	private int countEnemys;
	private Boss boss;
	
	public Principal() {
		addMouseListener(new MouseInputHandler());
		addKeyListener(new KeyInputHandler());
	}
	
	@Override
	public void init() {
		this.nave = new Nave();
		this.inimigos = new Inimigo[200];
		random = new Random();
		countEnemys = 30;
	}
	
	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.BLACK);
		nave.draw(getGraphics2D());
		nave.update();
		if (countEnemys < 40) {
			addInimigo();
		} else if (countEnemys == 40) {
			boss = new Boss();
			countEnemys++;
		} else if (boss != null && boss.getVida() > 0) {
			boss.update();
			boss.draw(getGraphics2D());
			boss.colisao();
			boss.colisao(nave);
			boss.colisao(nave.getTiros());
			nave.colisao(boss.getTiros());
		} else {
			System.out.println("Game Over!");
			finalizarJogo();
		}
		
		for (int i = 0; i < inimigos.length; i++) {
			if (inimigos[i] != null) {
				inimigos[i].update();
				inimigos[i].draw(getGraphics2D());
				
				if (inimigos[i].colisao()) {
					inimigos[i] = null;
				} else if (inimigos[i].colisao(nave) || inimigos[i].colisao(nave.getTiros())) {
					inimigos[i] = null;
					countEnemys++;
				}
			}
		}
		
		desenharString(String.valueOf(countEnemys), Utils.getInstance().getWidth()/2-20, 50, Color.YELLOW, 20);
	}
	
	@Override
	public void aposTermino() {
		
	}
	
	public void addInimigo() {
		if (random.nextInt(20) == 10) {
			for (int i = 0; i < inimigos.length; i++) {
				if (inimigos[i] == null) {
					Inimigo enemy = new Inimigo();
					inimigos[i] = enemy;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}

	private class MouseInputHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			nave.atirar();
		}
	}
	
	private class KeyInputHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_D) {
				nave.setRightLeft(1);
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				nave.setRightLeft(-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				nave.setUpDown(1);
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				nave.setUpDown(-1);
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_D) {
				nave.setRightLeft(0);
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				nave.setRightLeft(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				nave.setUpDown(0);
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				nave.setUpDown(0);
			}
		}
	}
	
}
