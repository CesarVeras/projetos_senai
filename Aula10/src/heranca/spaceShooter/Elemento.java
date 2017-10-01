package heranca.spaceShooter;

import java.awt.Color;
import java.awt.Graphics2D;

public class Elemento {
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	public Elemento() {
	}

	public Elemento(int posX, int posY, int width, int height) {
		setPosX(posX);
		setPosY(posY);
		setWidth(width);
		setHeight(height);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(posX, posY, width, height);
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
}
