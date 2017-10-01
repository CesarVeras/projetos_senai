package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Chefe extends Inimigo {
	private int vidas;
	private int velX;
	
	public Chefe(int posY, int velY, int width, int height, int vidas) {
		super(posY, velY, width, height);
		this.velX = velY;
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
	
	public void update() {
		setPosX(getPosX() + velX);
	}
	
	public void colisao() {
		if (getPosX() <= 0) {
			velX *= -1;
		}
		
		if (getPosX() + getWidth() == Utils.getInstance().getWidth()) {
			velX *= -1;
		}
	}
	
	public boolean colisao(Tiro t) {
		Rectangle tHitBox = new Rectangle(t.getPosX(), t.getPosY(), t.getWidth(), t.getHeight());
		Rectangle cHitBox = new Rectangle(getPosX(), getPosY(), getWidth(), getHeight());
		if (tHitBox.intersects(cHitBox)) {
			vidas--;
			if (vidas == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean colidiuComTiro(Tiro t) {
		Rectangle tHitBox = new Rectangle(t.getPosX(), t.getPosY(), t.getWidth(), t.getHeight());
		Rectangle cHitBox = new Rectangle(getPosX(), getPosY(), getWidth(), getHeight());
		return tHitBox.intersects(cHitBox);
	}
}