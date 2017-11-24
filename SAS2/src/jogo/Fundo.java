package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

public class Fundo extends ObjetoGrafico {
	private int pontoMaximoEsquerdo;
	private int pontoMaximoDireito;
	private boolean atingiuPontoMaximo;

	private int movendo; // 0 - parado; 1 - direita; -1 - esquerda;

	public Fundo(int posX, int posY, int width, int height, Image sprite,
			int velX, int velY) {
		super(posX, posY, width, height, velX, velY, sprite);
		pontoMaximoEsquerdo = getPosX() - 2 * getWidth();
		pontoMaximoDireito = getPosX() + 3 * getWidth();
	}

	@Override
	public void update() {
		if (movendo == 1) {
			if (getPosX() + getWidth() < pontoMaximoDireito) {
				setPosX(getPosX() + getVelX());
				atingiuPontoMaximo = false;
			} else {
				atingiuPontoMaximo = true;
			}
		}
		if (movendo == -1) {
			if (getPosX() > pontoMaximoEsquerdo) {
				setPosX(getPosX() - getVelX());
				atingiuPontoMaximo = false;
			} else {
				atingiuPontoMaximo = true;
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX() - 2 * getWidth(), getPosY(),
				getWidth(), getHeight(), null);
		g.drawImage(getSprite(), getPosX() - getWidth(), getPosY(), getWidth(),
				getHeight(), null);
		g.drawImage(getSprite(), getPosX(), getPosY(), getWidth(), getHeight(),
				null);
		g.drawImage(getSprite(), getPosX() + getWidth(), getPosY(), getWidth(),
				getHeight(), null);
		g.drawImage(getSprite(), getPosX() + 2 * getWidth(), getPosY(),
				getWidth(), getHeight(), null);
	}

	public int getMovendo() {
		return movendo;
	}

	public void setMovendo(int movendo) {
		this.movendo = movendo;
	}
	
	public boolean isAtingiuPontoMaximo() {
		return atingiuPontoMaximo;
	}
}