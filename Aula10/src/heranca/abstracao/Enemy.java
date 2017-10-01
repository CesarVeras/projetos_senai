package heranca.abstracao;

import java.awt.Rectangle;

public abstract class Enemy extends ElementoMovel {

	private int vidas;

	public Enemy(int x, int y, int velX, int velY, int width, int height,
			int vidas) {
		super(x, y, velX, velY, width, height);
		this.vidas = vidas;
	}
	
	public boolean colisao(Nave nave) {
		Rectangle rectNave = new Rectangle(nave.getX(), nave.getY(),
				nave.getWidth(), nave.getHeight());
		Rectangle rectBoss = new Rectangle(getX(), getY(), getWidth(),
				getHeight());
		if (rectNave.intersects(rectBoss)) {
			nave.setVidas(nave.getVidas() - 1);
			nave.reset();
			vidas--;
			return true;
		}
		return false;
	}
	
	public boolean colisao(Tiro[] tiros) {
		Rectangle rectBoss = new Rectangle(getX(), getY(), getWidth(),
				getHeight());
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				Rectangle rectTiro = new Rectangle(tiros[i].getX(),
						tiros[i].getY(), tiros[i].getWidth(), tiros[i].getHeight());
				if (rectTiro.intersects(rectBoss)) {
					vidas--;
					tiros[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public abstract boolean colisao();

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}
