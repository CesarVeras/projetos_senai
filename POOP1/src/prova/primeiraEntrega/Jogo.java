package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Jogo extends Game {
	private int velocidadeInimigos;
	private int quantidadeSpawnado;
	private int posicaoChefe;
	
	private Nave jogador;
	private Chefe[] chefes;
	
	private Inimigo[] inimigos;
	private Tiro[] tiros;
	private TiroChefe[] tirosC;
	
	private Image background;
	
	public Jogo() {
		addMouseListener(new MouseInputHandler());
		addKeyListener(new KeyInputHandler());
	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.startGame();
	}

	public void init() {
		background = carregarImagem("images/espaco.jpg");
		jogador = new Nave(40, 40, 5, 5);
		chefes = new Chefe[50];
		
		inimigos = new Inimigo[50];
		tiros = new Tiro[50];
		tirosC = new TiroChefe[50];
		
		quantidadeSpawnado = 0;
		velocidadeInimigos = 5;
	}

	public void gameLoop() {
		desenharImagem(background, 0, 0);
		if (jogador.getVidas() > 0) {
			for (int i = 0; i < inimigos.length; i++) {
				if (inimigos[i] != null) {
					inimigos[i].draw(getGraphics2D());
					inimigos[i].update();
					if(inimigos[i].saiuDaTela()) {
						inimigos[i] = null;
					}
				}
			}
			jogador.draw(getGraphics2D());
			jogador.update();
			
			for (int i = 0; i < tiros.length; i++) {
				if (tiros[i] != null) {
					tiros[i].draw(getGraphics2D());
					tiros[i].update();
					if(tiros[i].saiuDaTela()) {
						tiros[i] = null;
					}
				}  
 			}
			
			for (int i = 0; i < tirosC.length; i++) {
				if (tirosC[i] != null) {
					tirosC[i].draw(getGraphics2D());
					tirosC[i].update();
					if (jogador.colidiuComTiro(tirosC[i])) {
						jogador.colisao(tirosC[i]);
						tirosC[i] = null;
					}
					if (tirosC[i] != null) {
						if(tirosC[i].saiuDaTela()) {
							tirosC[i] = null;
						}						
					}
				}
			}
			chanceDeSpawn();
			atirarNoInimigo();
			atirarNoChefe();
			for (int i = 0; i < chefes.length; i++) {				
				if (chefes[i] != null) {
					chefes[i].draw(getGraphics2D());
					chefes[i].update();
					chefes[i].colisao();
					disparoChefe(chefes[i]);
				}
			}
			for (int i = 0; i < inimigos.length; i++) {
				if (inimigos[i] != null) {					
					if (jogador.colisao(inimigos[i])) {
						inimigos[i] = null;
					}
				}
			}
			desenharString("VIDAS: " + jogador.getVidas(), 40, 40, Color.RED, 40);
		} else {
			desenharString("VOCÊ PERDEU", Utils.getInstance().getWidth()/2 - 200, Utils.getInstance().getHeight()/2 - 60, Color.RED, 60);
		}
	}

	public void aposTermino() {

	}

	public class MouseInputHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {

		}
	}

	public class KeyInputHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_LEFT) {
				jogador.setLeftPressed(true);
			}
			if (e.getKeyCode() == e.VK_RIGHT) {
				jogador.setRightPressed(true);
			}
			
			if (e.getKeyCode() == e.VK_UP) {
				jogador.setUpPressed(true);
			}
			
			if (e.getKeyCode() == e.VK_DOWN) {
				jogador.setDownPressed(true);
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == e.VK_LEFT) {
				jogador.setLeftPressed(false);
			}
			if (e.getKeyCode() == e.VK_RIGHT) {
				jogador.setRightPressed(false);
			}
			
			if (e.getKeyCode() == e.VK_UP) {
				jogador.setUpPressed(false);
			}
			
			if (e.getKeyCode() == e.VK_DOWN) {
				jogador.setDownPressed(false);
			}
			
			if (e.getKeyCode() == e.VK_SPACE) {
				disparar(tiros);
			}
		}
	}
	
	public void disparar(Tiro[] tiros) {
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] == null) {
				tiros[i] = new Tiro(10, 10, 10);
				tiros[i].definirPosicaoXY(jogador);
				break;
			}
		}
	}
	
	public void disparoChefe(Chefe c) {
		Random r = new Random();
		int sorteio = r.nextInt(101);
		if (sorteio <= 10) {
			for (int i = 0; i < tirosC.length; i++) {
				if (tirosC[i] == null) {
					tirosC[i] = new TiroChefe(10,10,10);
					tirosC[i].definirPosicaoXY(c);
					break;
				}
			}
		}
	}
	
	public void chanceDeSpawn() {
		Random r = new Random();
		int sorteio = r.nextInt(101);
		if (sorteio <= 20) {
			for (int i = 0; i < inimigos.length; i++) {
				if (inimigos[i] == null) {
					inimigos[i] = new Inimigo(0, velocidadeInimigos, 45, 45);
					inimigos[i].gerarPosicaoX();
					break;
				}
			}
			quantidadeSpawnado++;
		}
		if (quantidadeSpawnado == 40) {
			velocidadeInimigos++;
			for (int i = 0; i < chefes.length; i++) {
				if (chefes[i] == null) {
					chefes[i] = new Chefe(0, 10, 135, 135, 10);
					break;
				}
			}
			quantidadeSpawnado = 0;
		}
	}
	
	public void atirarNoInimigo() {
		for (int i = 0; i < tiros.length; i++) {
			for (int j = 0; j < inimigos.length; j++) {
				if (inimigos[j] != null && tiros[i] != null)
				if (tiros[i].colisao(inimigos[j])) {
					tiros[i] = null;
					inimigos[j] = null;
					break;
				}
			}
		}
	}
	
	public void atirarNoChefe() {
		for (int i = 0; i < tiros.length; i++) {
			for (int j = 0; j < chefes.length; j++) {
				if (chefes[j] != null && tiros[i] != null){		
					if (chefes[j].colidiuComTiro(tiros[i])) {
						if (chefes[j].colisao(tiros[i])) {
							chefes[j] = null;
						}
						tiros[i] = null;
					}
					break;
				}
			}
		}
	}
}
