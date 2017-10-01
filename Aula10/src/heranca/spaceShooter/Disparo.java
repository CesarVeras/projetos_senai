package heranca.spaceShooter;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Disparo extends Elemento {

	private int velY;

	public Disparo() {
		super();
	}

	public Disparo(int posX, int posY, int width, int height, int velY) {
		super(posX, posY, width, height);
		setVelY(velY);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}

	public void update(boolean subir) {
		if (subir) {
			setPosY(getPosY() - velY);
		} else {
			setPosY(getPosY() + velY);
		}
	}
	
	public boolean colisao() {
		if (getPosY() + getHeight() >= Utils.getInstance().getHeight()) {
			return true;
		} else if (getPosY() <= 0) {
			return true;
		}
		return false;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
}
