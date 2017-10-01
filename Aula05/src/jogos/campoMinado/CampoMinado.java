package jogos.campoMinado;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Game;

@SuppressWarnings("serial")
public class CampoMinado extends Game {

	Celula[][] celulas;
	boolean perdeu;
	boolean acertos;
	boolean ganhou;
	int pontos;

	public CampoMinado() {
		super("Campo Minado", 210, 210);
		addMouseListener(new MouseInputHandler());
		addMouseMotionListener(new MouseInputHandler());
	}

	public static void main(String[] args) {
		CampoMinado campo = new CampoMinado();
		campo.startGame();
	}

	@Override
	public void init() {
		pontos = 0;

		celulas = new Celula[4][4];

		celulas[0][0] = new Celula(30, 30, 0, 30, 30, 210, 210);
		celulas[0][1] = new Celula(70, 30, 0, 30, 30, 210, 210);
		celulas[0][2] = new Celula(110, 30, 0, 30, 30, 210, 210);
		celulas[0][3] = new Celula(150, 30, 0, 30, 30, 210, 210);

		celulas[1][0] = new Celula(30, 70, 0, 30, 30, 210, 210);
		celulas[1][1] = new Celula(70, 70, 9, 30, 30, 210, 210);
		celulas[1][2] = new Celula(110, 70, 0, 30, 30, 210, 210);
		celulas[1][3] = new Celula(150, 70, 0, 30, 30, 210, 210);

		celulas[2][0] = new Celula(30, 110, 0, 30, 30, 210, 210);
		celulas[2][1] = new Celula(70, 110, 0, 30, 30, 210, 210);
		celulas[2][2] = new Celula(110, 110, 0, 30, 30, 210, 210);
		celulas[2][3] = new Celula(150, 110, 9, 30, 30, 210, 210);

		celulas[3][0] = new Celula(30, 150, 0, 30, 30, 210, 210);
		celulas[3][1] = new Celula(70, 150, 0, 30, 30, 210, 210);
		celulas[3][2] = new Celula(110, 150, 0, 30, 30, 210, 210);
		celulas[3][3] = new Celula(150, 150, 9, 30, 30, 210, 210);

	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, 600, 600, new Color(190, 191, 185, 255));
		if (!ganhou && !perdeu) {
			for (int i = 0; i < celulas.length; i++) {
				for (int j = 0; j < celulas[i].length; j++) {
					if (!celulas[i][j].isVidara()) {
						desenharRetangulo(celulas[i][j].getPosicaoX(),
								celulas[i][j].getPosicaoY(),
								celulas[i][j].getLargura(),
								celulas[i][j].getAltura(), (new Color(99, 148, 183,
										255)));
					} else {
						if (celulas[i][j].getNumero() == 9) {
							desenharString("@", celulas[i][j].getPosicaoX() + 25,
									celulas[i][j].getPosicaoY() + 35, Color.BLACK,
									16);
						} else {
							desenharRetangulo(celulas[i][j].getPosicaoX(),
									celulas[i][j].getPosicaoY(),
									celulas[i][j].getLargura(),
									celulas[i][j].getAltura(), (new Color(118, 177,
											219, 255)));
							desenharString(
									String.valueOf(celulas[i][j].getNumero()),
									celulas[i][j].getPosicaoX() + 15,
									celulas[i][j].getPosicaoY() + 25, Color.BLACK,
									16);
						}
					}
				}
			}
		} else if (ganhou) {
			desenharString("Você Venceu o jogo!", 28, 50, new Color(65, 109, 31, 255), 16);
			desenharString("Sua pontuação: " + pontos, 28, 80, new Color(65, 109, 31, 255), 16);
			finalizarJogo();
		} else {
			desenharString("Você Perdeu o jogo!", 28, 50, Color.RED, 16);
			desenharString("Sua pontuação: " + pontos, 28, 80, Color.RED, 16);
			finalizarJogo();
		}

	}

	@Override
	public void aposTermino() {
	}

	public class MouseInputHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			for (int i = 0; i < celulas.length; i++) {
				for (int j = 0; j < celulas.length; j++) {
					if (celulas[i][j].foiClicada(e.getX(), e.getY())) {
						if (celulas[i][j].getNumero() == 9) {
							perdeu = true;
						} else {
							if (!celulas[i][j].isVidara()) {
								pontos++;
								celulas[i][j].virarCelula();
								celulas[i][j].setNumero(verificarBombas(i, j));
								if (pontos == (celulas.length * celulas[0].length) - 3) {
									ganhou = true;
								}
							}
						}
					}
				}
			}
		}
	}

	public int verificarBombas(int i, int j) {
		int quantidade = 0;
		if (i - 1 >= 0 && j - 1 >= 0) {
			if (celulas[i - 1][j - 1].getNumero() == 9) {
				quantidade++;
			}
		}

		if (i - 1 >= 0 && j - 1 >= 0) {
			if (celulas[i][j - 1].getNumero() == 9) {
				quantidade++;
			}
		}

		if (i + 1 <= celulas.length - 1 && j - 1 >= 0) {
			if (celulas[i + 1][j - 1].getNumero() == 9) {
				quantidade++;
			}
		}

		if (i - 1 >= 0) {
			if (celulas[i - 1][j].getNumero() == 9) {
				quantidade++;
			}
		}

		if (celulas[i][j].getNumero() == 9) {
			quantidade++;
		}

		if (i + 1 <= celulas.length - 1) {
			if (celulas[i + 1][j].getNumero() == 9) {
				quantidade++;
			}
		}

		if (i - 1 >= 0 && j + 1 <= celulas[0].length - 1) {
			if (celulas[i - 1][j + 1].getNumero() == 9) {
				quantidade++;
			}
		}

		if (j + 1 <= celulas[0].length - 1) {
			if (celulas[i][j + 1].getNumero() == 9) {
				quantidade++;
			}
		}

		if (i + 1 <= celulas.length - 1 && j + 1 <= celulas[0].length - 1) {
			if (celulas[i + 1][j + 1].getNumero() == 9) {
				quantidade++;
			}
		}
		return quantidade;
	}
}
