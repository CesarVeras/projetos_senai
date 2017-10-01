package heranca.versaoProfessor;

import java.awt.Rectangle;

public class Enemy extends ElementoMovel {

	private int vida;

	public Enemy(int x, int y, int velX, int velY, int width, int height,
			int vida) {
		super(x, y, velX, velY, width, height);
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean colisao(Nave nave) {
		Rectangle rectNave = new Rectangle(nave.getX(), nave.getY(),
				nave.getWidth(), nave.getHeight());
		Rectangle rectBoss = new Rectangle(getX(), getY(), getWidth(),
				getHeight());
		if (rectNave.intersects(rectBoss)) {
			nave.setLife(nave.getLife() - 1);
			nave.reset();
			vida--;
			return true;
		}
		return false;
	}

	public boolean colisao(Tiro[] tiro) {
		Rectangle rectBoss = new Rectangle(getX(), getY(), getWidth(),
				getHeight());
		for (int i = 0; i < tiro.length; i++) {
			if (tiro[i] != null) {
				Rectangle rectTiro = new Rectangle(tiro[i].getX(),
						tiro[i].getY(), tiro[i].getWidth(), tiro[i].getHeight());
				if (rectTiro.intersects(rectBoss)) {
					vida--;
					tiro[i] = null;
					return true;
				}
			}
		}
		return false;
	}

}
