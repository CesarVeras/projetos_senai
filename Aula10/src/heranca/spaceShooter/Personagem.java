package heranca.spaceShooter;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Personagem extends Elemento{
	
	private int vidas;
	private int velX;
	
	public Personagem() {
		super();
	}
	public Personagem(int posX, int posY, int width, int height, int vidas, int velX) {
		super(posX, posY, width, height);
		setVidas(vidas);
		setVelX(velX);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
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
	
	@Override
	public void setPosX(int posX) {
		if (posX <= 0) {
			setPosX(0);
		} else if (posX + getWidth() > Utils.getInstance().getWidth()) {
			setPosX(posX - getWidth());
		} else {
			super.setPosX(posX);
		}
	}
	
	@Override
	public void setPosY(int posY) {
		if (posY <= 0) {
			setPosY(0);
		} else if (posY + getHeight() > Utils.getInstance().getHeight()) {
			setPosY(posY - getHeight());
		} else {
			super.setPosY(posY);
		}
	}
}
