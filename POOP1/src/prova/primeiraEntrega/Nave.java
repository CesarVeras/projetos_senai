package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Nave {
	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private int width;
	private int height;
	private int vidas;
	private boolean upPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean downPressed;

	public Nave(int width, int height, int velX, int velY) {
		this.velX = velX;
		this.velY = velY;
		this.height = height;
		this.width = width;
		this.vidas = 3;
		voltarAoInicio();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		if (posX <= 0) {
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

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
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

	public boolean isDownPressed() {
		return downPressed;
	}

	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}

	public void update() {
		if (upPressed) {
			setPosY(getPosY() - velY);
		}

		if (downPressed) {
			setPosY(getPosY() + velY);
		}

		if (leftPressed) {
			setPosX(getPosX() - velX);
		}

		if (rightPressed) {
			setPosX(getPosX() + velX);
		}
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(posX, posY, width, height);
	}

	public void voltarAoInicio() {
		setPosX(Utils.getInstance().getWidth() / 2 - width / 2);
		setPosY(Utils.getInstance().getHeight() - height - 100);

	}

	public void perderVida() {
		this.vidas--;
	}

	public boolean colisao(Inimigo i) {
		Rectangle naveHitBox = new Rectangle(posX, posY, width, height);
		Rectangle inimigoHitBox = new Rectangle(i.getPosX(), i.getPosY(),
				i.getWidth(), i.getHeight());
		if (naveHitBox.intersects(inimigoHitBox)) {
			perderVida();
			voltarAoInicio();
			return true;
		}
		return false;
	}
	
	public boolean colidiuComTiro(TiroChefe tc) {
		Rectangle naveHitBox = new Rectangle(posX, posY, width, height);
		Rectangle tHitBox = new Rectangle(tc.getPosX(), tc.getPosY(),
				tc.getWidth(), tc.getHeight());
		return (naveHitBox.intersects(tHitBox));
	}
	
	public boolean colisao(TiroChefe tc) {
		if (colidiuComTiro(tc)) {
			perderVida();
			voltarAoInicio();
			return true;
		}
		return false;
	}
}
