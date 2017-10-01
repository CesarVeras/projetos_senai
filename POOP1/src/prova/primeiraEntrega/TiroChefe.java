package prova.primeiraEntrega;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class TiroChefe extends Tiro {
	private int velY;

	public TiroChefe(int velY, int width, int height) {
		super(velY, width, height);
		this.velY = velY;
	}
	
	public void update() {
		setPosY(getPosY() + velY);
	}
	
	public boolean saiuDaTela() {
		return (getPosY() + getHeight() == Utils.getInstance().getHeight());
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
}
