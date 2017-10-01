package aula02.exercicio01;

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

		cartas[0] = new Carta();
		cartas[0].numero = 1;
		cartas[0].posicaoX = 30;
		cartas[0].posicaoY = 30;

		cartas[1] = new Carta();
		cartas[1].numero = 2;
		cartas[1].posicaoX = 100;
		cartas[1].posicaoY = 30;

		cartas[2] = new Carta();
		cartas[2].numero = 3;
		cartas[2].posicaoX = 170;
		cartas[2].posicaoY = 30;

		cartas[3] = new Carta();
		cartas[3].numero = 4;
		cartas[3].posicaoX = 240;
		cartas[3].posicaoY = 30;

		cartas[4] = new Carta();
		cartas[4].numero = 1;
		cartas[4].posicaoX = 30;
		cartas[4].posicaoY = 100;

		cartas[5] = new Carta();
		cartas[5].numero = 4;
		cartas[5].posicaoX = 100;
		cartas[5].posicaoY = 100;

		cartas[6] = new Carta();
		cartas[6].numero = 2;
		cartas[6].posicaoX = 170;
		cartas[6].posicaoY = 100;

		cartas[7] = new Carta();
		cartas[7].numero = 3;
		cartas[7].posicaoX = 240;
		cartas[7].posicaoY = 100;
	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, 330, 190, Color.BLACK);
		if (acertos < 4) {
			for (Carta carta : cartas) {
				desenharRetangulo(carta.posicaoX, carta.posicaoY, 60, 60, new Color(
						120, 155, 99, 255));
			}

			for (Carta carta : cartas) {
				if (carta.paraCima) {
					desenharString(String.valueOf(carta.numero),
							carta.posicaoX + 25, carta.posicaoY + 35, Color.BLACK,
							16);
				} else {
					desenharString("?", carta.posicaoX + 25, carta.posicaoY + 35,
							Color.BLACK, 16);
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

			System.out.println("X: " + e.getX() + " Y: " + e.getY());
			
			if (clicks < 2) {
				for (Carta carta : cartas) {
					if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
							&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
						if (primeiraCarta != carta) {
							carta.virarCarta();							
						}
						if (clicks == 0) {
							primeiraCarta = carta;
						} else {
							segundaCarta = carta;
						}
					}
				}
				clicks++;
			} else {
				if (primeiraCarta.mesmaCarta(segundaCarta)) {
					clicks = 1;
				
				} else if (primeiraCarta.numerosIguais(segundaCarta)) {
					
					for (Carta carta : cartas) {
						if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
								&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
							carta.virarCarta();
							primeiraCarta = carta;
						}
					}
					clicks = 1;
					acertos++;
				} else {
					
					primeiraCarta.virarCarta();
					segundaCarta.virarCarta();
					for (Carta carta : cartas) {
						if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
								&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
							carta.virarCarta();
							primeiraCarta = carta;
						}
					}
					clicks = 1;
					primeiraCarta = null;
				}
			}
		}
	}
}
