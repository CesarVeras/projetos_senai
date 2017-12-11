package jogo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import br.senai.sc.engine.Utils;

public class Atirador extends Inimigo {
	private boolean atirando;
	private int contadorAtirar;
	private int contadorAbaixar;
	private int viradoPara;
	private int contadorSprite;
	private boolean baixarArma;
	private Personagem trump;
	private LinkedList<Tiro> tiros;

	public Atirador(Personagem personagem) {
		super(0, (int) (Utils.getInstance().getHeight() * 0.85) - 110, 100, 120, 5, 2,
				Utils.getInstance().loadImage("imagens/Atirador.png"), 2, 3, 2);
		this.trump = personagem;
		tiros = new LinkedList<>();
	}

	private void passarSprite() {
		if (contadorSprite == 5) {
			contadorSprite = 0;
			setFrameY(viradoPara);
			setFrameX(getFrameX() + 1);
			if (getFrameX() > 2) {
				setFrameX(0);
			}
		} else {
			contadorSprite++;
		}
	}

	@Override
	public void update() {
		int diferencaEsquerda = Math.abs(getPosX() - trump.getPosX() + trump.getWidth());
		int diferencaDireita = Math.abs(getPosX() + getWidth() - trump.getPosX() + 25);
		if (!trump.isColidindoComCaixa() || (!trump.isIndoPraDireita() && !trump.isIndoPraEsquerda())) {
			// Se o explosivo estiver mais a direita que o ponto direito do Trump
			if ((diferencaEsquerda <= 400 && diferencaEsquerda > 380)
					|| (diferencaDireita <= 400 && diferencaDireita > 380)) {
				atirar();
			} else {
				if (getPosX() > trump.getPosX() + trump.getWidth()) {
					setMoving(-1);
					passarSprite();
					setPosX(getPosX() - getVelX());
				} else if (getPosX() + getWidth() < trump.getPosX() + 25) {
					// Se o explosivo estiver mais a esquerda que o ponto esquerdo
					// Trump
					setMoving(1);
					passarSprite();
					setPosX(getPosX() + getVelX());
				} else {
					// Se o explosivo colidir com Trump
					atirar();
				}
			}
		} else {
			passarSprite();
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		}
		for (int i = 0; i < tiros.size(); i++) {
			if (tiros.get(i) != null) {
				tiros.get(i).update();
				if (tiros.get(i).isSaiuDaTela()) {
					tiros.remove(i);
				}
			}
		}
	}

	public boolean colidindoComTrump() {
		return getPosX() < trump.getPosX() + trump.getWidth()
				|| getPosX() + getWidth() > trump.getPosX() && getPosY() + 40 >= trump.getPosY();
	}

	public void atirar() {
		if (!atirando) {
			atirando = true;
			contadorAtirar = 0;
		} else if (contadorAtirar == 37) {
			// TODO disparar
			atirando = false;
			contadorAtirar = 0;
		} else {
			contadorAtirar++;
			switch (contadorAtirar) {
			case 12:
				setFrameX(3);
				setFrameY(viradoPara);
				break;
			case 24:
				setFrameX(getFrameX() + 1);
				break;
			case 36:
				setFrameX(0);
				boolean praEsquerda = false;
				if (viradoPara == 1) {
					praEsquerda = true;
					tiros.add(new Tiro(getPosX(), getPosY() + getHeight() / 2, 5, praEsquerda, trump));
				} else {					
					tiros.add(new Tiro(getPosX() + getWidth(), getPosY() + getHeight() / 2, 5, praEsquerda, trump));
				}		
				break;
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(), getPosY() + getHeight(),
				getFrameX() * 64, getFrameY() * 64, getFrameX() * 64 + 64, getFrameY() * 64 + 64, null);
		for (int i = 0; i < tiros.size(); i++) {
			if (tiros.get(i) != null) {
				tiros.get(i).draw(g);
			}
		}
	}

	private void baixarArma() {
		contadorAbaixar++;
		if (contadorAbaixar == 30) {
			setFrameY(viradoPara);
			setFrameX(0);
		}
	}

	@Override
	public void setMoving(int moving) {
		if (moving != getMoving()) {
			if (moving == 0) {
				setFrameX(0);
				if (getMoving() == 1) {
					viradoPara = 0;
					setFrameY(0);
				} else {
					viradoPara = 1;
					setFrameY(1);
				}
			} else if (moving == 1) {
				viradoPara = 0;
				setFrameY(viradoPara);
			} else {
				viradoPara = 1;
				setFrameY(viradoPara);
			}
			super.setMoving(moving);
		}
	}
}
