package spriteSheet.correcaoProfessor;

import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Esfera extends Coletavel {

	private static Random r = new Random();

	public Esfera() {
		super(r.nextInt(Utils.getInstance().getWidth() - 32), 0 - 32,
				GameSettings.GRAVIDADE, 32, 32, false, true,
				"imagem/items.png");
	}

	@Override
	public void draw(Graphics2D g) {
		if (!coletado) {
			g.drawImage(imagem, x, y, x + width, y + width, 1 * width,
					7 * height, 1 * width + width, 7 * height + height, null);
		}
	}

	@Override
	public void update() {
		if (gravidadeHabitada) {
			y += velY;
		}
	}
}
