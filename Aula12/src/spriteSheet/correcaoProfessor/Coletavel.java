package spriteSheet.correcaoProfessor;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public abstract class Coletavel {
	protected int x;
	protected int y;
	protected int velY;
	protected int width;
	protected int height;
	protected boolean coletado;
	protected boolean gravidadeHabitada;
	protected Image imagem;
	protected int frameX;
	protected int frameY;

	public Coletavel(int x, int y, int velY, int width, int height,
			boolean coletado, boolean gravidadeHabitada, String caminho) {
		this.x = x;
		this.y = y;
		this.velY = velY;
		this.width = width;
		this.height = height;
		this.coletado = coletado;
		this.gravidadeHabitada = gravidadeHabitada;
		imagem = Utils.getInstance().loadImage(caminho);
	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract void update();
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height + 10);
	}
	
	public void colisao(Personagem p) {
		if (this.getRectangle().intersects(p.getRectangle())) {
			coletado = true;
		}
	}
	
	public void colisao(Chao c) {
		if (this.getRectangle().intersects(c.getRectangle())) {
			gravidadeHabitada = false;
		} else {
			gravidadeHabitada = true;
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

	public boolean isColetado() {
		return coletado;
	}

	public void setColetado(boolean coletado) {
		this.coletado = coletado;
	}

	public boolean isGravidadeHabitada() {
		return gravidadeHabitada;
	}

	public void setGravidadeHabitada(boolean gravidadeHabitada) {
		this.gravidadeHabitada = gravidadeHabitada;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
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
}
