package prova.correcao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Chefe {

	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velX;
	private int vidas;
	private Image imagem;
	private TiroChefe[] tiros;

	public Chefe() {
		Random random = new Random();
		width = 60;
		height = 60;
		posY = 0;
		velX = 4;
		vidas = 10;
		posX = random.nextInt(Utils.getInstance().getWidth() - width);
		tiros = new TiroChefe[200];
		imagem = Utils.getInstance().loadImage("images/chefe.png");
	}

	public void draw(Graphics2D g) {
//		g.setColor(Color.RED);
//		g.fillRect(posX, posY, width, height);
		g.drawImage(imagem, posX, posY, width, height, null);	
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].draw(g);
			}
		}
	}

	public void update() {
		posX += velX;
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].update();
				if (tiros[i].colisao()) {
					tiros[i] = null;
				}
			}
		}
	}

	public void atirar() {
		Random r = new Random();
		if (r.nextInt(101) < 10) {
			for (int i = 0; i < tiros.length; i++) {
				if (tiros[i] == null) {
					tiros[i] = new TiroChefe(posX + width / 2, posY + height);
					break;
				}
			}
		}
	}

	public void colisao() {
		if (posX < 0) {
			velX *= -1;
		} else if (posX + width > Utils.getInstance().getWidth()) {
			velX *= -1;
		}
	}

	public boolean colisao(Tiro[] tiros) {
		Rectangle cHitBox = new Rectangle(posX, posY, width, height);
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				Rectangle tHitBox = new Rectangle(tiros[i].getPosX(),
						tiros[i].getPosY(), tiros[i].getWidth(),
						tiros[i].getHeight());
				if (cHitBox.intersects(tHitBox)) {
					vidas--;
					tiros[i] = null;
					if (vidas == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public TiroChefe[] getTiros() {
		return tiros;
	}
}
