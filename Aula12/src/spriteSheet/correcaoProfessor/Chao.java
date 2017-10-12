package spriteSheet.correcaoProfessor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Chao {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Chao() {
		width = Utils.getInstance().getWidth();
		height = 40; 
		x = 0;
		y = Utils.getInstance().getHeight() - height;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
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
