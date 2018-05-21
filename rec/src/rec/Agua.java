package rec;

import java.awt.Color;
import java.awt.Graphics2D;

public class Agua extends Coletavel{

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillOval(posX, posY, largura, altura);
	}
}
