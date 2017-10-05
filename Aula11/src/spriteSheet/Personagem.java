package spriteSheet;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import br.senai.sc.engine.Utils;

public class Personagem {
	private int x;
	private int y;
	private int width;
	private int height;
	private int frameX;
	private int frameY;
	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean jumping;
	private Image imagem;
	private int yBase;
	
	public Personagem(int x, int y, int width, int height, int frameX, int frameY, String caminho) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frameX = frameX;
		this.frameY = frameY;
		imagem = Utils.getInstance().loadImage("imagem/sonic.png");
	}

	public void draw(Graphics2D g) {
		g.drawImage(imagem, x, y, x + width, y + height, frameX * width, frameY * height, frameX * width + width,
				frameY * height + height, null);
	}

	public void update(boolean wasLeft) {
		if (leftPressed) {
			frameY = 2;
			if (frameX == 7) {
				frameX = 0;
			} else {
				frameX++;
			}
		} else if (rightPressed) {
			frameY = 1;
			if (frameX == 0) {
				frameX = 7;
			} else {
				frameX--;
			}
		} else {
			if (wasLeft) {
				frameY = 0;
				frameX = 1;
			} else {
				frameY = 0;
				frameX = 0;
			}
		}
		
		if (jumping) {
			if (y > 100) {
				y -= 20;
			} else {
				jumping = false;
			}
		}
	}
	
	public boolean estaNoChao() {
		return yBase == y;
	}
	
	public boolean colisao(Chao c) {
		Rectangle pHitBox = new Rectangle(x, y, width, height);
		Rectangle cHitBox = new Rectangle(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		if (pHitBox.intersects(cHitBox)) {
			yBase = y;
		}
		return pHitBox.intersects(cHitBox);
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

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
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

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
