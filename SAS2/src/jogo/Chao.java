package jogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Chao extends ObjetoGrafico{
	
	public Chao(int posX, int posY, int width, int height,
			Image sprite) {
		super(posX, posY, width, height, 0, 0, sprite);
	}

	@Override
	public void draw(Graphics2D g) {
		if (getSprite() == null) {
			g.setColor(Color.green);
			g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());			
		} else {
			g.drawImage(getSprite(), getPosX(), getPosY(), getWidth(), getHeight(), null);
		}
		
	}
}
