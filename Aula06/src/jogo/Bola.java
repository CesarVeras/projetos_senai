package jogo;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Bola {
	private int posicaoX;
	private int posicaoY;
	private int altura;
	private int largura;
	private int velocidadeX;
	private int velocidadeY;
	private int pontosP1;
	private int pontosP2;
	private boolean goingUp;
	private boolean goingDown;
	private boolean goingRight;
	private boolean goingLeft;

	public Bola(int posicaoX, int posicaoY, int altura, int largura,
			int velocidadeX, int velocidadeY) {
		super();
		setPosicaoX(posicaoX);;
		setPosicaoY(posicaoY);
		this.altura = altura;
		this.largura = largura;
		this.velocidadeX = velocidadeX;
		this.velocidadeY = velocidadeY;
		this.pontosP1 = 0;
		this.pontosP2 = 0;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		if (posicaoX < 0) {
			this.posicaoX = 0;
		} else if (posicaoX + largura > Utils.getInstance().getWidth()) {
			this.posicaoX = Utils.getInstance().getWidth() - largura;
		} else {
			this.posicaoX = posicaoX;
		}
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		if (posicaoY < 0) {
			this.posicaoY = 0;
		} else if (posicaoY + altura > Utils.getInstance().getHeight()) {
			this.posicaoY = Utils.getInstance().getHeight() - altura;
		} else {
			this.posicaoY = posicaoY;
		}
		this.posicaoY = posicaoY;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getVelocidadeX() {
		return velocidadeX;
	}

	public void setVelocidadeX(int velocidadeX) {
		this.velocidadeX = velocidadeX;
	}

	public int getVelocidadeY() {
		return velocidadeY;
	}

	public void setVelocidadeY(int velocidadeY) {
		this.velocidadeY = velocidadeY;
	}

	public int getPontosP1() {
		return pontosP1;
	}

	public void setPontosP1(int pontosP1) {
		this.pontosP1 = pontosP1;
	}

	public int getPontosP2() {
		return pontosP2;
	}

	public void setPontosP2(int pontosP2) {
		this.pontosP2 = pontosP2;
	}

	public boolean isGoingUp() {
		return goingUp;
	}

	public void setGoingUp(boolean goingUp) {
		this.goingUp = goingUp;
	}

	public boolean isGoingDown() {
		return goingDown;
	}

	public void setGoingDown(boolean goingDown) {
		this.goingDown = goingDown;
	}

	public boolean isGoingRight() {
		return goingRight;
	}

	public void setGoingRight(boolean goingRight) {
		this.goingRight = goingRight;
	}

	public boolean isGoingLeft() {
		return goingLeft;
	}

	public void setGoingLeft(boolean goingLeft) {
		this.goingLeft = goingLeft;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillOval(posicaoX, posicaoY, largura, altura);
	}

	public void update(Barra be, Barra bd) {
		if (goingUp) {
			setPosicaoY(getPosicaoY() - velocidadeY);
		}
		if (goingDown) {
			setPosicaoY(getPosicaoY() + velocidadeY);
		}
		if (goingLeft) {
			setPosicaoX(getPosicaoX() - velocidadeX);
		}
		if (goingRight) {
			setPosicaoX(getPosicaoX() + velocidadeX);
		}

		colidir(be, bd);
	}

	public void colidir(Barra be, Barra bd) {
		if (goingUp) {
			if (goingLeft) {
				// UP + LEFT

				// bater na parede esquerda
				if (posicaoX == 0) {
					setPosicaoX(Utils.getInstance().getWidth()/2);
					setPosicaoY(Utils.getInstance().getHeight()/2);
					setGoingUp(false);
					setGoingLeft(false);
					setGoingDown(true);
					setGoingRight(true);
					pontosP2++;
				} else
				// bater na barra esquerda
				if ((posicaoX == be.getPosicaoX() + be.getLargura()) && (posicaoY + altura >= be.getPosicaoY() && posicaoY + altura <= be.getPosicaoY() + be.getAltura())) {
					goingLeft = false;
					goingRight = true;
				} else
				// bater no teto
				if (posicaoY == 0) {
					goingUp = false;
					goingDown = true;
				}
			} else {
				// UP + RIGHT
				
				// bater na parede direita
				if (posicaoX + largura == Utils.getInstance().getWidth()) {
					setPosicaoX(Utils.getInstance().getWidth()/2);
					setPosicaoY(Utils.getInstance().getHeight()/2);
					setGoingUp(false);
					setGoingRight(false);
					setGoingDown(true);
					setGoingLeft(true);
					pontosP1++;
				} else
				// bater na barra direita
				if ((posicaoX + largura == bd.getPosicaoX()) && (posicaoY + altura >= bd.getPosicaoY() && posicaoY + altura <= bd.getPosicaoY() + bd.getAltura())) {
					setGoingRight(false);
					setGoingLeft(true);
				} else 
				// bater no teto
				if (posicaoY == 0) {
					setGoingUp(false);
					setGoingDown(true);
				}
			}
		} else {
			if (goingLeft) {
				// DOWN + LEFT
				
				// bater na parede esquerda
				if (posicaoX == 0) {
					setPosicaoX(Utils.getInstance().getWidth()/2);
					setPosicaoY(Utils.getInstance().getHeight()/2);
					setGoingDown(false);
					setGoingLeft(false);
					setGoingUp(true);
					setGoingLeft(true);
					pontosP2++;
				} else
				// bater na barra esquerda
				if ((posicaoX == be.getPosicaoX() + be.getLargura()) && (posicaoY + altura >= be.getPosicaoY() && posicaoY + altura <= be.getPosicaoY() + be.getAltura())) {
					setGoingLeft(false);
					setGoingRight(true);
				} else 
				// bater no chao
				if (posicaoY + altura == Utils.getInstance().getHeight()) {
					setGoingDown(false);
					setGoingUp(true);
				}
			} else {
				// DOWN + RIGHT
				
				// bater na parede direita
				if (posicaoX + largura == Utils.getInstance().getWidth()) {
					setPosicaoX(Utils.getInstance().getWidth()/2);
					setPosicaoY(Utils.getInstance().getHeight()/2);
					setGoingDown(false);
					setGoingRight(false);
					setGoingUp(true);
					setGoingLeft(true);
					pontosP1++;
				} else 
				// bater na barra direita
				if ((posicaoX + largura == bd.getPosicaoX()) && (posicaoY + altura >= bd.getPosicaoY() && posicaoY  + altura <= bd.getPosicaoY() + bd.getAltura())) {
					setGoingRight(false);
					setGoingLeft(true);
				} else 
				// bater no chao
				if (posicaoY + altura == Utils.getInstance().getHeight()) {
					setGoingDown(false);
					setGoingUp(true);
				}
			}
		}
	}
}
