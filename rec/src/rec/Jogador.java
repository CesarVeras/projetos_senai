package rec;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Jogador extends ObjetoGrafico{
	
	protected double vida;
	protected int movendo;

	public Jogador() {
		super(0, 0, 10, 0, 50, 50);
		voltaProMeio();
		vida = 100;
	}

	private void voltaProMeio() {
		posX = Utils.getInstance().getWidth() / 2;
		posY = 650;
	}
	

	@Override
	public void update() {
		if (movendo == 1) {
			if (posX + 50 < Utils.getInstance().getWidth()) {
				posX = posX + velocidadeX;
			}
		} else if (movendo == -1) {
			if (posX > 0) {
				posX = posX - velocidadeX;
			}
		}
		
		if (vida > 0) {
			vida = vida - 0.5;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(posX, posY, largura, altura);
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}
	
	public int getMovendo() {
		return movendo;
	}

	public void setMovendo(int movendo) {
		this.movendo = movendo;
	}
}
