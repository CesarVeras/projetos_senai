package spriteSheet.correcaoProfessor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class InimigoNoChao {
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int movimentacao;
	private int limiteEsquerdo;
	private int limiteDireito;
	private boolean goingLeft;
	private boolean colidindo;

	public InimigoNoChao(int x, int y, int width, int height, int velX) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.movimentacao = 0;
		limiteEsquerdo = -60;
		limiteDireito = 60;
		Random r = new Random();
		goingLeft = r.nextBoolean();
		colidindo = true;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

	public void colisao(Personagem p) {
		if (this.getRectangle().intersects(p.getRectangle())) {
			colidindo = true;
		} else {
			colidindo = false;
		}
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		if (goingLeft) {
			if (!colidindo) {
				if (movimentacao > limiteEsquerdo) {
					movimentacao--;
					x -= velX;
				} else {
					goingLeft = false;
				}
			}
		} else {
			if (!colidindo) {
				if (movimentacao < limiteDireito) {
					movimentacao++;
					x += velX;
				} else {
					goingLeft = true;
				}
			}
		}
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

	public int getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(int movimentacao) {
		this.movimentacao = movimentacao;
	}
}
