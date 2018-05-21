package rec;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Roda extends Game{
	
	private static final long serialVersionUID = 1L;
	private Jogador j;
	private Coletavel[] coletaveis;
	private int contadorinvocar;
	private boolean pegoucafe;
	private boolean pegouacucar;
	private Random sorteio;
	private Tela endGame;
	public static int contadorCafe;
	public static int contadorAcucar;
	public static int contadorAgua;
	public static int contadorRefrigerante;
	
	public Roda() {
		addKeyListener(new Teclado());
	}
	
	public static void main(String[] args) {
		Roda r = new Roda();
		r.startGame();
	}

	@Override
	public void aposTermino() {
	}

	@Override
	public void gameLoop() {
		if (j.vida > 0) {
			desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.black);
			desenharRetangulo(0, 700, Utils.getInstance().getWidth(), 400, Color.darkGray);
			desenharString("VIDAS: " + j.vida, 50, 50, Color.red, 60);
			j.draw(getGraphics2D());
			j.update();
			invocarInimigo();
			gerenciarColetaveis();
		} else {
			endGame.draw(getGraphics2D());
		}
	}
	
	public void gerenciarColetaveis() {
		for (int i = 0; i < coletaveis.length; i++) {
			if (coletaveis[i] != null) {
				if (coletaveis[i].foiColetado(j)) {
					Coletavel c = coletaveis[i];
					if (c.getClass() == Cafe.class) {
						contadorCafe++;
						pegoucafe = true;
					} else
					if (c.getClass() == Acucar.class){
						contadorAcucar++;
						pegouacucar = true;
					} else
					if (c.getClass() == Refrigerante.class) {
						contadorRefrigerante++;
						j.vida = j.vida - 25;
					} else {
						contadorAgua++;
						j.vida = j.vida + 25;
					}
					coletaveis[i] = null;
					if (pegoucafe && pegouacucar) {
						j.vida = j.vida + 50;
						pegoucafe = false;
						pegouacucar = false;
					}
				} else
				if (coletaveis[i].saiu) {
					coletaveis[i] = null;
				}
			}
		}
		for (int i = 0; i < coletaveis.length; i++) {
			if (coletaveis[i] != null) {
				coletaveis[i].update();
				coletaveis[i].draw(getGraphics2D());
			}
		}
	}
	
	public void invocarInimigo() {
		if (contadorinvocar == 15) {
			contadorinvocar = 0;
			for (int i = 0; i < coletaveis.length; i++) {
				if (coletaveis[i] == null) {
					coletaveis[i] = criarColetavel();
					break;
				}
			}
		} else {
			contadorinvocar++;
		}
	}
	
	public Coletavel criarColetavel() {
		int sorteado = sorteio.nextInt(4);
		switch(sorteado) {
		case 0:
			return new Cafe();
		case 1:
			return new Acucar();
		case 2:
			return new Agua();
		case 3:
			return new Refrigerante();
		default:
			return null;
		}
	}

	@Override
	public void init() {
		j = new Jogador();
		coletaveis = new Coletavel[200];
		contadorinvocar = 0;
		contadorCafe = 0;
		contadorAcucar = 0;
		contadorRefrigerante = 0;
		contadorAgua = 0;
		pegoucafe = false;
		pegouacucar = false;
		sorteio = new Random();
		endGame = new Tela();
		requestFocus();
	}
	
	public class Teclado extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_A) {
				j.movendo = -1;
			} else if (e.getKeyCode() == e.VK_D) {
				j.movendo = 1;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == e.VK_A) {
				j.movendo = 0;
			} else if (e.getKeyCode() == e.VK_D) {
				j.movendo = 0;
			}
		}
	}
}
