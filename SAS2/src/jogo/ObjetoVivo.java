package jogo;

import java.awt.Image;

public class ObjetoVivo extends ObjetoAnimado{
	private int vidas;

	public ObjetoVivo(int posX, int posY, int width, int height, int velX,
			int velY, Image sprite, int colunas,
			int linhas, int vidas) {
		super(posX, posY, width, height, velX, velY, sprite, colunas, linhas);
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}
