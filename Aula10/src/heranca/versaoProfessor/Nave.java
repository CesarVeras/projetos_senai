package heranca.versaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Nave extends ElementoMovel {

	private int life;
	private int upDown;
	private int rightLeft;
	private Tiro[] tiros;

	public Nave() {
		super(0, 0, 5, 5, 20, 50);
		this.life = 3;
		tiros = new Tiro[200];
		reset();
	}

	@Override
	public void setX(int x) {
		if (x < 0) {
			super.setX(0);
		} else if (x + getWidth() > Utils.getInstance().getWidth()) {
			super.setX(Utils.getInstance().getWidth() - getWidth());
		} else {
			super.setX(x);
		}
	}

	@Override
	public void setY(int y) {
		if (y < 0) {
			super.setY(0);
		} else if (y + getHeight() > Utils.getInstance().getHeight()) {
			super.setY(Utils.getInstance().getHeight() - getHeight());
		} else {
			super.setY(y);
		}
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getUpDown() {
		return upDown;
	}

	public void setUpDown(int upDown) {
		this.upDown = upDown;
	}

	public int getRightLeft() {
		return rightLeft;
	}

	public void setRightLeft(int rightLeft) {
		this.rightLeft = rightLeft;
	}

	public Tiro[] getTiros() {
		return tiros;
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
		g.drawString(String.valueOf(life), 50, 50);
		
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].draw(g);
			}
		}
	}

	@Override
	public void update() {
		if (upDown == 1) {
			//Up
			setY(getY() - getVelY());
		} else if (upDown == -1) {
			//Down
			setY(getY() + getVelY());
		}
		
		if (rightLeft == 1) {
			//Right
			setX(getX() + getVelX());
		} else if (rightLeft == -1) {
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
					life--;
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
			life--;
			reset();
			return true;
		}
		return false;
	}

}
