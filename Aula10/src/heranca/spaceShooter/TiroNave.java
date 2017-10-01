package heranca.spaceShooter;

import java.awt.Color;
import java.awt.Graphics2D;

public class TiroNave extends Disparo{

	public TiroNave() {
		super();
	}

	public TiroNave(int posX, int posY) {
		super(posX - 3, posY, 6, 12, 8);
	}

	public void update() {
		super.update(true);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
}
