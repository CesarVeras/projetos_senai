package jogo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class ObjetoGrafico {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Image sprite;
	
	public ObjetoGrafico(int posX, int posY, int width, int height, Image sprite) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public void draw(Graphics2D g) {
		g.drawImage(sprite, posX, posY, null);
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

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
}
