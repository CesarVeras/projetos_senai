package jogo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Atirador extends Inimigo {

	private boolean comecou;
	private boolean comecou2;
	private boolean andando;
	private int andandoInt;
	private boolean parou;

	public Atirador() {
		super(Utils.getInstance().getWidth() / 2 + 100, 600, 59, 85,
				Utils.getInstance().loadImage("imagens/soldado_novo.png"), 5, 0, 1, 0, 2, 3);
		comecou = false;
		comecou2 = false;
		andando = false;
		andandoInt = 0;

	}

	public Atirador(int posX, int posY, int width, int height, Image sprite, int velX, int velY, int frameX,
			int frameY) {
		super(posX, posY, width, height, Utils.getInstance().loadImage("imagens/soldado.png"), velX, velY, frameX,
				frameY, 3, 2);
		comecou = false;
		comecou2 = false;
		andando = false;
		andandoInt = 0;
	}

	@Override
	public void update() {
		if (getMoving() == -1) {
			setFrameY(2);
			setPosX(getPosX() - getVelX());
			setFrameX(getFrameX() + 1);
		} else if (getMoving() == 1) {
			setFrameY(1);
			setPosX(getPosX() + getVelX());
			setFrameX(getFrameX() + 1);
		}
		if (getFrameX() > getColunas()) {
			setFrameX(0);
		}
		// if (!andando && !comecou) {
		// andando();
		// }
		//
		// if (!comecou) {
		// atirando();
		// } else if (!comecou2) {
		// atirando2();
		// }
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(), getPosY() + getHeight(),
				getFrameX() * getWidth(), getFrameY() * getHeight(), getFrameX() * getWidth() + getWidth(),
				getFrameY() * getHeight() + getHeight(), null);
	}

	@Override
	public void setMoving(int moving) {
		if (moving != getMoving()) {
			if (moving == 0) {
				setFrameY(0);
				if (getMoving() == 1) {
					setFrameX(0);
				} else {
					setFrameX(1);
				}
			} else if (moving == 1) {
				setFrameY(2);
			} else {
				setFrameY(1);
			}
			super.setMoving(moving);
		}
		// if (getMoving() != moving) {
		// if (this.getMoving() == 1) {
		// setFrameX(0);
		// } else {
		// setFrameX(1);
		// }
		// super.setMoving(moving);
		// setFrameY(moving);
		// }
	}

	private void atirando() {
		Random aleatorio = new Random();
		int n = aleatorio.nextInt(101);
		if (n < 2) {
			comecou = true;
			setFrameX(0);
			setFrameY(2);
			n = aleatorio.nextInt(101);
			// comecou2 = true;
		}
	}

	private void atirando2() {
		Random aleatorio = new Random();
		int n = aleatorio.nextInt(101);
		if (n < 10) {
			comecou2 = true;
			setFrameX(1);
			setFrameY(2);
		}
	}

	private void andando() {
		if (!parou) {
			andandoInt += 3;
			setFrameX(0);
			setFrameY(0);
			setPosX(getPosX() + 3);
			if (andandoInt >= 110) {
				// andando = true;
				parou = true;
			}
		} else if (parou) {
			// System.out.println(andandoInt);
			andandoInt -= 3;
			setPosX(getPosX() - 3);
			setFrameX(1);
			setFrameY(0);
			if (andandoInt <= 0) {
				andando = false;
				parou = false;
			}
		}
	}

	public boolean isComecou() {
		return comecou;
	}

	public void setComecou(boolean comecou) {
		this.comecou = comecou;
	}

	public boolean isComecou2() {
		return comecou2;
	}

	public void setComecou2(boolean comecou2) {
		this.comecou2 = comecou2;
	}

	public boolean isAndando() {
		return andando;
	}

	public void setAndando(boolean andando) {
		this.andando = andando;
	}

	public int getAndandoInt() {
		return andandoInt;
	}

	public void setAndandoInt(int andandoInt) {
		this.andandoInt = andandoInt;
	}

	public boolean isParou() {
		return parou;
	}

	public void setParou(boolean parou) {
		this.parou = parou;
	}
}
