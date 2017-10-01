package prova.correcao;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Inimigo {

	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velY;
	private Image imagem;

	public Inimigo(int velY) {
		width = 30;
		height = 30;
		this.velY = velY;
		posY = -height;
		Random r = new Random();
		posX = r.nextInt(Utils.getInstance().getWidth() - width + 1);
		imagem = Utils.getInstance().loadImage("images/asteroide.png");
	}

	public void draw(Graphics2D g) {
//		g.setColor(Color.BLUE);
		g.drawImage(imagem, posX, posY, width, height, null);
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

	public boolean colisao(Nave nave) {
		Rectangle nHitBox = new Rectangle(nave.getPosX(), nave.getPosY(),
				nave.getWidth(), nave.getHeight());

		Rectangle iHitBox = new Rectangle(posX, posY, width, height);

		if (nHitBox.intersects(iHitBox)) {
			nave.reset();
			return true;
		}
		return false;
	}

	public boolean colisao(Tiro[] tiros) {
		Rectangle iHitBox = new Rectangle(posX, posY, width, height);
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				Rectangle tHitBox = new Rectangle(tiros[i].getPosX(),
						tiros[i].getPosY(), tiros[i].getWidth(),
						tiros[i].getHeight());
				if (iHitBox.intersects(tHitBox)) {
					tiros[i] = null;
					return true;
				}
			}
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
