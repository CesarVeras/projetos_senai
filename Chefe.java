package jogo;

import java.awt.Image;

public class Chefe extends Inimigo{

	public Chefe(int posX, int posY, int width, int height, int velX, int velY,
			Image sprite, int colunas, int linhas, int vidas) {
		super(posX, posY, width, height, velX, velY, sprite, colunas, linhas, vidas);
	}

	@Override
	public void update() {
		
	}
	
}
