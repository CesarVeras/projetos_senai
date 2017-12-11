package rec;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class Roda extends Game{
	
	Jogador j;
	Poder[] poderes;
	int contadorinvocar;
	int contadorcafe;
	int contadoracucar;
	int contadoragua;
	int contadorrefrigerante;
	boolean pegoucafe;
	boolean pegouacucar;
	
	public Roda() {
		addKeyListener(new Teclado());
	}
	
	public static void main(String[] args) {
		Roda r = new Roda();
		r.startGame();
	}

	@Override
	public void aposTermino() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameLoop() {
		desenharRetangulo(0, 0, Utils.getInstance().getWidth(), Utils.getInstance().getHeight(), Color.black);
		desenharRetangulo(0, 700, Utils.getInstance().getWidth(), 400, Color.darkGray);
		desenharString("VIDAS: " + j.vida, 50, 50, Color.red, 60);
		j.update();
		j.draw(getGraphics2D());
		if (j.vida > 0) {
			if (contadorinvocar == 15) {
				contadorinvocar = 0;
				for (int i = 0; i < poderes.length; i++) {
					if (poderes[i] == null) {
						poderes[i] = new Poder();
						break;
					}
				}
			} else {
				contadorinvocar++;
			}
			for (int i = 0; i < poderes.length; i++) {
				if (poderes[i] != null) {
					if (poderes[i].foipego(j)) {
						int qualpoder = poderes[i].qualpoder;
						if (qualpoder == 0) {
							contadorcafe++;
							pegoucafe = true;
						} else
						if (qualpoder == 1){
							contadoracucar++;
							pegouacucar = true;
						} else
						if (qualpoder == 2) {
							contadorrefrigerante++;
							j.vida = j.vida - 25;
						} else {
							contadoragua++;
							j.vida = j.vida + 25;
						}
						poderes[i] = null;
						if (pegoucafe && pegouacucar) {
							j.vida = j.vida + 50;
							pegoucafe = false;
							pegouacucar = false;
						}
					} else
					if (poderes[i].saiu) {
						poderes[i] = null;
					}
				}
			}
			for (int i = 0; i < poderes.length; i++) {
				if (poderes[i] != null) {
					poderes[i].update();
					poderes[i].draw(getGraphics2D());
				}
			}
		} else {
			desenharString("Você perdeu", 400, 100, Color.red, 30);
			desenharString("Quantidade de café coletado: " + contadorcafe, 400, 200, new Color(89, 52, 10), 20);
			desenharString("Quantidade de açucar coletado: " + contadoracucar, 400, 250, Color.white, 20);
			desenharString("Quantidade de refrigerante coletado: " + contadorrefrigerante, 400, 300, new Color(201, 126, 42), 20);
			desenharString("Quantidade de água coletada: " + contadoragua, 400, 350, Color.cyan, 20);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		j = new Jogador();
		poderes = new Poder[200];
		contadorinvocar = 0;
		contadorcafe = 0;
		contadoracucar = 0;
		contadorrefrigerante = 0;
		contadoragua = 0;
		pegoucafe = false;
		pegouacucar = false;
		// TODO Auto-generated method stub
		
	}
	
	public class Teclado extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
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
