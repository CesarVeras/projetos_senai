package prova.correcao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class TiroChefe {

	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velY;
	private Image imagem;

	public TiroChefe(int posX, int posY) {
		width = 6;
		height = 12;
		velY = 8;
		this.posX = posX - width / 2;
		this.posY = posY;
		imagem = Utils.getInstance().loadImage("images/tiroChefe.png");
	}

	public void draw(Graphics2D g) {
//		g.setColor(Color.MAGENTA);
//		g.fillRect(posX, posY, width, height);
		g.drawImage(imagem, posX, posY, width + 10, height + 10, null);
	}

	public void update() {
		posY += velY;
	}
	
	public boolean colisao() {
		if (posY > Utils.getInstance().getHeight()) {
			return true;
		}
		return false;
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

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
}
