package rec;

import java.awt.Color;
import java.awt.Graphics2D;

public class Acucar extends Coletavel{

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval(posX, posY, largura, altura);
	}

}
