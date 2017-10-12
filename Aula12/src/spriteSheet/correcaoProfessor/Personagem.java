package spriteSheet.correcaoProfessor;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Utils;

public class Personagem {

	private Image sprite;
	private Image aura;
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int frameX;
	private int frameY;
	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean gravidadeHabilitada;
	private boolean pulando;
	private boolean colidindo;
	private boolean pisou;
	private int quantidadePulo;
	private boolean wasLeft;
	private Coletavel c;

	public Personagem() {
		sprite = Utils.getInstance().loadImage("imagem/sonic.png");
		aura = Utils.getInstance().loadImage("imagem/aura.png");
		width = 119;
		height = 112;
		x = 50;
		y = 500;
		frameX = 0;
		frameY = 0;
		velX = 20;
		gravidadeHabilitada = true;
	}

	public void colisao(InimigoNoChao i) {
		if (this.getRectangle().intersects(i.getRectangle())) {
			if (y + height <= i.getY() + 10) {
				pisou = true;
				colidindo = false;
			} else {
				colidindo = true;
			}
		} else {
			colidindo = false;
		}
	}

	public void colisao(Chao chao) {
		if (this.getRectangle().intersects(chao.getRectangle())) {
			gravidadeHabilitada = false;
			pulando = false;
			quantidadePulo = 0;
		} else {
			gravidadeHabilitada = true;
		}
	}
	
	public void coletouPowerUp(Coletavel c) {
		this.c = c;
	}

	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

	public void update() {
		if (gravidadeHabilitada && !pulando) {
			y += GameSettings.GRAVIDADE;
		}

		if (pulando) {
			if (quantidadePulo < 15) {
				y -= GameSettings.GRAVIDADE;
				quantidadePulo++;
			} else {
				y += GameSettings.GRAVIDADE;
			}
		}

		if (c == null) {
			updatePadrao();
		} else {
			updatePowerUp();
		}
	}

	private void updatePadrao() {
		if (!leftPressed && !rightPressed) {
			if (wasLeft) {
				frameY = 0;
				frameX = 1;
			} else {
				frameY = 0;
				frameX = 0;
			}
		} else {
			if (!colidindo) {
				if (leftPressed) {
					frameY = 2;
					x -= velX;
					if (frameX == 0) {
						frameX = 7;
					} else {
						frameX--;
					}
				} else {
					frameY = 1;
					x += velX;
					if (frameX == 7) {
						frameX = 0;
					} else {
						frameX++;
					}
				}
			}
		}
	}

	public void updatePowerUp() {
		updatePadrao();
		c.setFrameY(0);
		if (c.getFrameX() == 2) {
			c.setFrameX(0);
		} else {
			c.setFrameX(c.getFrameX() + 1);
		}
	}

	public void draw(Graphics2D g) {
		if (c != null) {
			g.drawImage(aura, x - 20, y - 30, x + width + 20, y + height - 5,
					c.getFrameX() * 233, c.getFrameY() * 276,
					c.getFrameX() * 233 + 233, c.getFrameY() * 276 + 276, null);
		}
		g.drawImage(sprite, x, y, x + width, y + height, frameX * width, frameY
				* height, frameX * width + width, frameY * height + height,
				null);

	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

	public boolean isUpPressed() {
		return upPressed;
	}

	public void setUpPressed(boolean upPressed) {
		this.upPressed = upPressed;
	}

	public boolean isDownPressed() {
		return downPressed;
	}

	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public boolean isGravidadeHabilitada() {
		return gravidadeHabilitada;
	}

	public void setGravidadeHabilitada(boolean gravidadeHabilitada) {
		this.gravidadeHabilitada = gravidadeHabilitada;
	}

	public boolean isPulando() {
		return pulando;
	}

	public void setPulando(boolean pulando) {
		this.pulando = pulando;
	}

	public boolean getPisou() {
		return pisou;
	}

	public void setWasLeft(boolean wasLeft) {
		this.wasLeft = wasLeft;
	}
}
