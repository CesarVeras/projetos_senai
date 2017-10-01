package heranca.abstracao;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Tiro extends ElementoMovel{

	public Tiro(int x, int y) {
		super(x, y, 0, 5, 2, 5);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void update() {
		setY(getY() - getVelY());
	}
	
	public boolean colisao() {
		if (getY() + getHeight() >= Utils.getInstance().getHeight()) {
			
		}
		return false;
	}

}
