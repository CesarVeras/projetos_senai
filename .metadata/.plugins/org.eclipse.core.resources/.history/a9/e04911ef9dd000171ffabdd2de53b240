package jogo;

import java.awt.Image;

public abstract class ObjetoGraficoMovel extends ObjetoGrafico {

	private int velX;
	private int velY;

	public ObjetoGraficoMovel(int posX, int posY, int width, int height, Image sprite, int velX, int velY) {
		super(posX, posY, width, height, sprite);
		this.velX = velX;
		this.velY = velY;
	}

	public abstract void update();

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
}
