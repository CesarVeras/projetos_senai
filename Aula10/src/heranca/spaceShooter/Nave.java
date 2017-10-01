package heranca.spaceShooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Nave extends Personagem {

	private int velY;
	private boolean downPressed;
	private boolean upPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private TiroNave[] tiros;

	public Nave() {
		setWidth(40);
		setHeight(60);
		setVelX(4);
		velY = 4;
		setVidas(3);
		tiros = new TiroNave[200];
		resetarPosicao();
	}

	public void resetarPosicao() {
		setPosX(Utils.getInstance().getWidth() / 2 - getWidth() / 2);
		setPosY(Utils.getInstance().getHeight() - getHeight());
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
		for (TiroNave tiro : tiros) {
			if (tiro != null) {
				tiro.draw(g);
			}
		}
	}

	public void update() {
		if (upPressed) {
			setPosY(getPosY() - velY);
		} else if (downPressed) {
			setPosY(getPosY() + velY);
		}

		if (rightPressed) {
			setPosX(getPosX() + getVelX());
		} else if (leftPressed) {
			setPosX(getPosX() - getVelX());
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
		setVidas(getVidas() - 1);
	}

	public void atirar() {
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] == null) {
				tiros[i] = new TiroNave(getPosX() + getWidth() / 2, getPosY());
				break;
			}
		}
	}

	public void colisao(TiroChefe[] tiros) {
		Rectangle nHitBox = new Rectangle(getPosX(), getPosY(), getWidth(),
				getHeight());
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

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
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

	public TiroNave[] getTiros() {
		return tiros;
	}

	public void setTiros(TiroNave[] tiros) {
		this.tiros = tiros;
	}
}
