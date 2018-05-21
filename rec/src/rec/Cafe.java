package rec;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cafe extends Coletavel{

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(89, 52, 10));
		g.fillOval(posX, posY, largura, altura);
	}
}
