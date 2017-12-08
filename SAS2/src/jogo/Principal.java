package jogo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private boolean emJogo;
	private boolean som;
	private static final long serialVersionUID = 1L;
	private TelaEstatica menu;
	private TelaEstatica historia;
	private TelaEstatica creditos;
	private TelaEstatica ranking;
	private TelaEstatica opcoes;
	private TelaEstatica pausa;
	private Fundo fundo;
	private Personagem trump;
	private Explosivo explosivo;
	private LinkedList<Chao> plataformas;
	private LinkedList<Inimigo> inimigos;
	private Image vida;
	
	public Principal() {
		addMouseListener(new ControleMouse());
		addKeyListener(new ControleKey());
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}

	@Override
	public void aposTermino() {
	
	}

	@Override
	public void gameLoop() {
		if (menu.isVisivel()) {
			menu.draw(getGraphics2D());
		} else if (historia.isVisivel()) {
			historia.draw(getGraphics2D());
			desenharString("Aqui vai a história", 400, 400, Color.BLACK, 60);
		} else if (creditos.isVisivel()) {
			desenharString("Aqui vai os créditos", 400, 400, Color.BLACK, 60);
			creditos.draw(getGraphics2D());
		} else if (ranking.isVisivel()) {
			desenharString("Aqui vai o ranking", 400, 400, Color.BLACK, 60);
			ranking.draw(getGraphics2D());
		} else if (opcoes.isVisivel()) {
			opcoes.draw(getGraphics2D());
			if (som) {
				opcoes.getBotao(1).setSprite(Utils.getInstance().loadImage("imagens/COMSOM.png"));
			} else {
				opcoes.getBotao(1).setSprite(Utils.getInstance().loadImage("imagens/SEMSOM.png"));
			}
		} else if (emJogo) {
			fundo.update();
			fundo.draw(getGraphics2D());
//			chao.draw(getGraphics2D());
			plataformas.get(1).draw(getGraphics2D());
			plataformas.get(0).draw(getGraphics2D());
			trump.update();
			trump.draw(getGraphics2D());
			trump.colidindoComChao(plataformas);
			trump.caiuDaTela();
			if (trump.isIndoPraEsquerda() && trump.isColidindoComCaixaEsquerda()) {
				moverTudo(1);
			} else if (trump.isIndoPraDireita() && trump.isColidindoComCaixaDireita()) {
				moverTudo(-1);
			} else {
				moverTudo(0);
			}
			
			for (Inimigo inimigo : inimigos) {
				if (inimigo != null) {
					inimigo.draw(getGraphics2D());
					inimigo.update();
				}
			}
			
			for (int i = 0; i < inimigos.size(); i++) {
				if (trump.colisao(inimigos.get(i))) {
					inimigos.remove(inimigos.get(i));
				}
			}
			for (int i = 0; i < trump.getVidas(); i++) {
				getGraphics2D().drawImage(vida, 50*i + 50, 50, 32, 32, null);
			}
			desenharString("Contador Explosão: " + explosivo.getContadorExplosao(), 50, 100, Color.YELLOW, 20);
			if (trump.getVidas() <= 0) {
				init();
			}
		} else if (pausa.isVisivel()) {
			pausa.draw(getGraphics2D());
		}
	}

	@Override
	public void init() {
		vida = Utils.getInstance().loadImage("imagens/vida.png");
		som = true;
		menu = new TelaEstatica(Utils.getInstance().loadImage("imagens/cenarioOFICIAL.png"), Utils.getInstance().loadImage("imagens/logo.png"),
				new Botao[] {
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 200, 300, 100,
								Utils.getInstance().loadImage("imagens/JOGAR.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 310, 300, 100,
								Utils.getInstance().loadImage("imagens/CRÉDITOS.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 420, 300, 100,
								Utils.getInstance().loadImage("imagens/RANKING.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 530, 300, 100,
								Utils.getInstance().loadImage("imagens/OPÇÕES.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 640, 300, 100,
								Utils.getInstance().loadImage("imagens/SAIR.png")), },
				true);
	
		historia = new TelaEstatica(null, Utils.getInstance().loadImage("imagens/logo_historia.png"),
				new Botao[] { new Botao(Utils.getInstance().getWidth() - 330, Utils.getInstance().getHeight() - 130,
						300, 100, Utils.getInstance().loadImage("imagens/PULAR.png")), },
				false);
	
		creditos = new TelaEstatica(null, Utils.getInstance().loadImage("imagens/logo_creditos.png"),
				new Botao[] { new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
						Utils.getInstance().loadImage("imagens/VOLTAR.png")), },
				false);
	
		ranking = new TelaEstatica(null, Utils.getInstance().loadImage("imagens/logo_ranking.png"),
				new Botao[] { new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
						Utils.getInstance().loadImage("imagens/VOLTAR.png")), },
				false);
	
		opcoes = new TelaEstatica(null, Utils.getInstance().loadImage("imagens/logo_opcoes.png"),
				new Botao[] {
						new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/VOLTAR.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, Utils.getInstance().getHeight() / 2, 300,
								100, Utils.getInstance().loadImage("imagens/COMSOM.png")) },
	
				false);
	
		pausa = new TelaEstatica(null, Utils.getInstance().loadImage("imagens/logo_pausa.png"),
				new Botao[] {
						new Botao(Utils.getInstance().getWidth() / 2 - 150, Utils.getInstance().getHeight() / 2 - 105,
								300, 100, Utils.getInstance().loadImage("imagens/CONTINUAR.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, Utils.getInstance().getHeight() / 2 + 5,
								300, 100, Utils.getInstance().loadImage("imagens/MENU.png")), },
				false);
		fundo = new Fundo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(),
				Utils.getInstance().loadImage("imagens/cenarioOFICIAL.png"), 10, 0);
		trump = new Personagem();
		inimigos = new LinkedList<>();
		explosivo = new Explosivo(trump);
		inimigos.add(explosivo);
		plataformas = new LinkedList<>();
		plataformas.add(new Chao(0, 780, Utils.getInstance().getWidth(), 100, null));
		plataformas.add(new Chao(50, 630, 400, 100, null));
		
		requestFocus();
	}

	public void moverTudo(int direcao) {
		fundo.setMovendo(direcao);
//		atirador.setMoving(direcao);
		plataformas.get(1).setPosX(plataformas.get(1).getPosX() + fundo.getVelX() * direcao);
//		for (int i = 0; i < plataformas.size(); i++) {
//			plataformas.get(i).setPosX(plataformas.get(i).getPosX() + fundo.getVelX() * direcao);
//		}
//		plataformas.get(1).setPosX(plataformas.get(1).getPosX() + fundo.getVelX() * direcao);
	}

	public class ControleKey extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == e.VK_X) {
				menu.setVisivel(false);
				historia.setVisivel(false);
				creditos.setVisivel(false);
				ranking.setVisivel(false);
				opcoes.setVisivel(false);
				emJogo = true;
				pausa.setVisivel(false);
			}
			if (key == e.VK_ESCAPE) {
				if (menu.isVisivel()) {
					System.exit(0);
				} else if (emJogo) {
					pausa.setVisivel(true);
					emJogo = false;
				} else {
					menu.setVisivel(true);
					historia.setVisivel(false);
					creditos.setVisivel(false);
					ranking.setVisivel(false);
					opcoes.setVisivel(false);
					emJogo = false;
					pausa.setVisivel(false);
				}
			}
			if (emJogo) {
				if (key == e.VK_LEFT) {
					trump.setPodeAndar(fundo.isAtingiuPontoMaximo());
					trump.setIndoPraEsquerda(true);
					if (trump.isColidindoComCaixaEsquerda()) {
					}
				} else if (key == e.VK_RIGHT) {
					trump.setPodeAndar(fundo.isAtingiuPontoMaximo());
					trump.setIndoPraDireita(true);
					if (trump.isColidindoComCaixaDireita()) {
					}
				}
				
				if (key == e.VK_UP) {
					if (trump.colidindoComChao(plataformas)) {
						trump.setPulando(true);
					}
				}
				
				if (key == e.VK_Z) {
					trump.darSoco();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (emJogo) {
				if (key == e.VK_LEFT) {
					trump.setIndoPraEsquerda(false);
				}

				if (key == e.VK_RIGHT) {
					trump.setIndoPraDireita(false);
				}

				if (key == e.VK_A || e.getKeyCode() == e.VK_D) {
				}

				if (key == e.VK_SPACE) {
					explosivo.explodir();
				}
			}
		}
	}

	public class ControleMouse extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (menu.isVisivel()) {
				if (menu.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					historia.setVisivel(true);
				} else if (menu.getBotao(1).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					creditos.setVisivel(true);
				} else if (menu.getBotao(2).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					ranking.setVisivel(true);
				} else if (menu.getBotao(3).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					opcoes.setVisivel(true);
				} else if (menu.getBotao(4).click(e.getX(), e.getY())) {
					System.exit(0);
				}
			} else if (historia.isVisivel()) {
				if (historia.getBotao(0).click(e.getX(), e.getY())) {
					emJogo = true;
					historia.setVisivel(false);
				}
			} else if (creditos.isVisivel()) {
				if (creditos.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(true);
					creditos.setVisivel(false);
				}
			} else if (ranking.isVisivel()) {
				if (ranking.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(true);
					ranking.setVisivel(false);
				}
			} else if (opcoes.isVisivel()) {
				if (opcoes.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(true);
					opcoes.setVisivel(false);
				} else if (opcoes.getBotao(1).click(e.getX(), e.getY())) {
					som = !som;
				}
			} else if (pausa.isVisivel()) {
				if (pausa.getBotao(0).click(e.getX(), e.getY())) {
					pausa.setVisivel(false);
					emJogo = true;
				} else if (pausa.getBotao(1).click(e.getX(), e.getY())) {
					pausa.setVisivel(false);
					init();
				}
			}
		}
	}
}
