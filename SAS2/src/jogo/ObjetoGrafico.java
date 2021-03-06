package jogo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class ObjetoGrafico {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velX;
	private int velY;
	private Image sprite;
	
	public ObjetoGrafico(int posX, int posY, int width, int height, int velX,
			int velY, Image sprite) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;
		this.sprite = sprite;
	}
	public abstract void draw(Graphics2D g);
	public void update() {
		System.out.println("M�todo fora de uso em classes do tipo " + getClass());
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(posX, posY, width, height);
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}	
}
