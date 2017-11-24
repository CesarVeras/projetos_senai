package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class ChaoMovel extends Chao{
	
	private int movendo;

	public ChaoMovel(int posX, int posY, int width, int height, int velX,
			int velY, Image sprite) {
		super(posX, posY, width, height, sprite);
		setVelX(velX);
		setVelY(velY);
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
