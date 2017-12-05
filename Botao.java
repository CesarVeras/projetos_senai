package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class Botao extends ObjetoGrafico {

	public Botao(int posX, int posY, int width, int height,
			Image sprite) {
		super(posX, posY, width, height, 0, 0, sprite);
	}

	public boolean click(int x, int y) {
		return ((x >= getPosX() && x <= getPosX() + getWidth()) 
				&& (y >= getPosY() && y <= getPosY() + getHeight()));
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getWidth(), getHeight(), null);
	}
}
