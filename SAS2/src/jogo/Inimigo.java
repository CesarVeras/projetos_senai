package jogo;

import java.awt.Image;

public abstract class Inimigo extends ObjetoVivo{
	private int movendo;

	public Inimigo(int posX, int posY, int width, int height, int velX,
			int velY, Image sprite, int colunas,
			int linhas, int vidas) {
		super(posX, posY, width, height, velX, velY, sprite, colunas, linhas, vidas);
	}

	public void setMoving(int moving) {
		this.movendo = moving;
	}

	public int getMoving() {
		return movendo;
	}
}
