package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class ChaoMovel extends ObjetoGraficoMovel{
	
	private int movendo;
	
	public ChaoMovel(int posX, int posY, int width, int height, Image sprite, int velX, int velY) {
		super(posX, posY, width, height, sprite, velX, velY);
	}

	@Override
	public void update() {
		if (movendo == 1) {
			setPosX(getPosX() + getVelX());
		} else {
			setPosX(getPosX() - getVelX());
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getWidth(), getHeight(), null);
	}
}
