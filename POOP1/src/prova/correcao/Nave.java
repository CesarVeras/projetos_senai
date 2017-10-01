package prova.correcao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Nave {

	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velX;
	private int velY;
	private int vidas;
	private int upDown;
	private int rightLeft;
	private boolean downPressed;
	private boolean upPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private Image imagem;
	private Tiro[] tiros;

	public Nave() {
		width = 40;
		height = 60;
		velX = 4;
		velY = 4;
		vidas = 3;
		tiros = new Tiro[200];
		resetarPosicao();
		imagem = Utils.getInstance().loadImage("images/nave.png");
	}

	public Nave(int posX, int posY, int width, int height, int velX, int velY) {
		setPosX(posX);
		setPosY(posY);
		setWidth(width);
		setHeight(height);
		this.velX = velX;
		this.velY = velY;
		vidas = 3;
		tiros = new Tiro[200];
	}

	public void resetarPosicao() {
		posX = Utils.getInstance().getWidth() / 2 - width / 2;
		posY = Utils.getInstance().getHeight() - height;
	}

	public void draw(Graphics2D g) {
//		g.setColor(Color.WHITE);
		g.drawImage(imagem, posX, posY, width, height, null);
//		g.fillRect(posX, posY, width, height);
		for (Tiro tiro : tiros) {
			if (tiro != null) {
				tiro.draw(g);
			}
		}
	}

	public void update() {
		if (upPressed) {
			setPosY(posY - velY);
		} else if (downPressed) {
			setPosY(posY + velY);
		}

		if (rightPressed) {
			setPosX(posX + velX);
		} else if (leftPressed) {
			setPosX(posX - velX);
		}

		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].update();
				if (tiros[i].colisao()) {
					tiros[i] = null;
				}
			}
		}
	}

	public void reset() {
		resetarPosicao();
		vidas--;
	}

	public void atirar() {
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] == null) {
				tiros[i] = new Tiro(posX + width / 2, posY);
				break;
			}
		}
	}

	public void colisao(TiroChefe[] tiros) {
		Rectangle nHitBox = new Rectangle(posX, posY, width, height);
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				Rectangle tHitBox = new Rectangle(tiros[i].getPosX(),
						tiros[i].getPosY(), tiros[i].getWidth(),
						tiros[i].getHeight());
				if (nHitBox.intersects(tHitBox)) {
					reset();
					tiros[i] = null;
				}
			}
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		if (posX < 0) {
			this.posX = 0;
		} else if (posX + width > Utils.getInstance().getWidth()) {
			this.posX = Utils.getInstance().getWidth() - width;
		} else {
			this.posX = posX;
		}
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		if (posY < 0) {
			this.posY = 0;
		} else if (posY + height > Utils.getInstance().getHeight()) {
			this.posY = Utils.getInstance().getHeight() - height;
		} else {
			this.posY = posY;
		}
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

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getUpDown() {
		return upDown;
	}

	public void setUpDown(int upDown) {
		this.upDown = upDown;
	}

	public int getLeftRight() {
		return rightLeft;
	}

	public void setLeftRight(int leftRight) {
		this.rightLeft = leftRight;
	}

	public Tiro[] getTiros() {
		return tiros;
	}

	public boolean isDownPressed() {
		return downPressed;
	}

	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}

	public boolean isUpPressed() {
		return upPressed;
	}

	public void setUpPressed(boolean upPressed) {
		this.upPressed = upPressed;
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

}
