package spriteSheet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Chao extends ElementoEstatico {

	public Chao(int x, int y, int width, int height, Image imagem, int frameX, int frameY) {
		super(x, y, width, height, imagem, frameX, frameY);
	}

	public Chao() {
		super();
	}

	@Override
	public void draw(Graphics2D g) {
		if (getImagem() == null) {
			g.setColor(new Color(150, 209, 83, 255));
			g.fillRect(getX(), getY(), Utils.getInstance().getWidth(), Utils.getInstance().getHeight());
			g.setColor(new Color(89, 66, 28, 255));
			g.fillRect(getX(), getY() + 30, Utils.getInstance().getWidth(), 800);
			g.setColor(new Color(69, 125, 160, 255));
			g.fillOval(0, (Utils.getInstance().getHeight() / 2 - 111 / 2 + 111 + 50),
					Utils.getInstance().getWidth(), 800);
		} else {
			if (isSpriteSheet()) {
				g.drawImage(getImagem(), getX(), getY(), getX() + getWidth(), getY() + getHeight(),
						getFrameX() * getWidth(), getFrameY() * getHeight(), getFrameX() * getWidth() + getWidth(),
						getFrameY() * getHeight() + getHeight(), null);
			} else {
				g.drawImage(getImagem(), getX(), getY(), getWidth(), getHeight(), null);
			}
		}
	}

	@Override
	public void update() {
		if (isSpriteSheet() && getImagem() != null) {
		}
	}
}
