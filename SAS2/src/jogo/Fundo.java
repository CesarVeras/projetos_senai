package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class Fundo extends ObjetoGraficoMovel {
	
	private int movendo; // 0 - parado; 1 - direita; -1 - esquerda;
	
	public Fundo(int posX, int posY, int width, int height, Image sprite, int velX, int velY) {
		super(posX, posY, width, height, sprite, velX, velY);
	}

	@Override
	public void update() {
		if (movendo == 1) {
			setPosX(getPosX() + getVelX());
		} 
		if (movendo == -1){
			setPosX(getPosX() - getVelX());
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX() - getWidth(), getPosY(), getWidth(), getHeight(), null);
		g.drawImage(getSprite(), getPosX(), getPosY(), getWidth(), getHeight(), null);
		g.drawImage(getSprite(), getPosX() + getWidth(), getPosY(), getWidth(), getHeight(), null);
	}

	public int getMovendo() {
		return movendo;
	}

	public void setMovendo(int movendo) {
		this.movendo = movendo;
	}
}
