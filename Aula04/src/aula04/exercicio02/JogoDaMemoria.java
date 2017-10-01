package aula04.exercicio02;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Game;

public class JogoDaMemoria extends Game {

	private static final long serialVersionUID = 1L;

	int clicks;
	int acertos;

	Carta primeiraCarta;
	Carta segundaCarta;

	Carta[] cartas;

	public JogoDaMemoria() {
		super("Jogo da Memória", 330, 190);
		addMouseListener(new MouseInputHandler());
		addMouseMotionListener(new MouseInputHandler());
	} 

	public static void main(String[] args) {
		JogoDaMemoria principal = new JogoDaMemoria();
		principal.startGame();

	}

	@Override
	public void init() {
		cartas = new Carta[8];

		acertos = 0;

		cartas[0] = new Carta(30, 30, 1);

		cartas[1] = new Carta(100, 30, 2);

		cartas[2] = new Carta(170, 30, 3);

		cartas[3] = new Carta(240, 30, 4);

		cartas[4] = new Carta(30, 100, 1);

		cartas[5] = new Carta(100, 100, 4);

		cartas[6] = new Carta(170, 100, 2);

		cartas[7] = new Carta(240, 100, 3);
	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, 330, 190, Color.BLACK);
		if (acertos != cartas.length/2) {
			for (Carta carta : cartas) {
				desenharRetangulo(carta.getPosicaoX(), carta.getPosicaoY(), 60, 60,
						new Color(120, 155, 99, 255));
			}

			for (Carta carta : cartas) {
				if (carta.isParaCima()) {
					desenharString(String.valueOf(carta.getNumero()),
							carta.getPosicaoX() + 25, carta.getPosicaoY() + 35,
							Color.BLACK, 16);
				} else {
					desenharString("?", carta.getPosicaoX() + 25,
							carta.getPosicaoY() + 35, Color.BLACK, 16);
				}
			}
		} else {
			desenharString("Você venceu o jogo!!!", 70, 50, Color.WHITE, 20);
			finalizarJogo();
		}
	}

	@Override
	public void aposTermino() {
		// TODO Auto-generated method stub

	}

	public class MouseInputHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {

			// System.out.println("X: " + e.getX() + " Y: " + e.getY());

			// Forma do professor
			for (Carta carta : cartas) {
				if ((e.getX() >= carta.getPosicaoX() && e.getX() <= carta.getPosicaoX() + 60)
						&& (e.getY() >= carta.getPosicaoY() && e.getY() <= carta.getPosicaoY() + 60)) {					
					if (!carta.isParaCima()) {
						if (primeiraCarta == null) {
							carta.virarCarta();
							primeiraCarta = carta;
						} else if (segundaCarta == null
								&& !carta.mesmaCarta(primeiraCarta)) {
							carta.virarCarta();
							segundaCarta = carta;
							if (primeiraCarta.numerosIguais(segundaCarta)) {
								acertos++;
							}
						}
						else if (segundaCarta != null) {
							if (!primeiraCarta.numerosIguais(segundaCarta)) {
								primeiraCarta.virarCarta();
								segundaCarta.virarCarta();														
							}
							primeiraCarta = null;
							segundaCarta = null;
						}
					}
					break;
				} 
			}
			

			// Inicio da minha forma de resolver
//			if (clicks < 2) {
//				for (Carta carta : cartas) {
//					if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
//							&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
//						if (primeiraCarta != carta && !carta.acertou) {
//							carta.virarCarta();
//							if (clicks == 0) {
//								primeiraCarta = carta;
//							} else {
//								segundaCarta = carta;
//							}
//							clicks++;
//						}
//						break;
//					}
//				}
//			} else {
//				if (primeiraCarta.mesmaCarta(segundaCarta)) {
//					clicks = 0;
//					segundaCarta = new Carta();
//				} else if (primeiraCarta.numerosIguais(segundaCarta)) {
//					acertos++;
//					primeiraCarta.acertou = true;
//					segundaCarta.acertou = true;
//					segundaCarta = new Carta();
//					for (Carta carta : cartas) {
//						if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
//								&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
//							if (!carta.acertou) {
//								carta.virarCarta();
//								primeiraCarta = carta;
//							}
//							break;
//						}
//					}
//					clicks = 1;
//				} else {
//					primeiraCarta.virarCarta();
//					segundaCarta.virarCarta();
//					segundaCarta = new Carta();
//					for (Carta carta : cartas) {
//						if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
//								&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
//							if (!carta.acertou) {
//								carta.virarCarta();
//								primeiraCarta = carta;
//							}
//							break;
//						}
//					}
//					clicks = 1;
//				}
//			}
			// Fim da minha forma de resolver
		}
	}
}

