package heranca.versaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Boss extends Enemy {

	private Tiro[] tiros;

	public Boss() {
		super((Utils.getInstance().getWidth()/2) - 50, 30, 7, 0, 100, 30, 10);
		this.tiros = new Tiro[200];
	}

	public Tiro[] getTiros() {
		return tiros;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.PINK);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString(String.valueOf(getVida()), Utils.getInstance().getWidth()-50, 50);
		
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null) {
				tiros[i].draw(g);
			}
		} 
	}

	@Override
	public void update() {
		super.update();
		addTiro();
		
		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i] != null && tiros[i].colisao()) {
				tiros[i] = null;
			} else if (tiros[i] != null) {
				tiros[i].update();
			}
		}
	}

	private void addTiro() {
		Random random = new Random();
		int sort = random.nextInt(20);
		if (sort == 10) {
			for (int i = 0; i < tiros.length; i++) {
				if (tiros[i] == null) {
					Tiro tiro = new Tiro(getX(), getY());
					tiro.setVelY(tiro.getVelY() * -1);
					tiros[i] = tiro;
					break;
				}
			}
		}
	}

	public void colisao() {
		if (getX() <= 0 || getX() + getWidth() >= Utils.getInstance().getWidth()) {
			setVelX(getVelX()*-1);
		}
	}
}
