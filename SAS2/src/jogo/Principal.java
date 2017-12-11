package jogo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Principal extends Game {

	private boolean emJogo;
	private boolean som;
	private float chanceDeSpawn;
	private int contadorAtirador;
	private int contadorExplosivo;
	private int pontuacao;
	private static final long serialVersionUID = 1L;
	private TelaEstatica vitoria;
	private TelaEstatica derrota;
	private TelaEstatica menu;
	private TelaEstatica historia;
	private TelaEstatica creditos;
	private TelaEstatica ranking;
	private TelaEstatica opcoes;
	private TelaEstatica pausa;
	private Fundo fundo;
	private Personagem trump;
	private Explosivo explosivo;
	private Atirador atirador;
	private LinkedList<Chao> plataformas;
	private LinkedList<Inimigo> inimigos;
	private Image vida;
	private Chefe chefe;

	public Principal() {
		addMouseListener(new ControleMouse());
		addKeyListener(new ControleKey());
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		p.startGame();
	}

	@Override
	public void init() {
		adicionarAudio("musicaFundo", "audio/track7.mpeg");
		adicionarAudio("musicaHistoria", "audio/track1.mpeg");
		adicionarAudio("musicaBoss", "audio/musicaBoss.mp3");
		chefe = null;
		vida = Utils.getInstance().loadImage("imagens/vida.png");
		som = true;
		vitoria = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_vitoria.png"),
				new Botao[] {
						new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/JOGARNOVAMENTE.png")),
						new Botao(Utils.getInstance().getWidth() - 330, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/MENU.png")) },
				false);
		derrota = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_derrota.png"),
				new Botao[] {
						new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/JOGARNOVAMENTE.png")),
						new Botao(Utils.getInstance().getWidth() - 330, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/MENU.png")) },
				false);
		menu = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_novo.png"),
				new Botao[] {
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 200, 300, 100,
								Utils.getInstance().loadImage("imagens/JOGAR.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 310, 300, 100,
								Utils.getInstance().loadImage("imagens/CRÉDITOS.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 420, 300, 100,
								Utils.getInstance().loadImage("imagens/OPÇÕES.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, 530, 300, 100,
								Utils.getInstance().loadImage("imagens/SAIR.png")),
				// new Botao(Utils.getInstance().getWidth() / 2 - 150, 640, 300, 100,
				// Utils.getInstance().loadImage("imagens/SAIR.png")),
				}, true);
		menu.setWidthHeader(800);
		menu.setHeightHeader(300);

		historia = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_historia.png"),
				new Botao[] { new Botao(Utils.getInstance().getWidth() - 330, Utils.getInstance().getHeight() - 130,
						300, 100, Utils.getInstance().loadImage("imagens/JOGAR.png")), },
				false);

		creditos = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_creditos.png"),
				new Botao[] { new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
						Utils.getInstance().loadImage("imagens/VOLTAR.png")), },
				false);

		ranking = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_ranking.png"),
				new Botao[] { new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
						Utils.getInstance().loadImage("imagens/VOLTAR.png")), },
				false);

		opcoes = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_opcoes.png"),
				new Botao[] {
						new Botao(30, Utils.getInstance().getHeight() - 130, 300, 100,
								Utils.getInstance().loadImage("imagens/VOLTAR.png")),
						new Botao(Utils.getInstance().getWidth() / 2 - 150, Utils.getInstance().getHeight() / 2, 300,
								100, Utils.getInstance().loadImage("imagens/COMSOM.png")) },

				false);

		pausa = new TelaEstatica(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"),
				Utils.getInstance().loadImage("imagens/logo_pausa.png"),
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
		atirador = new Atirador(trump);
		inimigos.add(explosivo);
		inimigos.add(atirador);
		plataformas = new LinkedList<>();
		plataformas.add(
				new Chao(0, (int) (Utils.getInstance().getHeight() * 0.85), Utils.getInstance().getWidth(), 100, null));
		// plataformas.add(new Chao(50, (int) (Utils.getInstance().getHeight() * 0.70),
		// 400, 100, null));
		contadorAtirador = 0;
		contadorExplosivo = 0;
		chanceDeSpawn = 5;
		pontuacao = 0;
		requestFocus();
		tocarAudio("musicaFundo");
	}

	@Override
	public void gameLoop() {
		if (menu.isVisivel()) {
			menu.drawAlternativo(getGraphics2D());
		} else if (historia.isVisivel()) {
			historia.draw(getGraphics2D());
			desenharString(
					"No ano de 2018 a ONU decide sancionar uma nova lei onde as guerras são resolvidas entre os próprios governantes.",
					150, 300, Color.BLACK, 20);
			desenharString("Você como o presidente dos Eua tem que salvar o mundo dos inimigos da liberdade.", 150, 320,
					Color.BLACK, 20);

		} else if (creditos.isVisivel()) {
			creditos.draw(getGraphics2D());
			desenharString("Desenvolvedores:", 400, 250, Color.BLACK, 60);
			desenharString("André Branco", 400, 330, Color.BLACK, 60);
			desenharString("Eduardo Cesar", 400, 410, Color.BLACK, 60);
			desenharString("Karolina Gonçalves", 400, 490, Color.BLACK, 60);
			desenharString("Agredecimento:", 400, 570, Color.BLACK, 60);
			desenharString("Matheus Mendes", 400, 630, Color.BLACK, 60);
			// } else if (ranking.isVisivel()) {
			// desenharString("Aqui vai o ranking", 400, 400, Color.BLACK, 60);
			// ranking.draw(getGraphics2D());
		} else if (opcoes.isVisivel()) {
			opcoes.draw(getGraphics2D());
			if (som) {
				opcoes.getBotao(1).setSprite(Utils.getInstance().loadImage("imagens/COMSOM.png"));
			} else {
				opcoes.getBotao(1).setSprite(Utils.getInstance().loadImage("imagens/SEMSOM.png"));
			}
		} else if (vitoria.isVisivel()) {
			vitoria.draw(getGraphics2D());
			desenharString("PARABÉNS, VOCÊ VENCEU!", Utils.getInstance().getWidth() / 2 - 300, 300, Color.BLACK, 40);
			desenharString("PONTUAÇÃO: " + pontuacao, Utils.getInstance().getWidth() / 2 - 300, 400, Color.YELLOW, 40);
			desenharString("ATIRADORES DERROTADOS: " + contadorAtirador, Utils.getInstance().getWidth() / 2 - 300, 480,
					Color.YELLOW, 40);
			desenharString("EXPLOSIVOS DERROTADOS: " + contadorExplosivo, Utils.getInstance().getWidth() / 2 - 300, 560,
					Color.YELLOW, 40);
		} else if (derrota.isVisivel()) {
			derrota.draw(getGraphics2D());
			desenharString("QUE PENA, VOCÊ PERDEU!", Utils.getInstance().getWidth() / 2 - 300, 300, Color.BLACK, 40);
			desenharString("PONTUAÇÃO: " + pontuacao, Utils.getInstance().getWidth() / 2 - 300, 400, Color.YELLOW, 40);
			desenharString("ATIRADORES DERROTADOS: " + contadorAtirador, Utils.getInstance().getWidth() / 2 - 300, 480,
					Color.YELLOW, 40);
			desenharString("EXPLOSIVOS DERROTADOS: " + contadorExplosivo, Utils.getInstance().getWidth() / 2 - 300, 560,
					Color.YELLOW, 40);
		} else if (emJogo) {
			// chao.draw(getGraphics2D());
			// plataformas.get(1).draw(getGraphics2D());
			// plataformas.get(0).draw(getGraphics2D());

			if (chefe != null) {
				fundo.update();
				fundo.draw(getGraphics2D());

				trump.update();
				trump.draw(getGraphics2D());
				trump.colidindoComChao(plataformas);
				chefe.update();
				chefe.draw(getGraphics2D());
				if (trump.isIndoPraEsquerda() && trump.isColidindoComCaixaEsquerda()) {
					moverTudo(1);
				} else if (trump.isIndoPraDireita() && trump.isColidindoComCaixaDireita()) {
					moverTudo(-1);
				} else {
					moverTudo(0);
				}
			} else {
				fundo.update();
				fundo.draw(getGraphics2D());

				trump.update();
				trump.draw(getGraphics2D());
				trump.colidindoComChao(plataformas);
				if (trump.isIndoPraEsquerda() && trump.isColidindoComCaixaEsquerda()) {
					moverTudo(1);
				} else if (trump.isIndoPraDireita() && trump.isColidindoComCaixaDireita()) {
					moverTudo(-1);
				} else {
					moverTudo(0);
				}
				gerarInimigos();

				for (Inimigo inimigo : inimigos) {
					if (inimigo != null) {
						inimigo.draw(getGraphics2D());
						inimigo.update();
					}
				}

				for (int i = 0; i < inimigos.size(); i++) {
					if (trump.colisao(inimigos.get(i))) {
						if (inimigos.get(i).getClass() == Explosivo.class) {
							contadorExplosivo++;
							pontuacao += 5;
							inimigos.remove(inimigos.get(i));
						} else {
							contadorAtirador++;
							pontuacao += 10;
							inimigos.remove(inimigos.get(i));
						}
					}
				}
			}

			for (int i = 0; i < trump.getVidas(); i++) {
				getGraphics2D().drawImage(vida, 50 * i + 75, 40, 32, 32, null);
			}
			desenharString("PONTUAÇÃO: " + pontuacao, 75, 100, Color.YELLOW, 30);
			if (chefe != null && chefe.getVidas() > 0) {
				desenharString("Vida do Chefe: " + chefe.getVidas(), 1000, 100, Color.RED, 30);
			} else if (chefe != null && chefe.getVidas() <= 0) {
				vitoria.setVisivel(true);
				emJogo = false;
			}
			if (trump.getVidas() <= 0) {
				derrota.setVisivel(true);
				emJogo = false;
			}
		} else if (pausa.isVisivel()) {
			pausa.draw(getGraphics2D());
		}
	}

	public void gerarInimigos() {
		Random r = new Random();
		if (pontuacao < 500) {
			if (r.nextInt(100) <= chanceDeSpawn) {
				if (r.nextInt(2) == 0) {
					inimigos.add(new Explosivo(trump));
				} else {
					inimigos.add(new Atirador(trump));
				}
			}
		} else {
			if (som) {
				pararAudio("musicaFundo");
				tocarAudio("musicaBoss");
			}
			fundo.setSprite(Utils.getInstance().loadImage("imagens/pracaOFICIAL.png"));
			chefe = new Chefe(trump);
			chefe.setVidas(500);
		}
	}

	public void reset() {
		emJogo = true;
		trump = new Personagem();
		inimigos = new LinkedList<>();
		chefe = null;
		pontuacao = 0;
		contadorAtirador = 0;
		contadorExplosivo = 0;
		fundo.setSprite(Utils.getInstance().loadImage("imagens/cenarioOFICIAL.png"));
	}

	public void moverTudo(int direcao) {
		fundo.setMovendo(direcao);
		// atirador.setMoving(direcao);
		// if (!fundo.isAtingiuPontoMaximo()) {
		// plataformas.get(1).setPosX(plataformas.get(1).getPosX() + fundo.getVelX() *
		// direcao);
		// }
		// for (int i = 0; i < plataformas.size(); i++) {
		// plataformas.get(i).setPosX(plataformas.get(i).getPosX() + fundo.getVelX() *
		// direcao);
		// }
		// plataformas.get(1).setPosX(plataformas.get(1).getPosX() + fundo.getVelX() *
		// direcao);
	}

	public class ControleKey extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_X) {
				menu.setVisivel(false);
				historia.setVisivel(false);
				creditos.setVisivel(false);
				ranking.setVisivel(false);
				opcoes.setVisivel(false);
				emJogo = true;
				pausa.setVisivel(false);
			}
			if (key == KeyEvent.VK_ESCAPE) {
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
				if (key == KeyEvent.VK_LEFT) {
					trump.setPodeAndar(fundo.isAtingiuPontoMaximo());
					trump.setIndoPraEsquerda(true);
					if (trump.isColidindoComCaixaEsquerda()) {
					}
				} else if (key == KeyEvent.VK_RIGHT) {
					trump.setPodeAndar(fundo.isAtingiuPontoMaximo());
					trump.setIndoPraDireita(true);
					if (trump.isColidindoComCaixaDireita()) {
					}
				}

				if (key == KeyEvent.VK_UP) {
					if (trump.colidindoComChao(plataformas)) {
						trump.setPulando(true);
					}
				}

				if (key == KeyEvent.VK_Z) {
					trump.darSoco();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (emJogo) {
				if (key == KeyEvent.VK_LEFT) {
					trump.setIndoPraEsquerda(false);
				}

				if (key == KeyEvent.VK_RIGHT) {
					trump.setIndoPraDireita(false);
				}

				if (key == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
				}

				if (key == KeyEvent.VK_SPACE) {
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
					if (som) {
						pararAudio("musicaFundo");
						tocarAudio("musicaHistoria");
					}
				} else if (menu.getBotao(1).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					creditos.setVisivel(true);
					// } else if (menu.getBotao(2).click(e.getX(), e.getY())) {
					// menu.setVisivel(false);
					// ranking.setVisivel(true);
				} else if (menu.getBotao(2).click(e.getX(), e.getY())) {
					menu.setVisivel(false);
					opcoes.setVisivel(true);
				} else if (menu.getBotao(3).click(e.getX(), e.getY())) {
					System.exit(0);
				}
			} else if (historia.isVisivel()) {
				if (historia.getBotao(0).click(e.getX(), e.getY())) {
					emJogo = true;
					historia.setVisivel(false);
					if (som) {
						pararAudio("musicaHistoria");
						tocarAudio("musicaFundo");
					}
				}
			} else if (creditos.isVisivel()) {
				if (creditos.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(true);
					creditos.setVisivel(false);
				}
				// } else if (ranking.isVisivel()) {
				// if (ranking.getBotao(0).click(e.getX(), e.getY())) {
				// menu.setVisivel(true);
				// ranking.setVisivel(false);
				// }
			} else if (opcoes.isVisivel()) {
				if (opcoes.getBotao(0).click(e.getX(), e.getY())) {
					menu.setVisivel(true);
					opcoes.setVisivel(false);
				} else if (opcoes.getBotao(1).click(e.getX(), e.getY())) {
					som = !som;
					if (som) {
						tocarAudio("musicaFundo");
					} else {
						pararAudio("musicaFundo");
					}
				}
			} else if (pausa.isVisivel()) {
				if (pausa.getBotao(0).click(e.getX(), e.getY())) {
					pausa.setVisivel(false);
					emJogo = true;
				} else if (pausa.getBotao(1).click(e.getX(), e.getY())) {
					pausa.setVisivel(false);
					init();
				}
			} else if (vitoria.isVisivel()) {
				if (vitoria.getBotao(0).click(e.getX(), e.getY())) {
					vitoria.setVisivel(false);
					reset();
					chefe = null;
					emJogo = true;
				} else if (vitoria.getBotao(1).click(e.getX(), e.getY())) {
					vitoria.setVisivel(false);
					init();
				}
			} else if (derrota.isVisivel()) {
				if (derrota.getBotao(0).click(e.getX(), e.getY())) {
					derrota.setVisivel(false);
					reset();
					chefe = null;
					emJogo = true;
				} else if (derrota.getBotao(1).click(e.getX(), e.getY())) {
					derrota.setVisivel(false);
					init();
				}
			}
		}
	}

	@Override
	public void aposTermino() {

	}
}
