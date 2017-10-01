package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Inimigo {
	private int posX;
	private int posY;
	private int velY;
	private int width;
	private int height;
	
	public Inimigo(int posY, int velY, int width, int height) {
		setPosY(posY);
		this.velY = velY;
		this.width = width;
		this.height = height;
		gerarPosicaoX();
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		if (posX + width > Utils.getInstance().getWidth()) {
			this.posX = Utils.getInstance().getWidth() - width;
		} else {
			this.posX = posX;
		}
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		if (posY < 0) {
			this.posY = 0;
		} else if (posY + height > Utils.getInstance().getHeight()) {
			this.posY = Utils.getInstance().getHeight() - height;
		} else {
			this.posY = posY;
		}
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
	
	public void gerarPosicaoX() {
		Random r = new Random();
		setPosX(r.nextInt(Utils.getInstance().getWidth()+1));
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(posX, posY, width, height);
	}
	
	public void update() {
		setPosY(posY + velY);
	}
	
	public boolean saiuDaTela() {
		return (posY + height == Utils.getInstance().getHeight());
	}

}
