package spriteSheet.correcaoProfessor;

import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Cubo extends Coletavel {
	private int limiteMovimento;
	private int movimento;
	private boolean goingLeft;
	private static Random r = new Random();
	
	public Cubo() {
		super(r.nextInt(Utils.getInstance().getWidth() - 32), 0 - 32,
				GameSettings.GRAVIDADE, 32, 32, false, true,
				"imagem/items.png");
		limiteMovimento = 20;
		goingLeft = r.nextBoolean();
		movimento = 0;
	}

	@Override
	public void draw(Graphics2D g) {
		if (!coletado) {
			g.drawImage(imagem, x, y, x + width, y + width, 7 * width,
					7 * height, 7 * width + width, 7 * height + height , null);
		}
	}

	@Override
	public void update() {
		if (gravidadeHabitada) {
			y += velY;
			if (goingLeft) {
				if (movimento > -limiteMovimento) {
					x -= 5;
				}
			} else {
				if (movimento < limiteMovimento) {
					x += 5;
				}
			}
		}
	}
}
