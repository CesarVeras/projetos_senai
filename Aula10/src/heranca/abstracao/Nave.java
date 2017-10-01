package heranca.abstracao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Nave extends ElementoMovel{
	
	private int vidas;
	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private Tiro[] tiros;
	
	public Nave() {
		super(0, 0, 5, 5, 20, 50);
		this.vidas = 3;
		tiros = new Tiro[200];
		reset();
	}
	
	public void reset() {
		setX((Utils.getInstance().getWidth() / 2) - (getWidth() / 2));
		setY((Utils.getInstance().getHeight() - getHeight()));
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString(String.valueOf(vidas), 50, 50);
		
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].draw(g);
			}
		}
	}

	@Override
	public void update() {
		if (upPressed) {
			//Up
			setY(getY() - getVelY());
		} else if (downPressed) {
			//Down
			setY(getY() + getVelY());
		}
		
		if (rightPressed) {
			//Right
			setX(getX() + getVelX());
		} else if (leftPressed) {
			//Left
			setX(getX() - getVelX());
		}
		
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null && tiros[i].colisao()) {
				tiros[i] = null;
			} else if (tiros[i] != null) {
				tiros[i].update();
			}
		}
		
	}
	
	public void atirar() {
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] == null) {
				Tiro t = new Tiro(getX(), getY());
				tiros[i] = t;
				break;
			}
		}
	}
	
	public void colisao(Tiro[] tiros) {
		Rectangle rectNave = new Rectangle(getX(), getY(), getWidth(), getHeight());
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				Rectangle rectTiro = new Rectangle(tiros[i].getX(), tiros[i].getY(), tiros[i].getWidth(), tiros[i].getHeight());
				if (rectNave.intersects(rectTiro)) {
					vidas--;
					reset();
					tiros[i] = null;
				}
			}
		}
	}
	
	public boolean colisao(Enemy enemy) {
		Rectangle rectEnemy = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
		Rectangle rectNave = new Rectangle(getX(), getY(), getWidth(), getHeight());
		if (rectEnemy.intersects(rectNave)) {
			vidas--;
			reset();
			return true;
		}
		return false;
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
	public Tiro[] getTiros() {
		return tiros;
	}	
}
