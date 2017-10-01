package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tiro {
	private int posX;
	private int posY;
	private int velY;
	private int width;
	private int height;

	public Tiro(int velY, int width, int height) {
		this.velY = velY;
		this.width = width;
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void definirPosicaoXY(Nave nave) {
		setPosX(nave.getPosX() + nave.getWidth() / 2 - width / 2);
		setPosY(nave.getPosY());
	}
	
	public void definirPosicaoXY(Chefe c) {
		setPosX(c.getPosX() + c.getWidth() / 2 - width / 2);
		setPosY(c.getPosY() + c.getHeight());
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect(posX, posY, width, height);
	}

	public void update() {
		setPosY(posY - velY);
	}

	public boolean colisao(Inimigo i) {
		Rectangle tiroHitBox = new Rectangle(posX, posY, width, height);
		Rectangle inimigoHitBox = new Rectangle(i.getPosX(),
				i.getPosY(), i.getWidth(), i.getHeight());
		if (tiroHitBox.intersects(inimigoHitBox)) {
			return true;
		}
		return false;
	}
	
	public boolean saiuDaTela() {
		return (posY == 0);
	}
}
