package heranca.versaoProfessor;

import java.awt.Color;
import java.awt.Graphics2D;

public class ElementoMovel {

	private int x;
	private int y;
	private int velX;
	private int velY;
	private int width;
	private int height;

	public ElementoMovel(int x, int y, int velX, int velY, int width, int height) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, velX, velY);
	}
	
	public void update() {
		this.x += this.velX;
		this.y += this.velY;
	}

}
