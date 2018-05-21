package rec;

import java.awt.Color;
import java.awt.Graphics2D;

public class Refrigerante extends Coletavel{

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(201, 126, 42));
		g.fillOval(posX, posY, largura, altura);
	}
}
