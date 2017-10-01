package aula01.exercicio02;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import aula01.exercicio01.Carta;
import br.senai.sc.engine.Game;

public class JogoDaMemoria extends Game {

	private static final long serialVersionUID = 1L;

	int clicks;

	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	Carta carta7;
	Carta carta8;

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

		carta1 = new Carta();
		carta1.numero = 1;
		carta1.posicaoX = 30;
		carta1.posicaoY = 30;

		carta2 = new Carta();
		carta2.numero = 2;
		carta2.posicaoX = 100;
		carta2.posicaoY = 30;

		carta3 = new Carta();
		carta3.numero = 3;
		carta3.posicaoX = 170;
		carta3.posicaoY = 30;

		carta4 = new Carta();
		carta4.numero = 4;
		carta4.posicaoX = 240;
		carta4.posicaoY = 30;

		carta5 = new Carta();
		carta5.numero = 1;
		carta5.posicaoX = 30;
		carta5.posicaoY = 100;

		carta6 = new Carta();
		carta6.numero = 4;
		carta6.posicaoX = 100;
		carta6.posicaoY = 100;

		carta7 = new Carta();
		carta7.numero = 2;
		carta7.posicaoX = 170;
		carta7.posicaoY = 100;

		carta8 = new Carta();
		carta8.numero = 3;
		carta8.posicaoX = 240;
		carta8.posicaoY = 100;

		cartas = new Carta[] { carta1, carta2, carta3, carta4, carta5, carta6,
				carta7, carta8, };
	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, 330, 190, Color.BLACK);

		desenharRetangulo(carta1.posicaoX, carta1.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta2.posicaoX, carta1.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta3.posicaoX, carta1.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta4.posicaoX, carta1.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta5.posicaoX, carta5.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta6.posicaoX, carta5.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta7.posicaoX, carta5.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

		desenharRetangulo(carta8.posicaoX, carta5.posicaoY, 60, 60, new Color(
				120, 155, 99, 255));

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
	}

	@Override
	public void aposTermino() {
		// TODO Auto-generated method stub

	}

	public class MouseInputHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {

			System.out.println("X: " + e.getX() + " Y: " + e.getY());
			for (int i = 0; i < cartas.length; i++) {
				if ((e.getX() >= cartas[i].posicaoX && e.getX() <= cartas[i].posicaoX + 60)
						&& (e.getY() >= cartas[i].posicaoY && e.getY() <= cartas[i].posicaoY + 60)) {
					cartas[i].virarCarta();
				}
			}
			
			for(int i = 1; i <= 10; i++){
				System.out.println(i);
			}
			
//			for (Carta carta : cartas) {
//				if ((e.getX() >= carta.posicaoX && e.getX() <= carta.posicaoX + 60)
//						&& (e.getY() >= carta.posicaoY && e.getY() <= carta.posicaoY + 60)) {
//					carta.virarCarta();
//				}
//			}
		}
	}
}
