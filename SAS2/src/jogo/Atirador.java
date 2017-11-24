package jogo;

import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class Atirador extends Inimigo {
	private boolean atirando;
	private int contadorAtirar;
	private int contadorAbaixar;
	private boolean baixarArma;
	private int viradoPara;

	public Atirador() {
		super(Utils.getInstance().getWidth() / 2 + 100, 705, 59, 85, 5, 5,
				Utils.getInstance().loadImage("imagens/soldado_novo.png"), 2,
				3, 2);
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
		if (getFrameX() == getColunas()) {
			setFrameX(0);
		}
		if (atirando) {
			atirar();
		}
		if (baixarArma) {
			baixarArma();
		}
	}

	public void atirar() {
		if (!atirando) {
			if (viradoPara == -1) {
				// definindo anima��o 1/2 de atirar para esquerda
				setFrameY(2);
				setFrameX(0);
			} else {
				// definindo anima��o 1/2 de atirar para direita
				setFrameY(1);
				setFrameX(0);
			}
			atirando = true;
			contadorAtirar = 0;
		} else if (contadorAtirar == 15) {
			atirando = false;
			if (viradoPara == -1) {
				// definindo anima��o 2/2 de atirar para esquerda
				setFrameY(2);
				setFrameX(1);
			} else {
				// definindo anima��o 2/2 de atirar para direita
				setFrameY(1);
				setFrameX(1);
			}
			atirando = false;
			contadorAtirar = 0;
			contadorAbaixar = 0;
			baixarArma = true;
		} else {
			contadorAtirar++;
		}
	}

	private void baixarArma() {
		contadorAbaixar++;
		if (contadorAbaixar == 30) {
			if (viradoPara == -1) {
				setFrameY(0);
				setFrameX(1);
			} else {
				setFrameY(0);
				setFrameX(0);
			}
		}
	}

	@Override
	public void setMoving(int moving) {
		if (moving != getMoving()) {
			if (moving == 0) {
				setFrameY(0);
				if (getMoving() == 1) {
					viradoPara = 1;
					setFrameX(0);
				} else {
					viradoPara = -1;
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
}
