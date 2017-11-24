package jogo;

import java.awt.Image;

public class Botao extends ObjetoGrafico {

	public Botao(int posX, int posY, int width, int height, Image sprite) {
		super(posX, posY, width, height, sprite);
	}

	public boolean click(int x, int y) {
		return ((x >= getPosX() && x <= getPosX() + getWidth()) 
				&& (y >= getPosY() && y <= getPosY() + getHeight()));
	}

}
