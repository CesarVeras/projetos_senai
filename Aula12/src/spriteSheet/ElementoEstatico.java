package spriteSheet;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public abstract class ElementoEstatico {
	private int X;
	private int Y;
	private int width;
	private int height;
	private Image imagem;
	private int frameX;
	private int frameY;
	private boolean SpriteSheet;
	
	public ElementoEstatico(int x, int y, int width, int height, Image imagem, int frameX, int frameY) {
		super();
		X = x;
		Y = y;
		this.width = width;
		this.height = height;
		this.imagem = imagem;
		this.frameX = frameX;
		this.frameY = frameY;
	}
	
	public ElementoEstatico() {
	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract void update();
	
	public void loadImage(String caminho) {
		Utils.getInstance().loadImage(caminho);
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
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

	public boolean isSpriteSheet() {
		return SpriteSheet;
	}

	public void setSpriteSheet(boolean isSpriteSheet) {
		this.SpriteSheet = isSpriteSheet;
	}
}
