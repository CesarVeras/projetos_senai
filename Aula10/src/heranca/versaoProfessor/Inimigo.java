package heranca.versaoProfessor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Inimigo extends Enemy {

	public Inimigo() {
		super(0, -30, 0, 4, 20, 20, 1);
		Random random = new Random();
		setX(random.nextInt(Utils.getInstance().getWidth() - 20));
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		super.update();
	}
	
	public boolean colisao() {
		if (getY() + getHeight() > Utils.getInstance().getHeight()) {
			return true;
		}
		return false;
	}
	
}
