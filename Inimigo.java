package jogo;

import java.awt.Image;

public abstract class Inimigo extends ObjetoVivo{
	private int moving;

	public Inimigo(int posX, int posY, int width, int height, int velX,
			int velY, Image sprite, int colunas,
			int linhas, int vidas) {
		super(posX, posY, width, height, velX, velY, sprite, colunas, linhas, vidas);
	}

	public void setMoving(int moving) {
		this.moving = moving;
	}

	public int getMoving() {
		return moving;
	}
}
