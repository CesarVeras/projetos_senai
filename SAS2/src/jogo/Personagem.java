package jogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;

import br.senai.sc.engine.Utils;

public class Personagem extends ObjetoVivo {
	private boolean gravidade;
	private int valorGravidade;
	private boolean pulando;
	private boolean eraEsquerda;
	private boolean dandoSoco;
	private boolean indoPraEsquerda;
	private boolean indoPraDireita;
	private boolean podeAndar;
	private int limitePulo;
	private int contadorPulo;

	// private int contadorSoco;

	public Personagem() {
		super(Utils.getInstance().getWidth() / 2, 0, 167, 180, 10, 10,
				Utils.getInstance().loadImage("imagens/personagem.png"), 4, 5, 5);
		contadorPulo = 0;
		limitePulo = 200;
		valorGravidade = 20;
		gravidade = true;
	}
	
	@Override
	public void update() {
		if ((indoPraEsquerda || indoPraDireita) && getFrameY() > 2) {
			setFrameX(getFrameX() + 1);
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		}
		if (indoPraDireita) {
			if ((!isColidindoComCaixaDireita() || podeAndar)
					&& (getPosX() + getWidth() < Utils.getInstance().getWidth())) {
				setPosX(getPosX() + getVelX());
			}
		} else if (indoPraEsquerda) {
			if ((!isColidindoComCaixaEsquerda() || podeAndar) && (getPosX() > 0)) {
				setPosX(getPosX() + getVelX());
			}
		}
		if (dandoSoco) {
			darSoco();
		}

		if (gravidade && !pulando) {
			setPosY(getPosY() + valorGravidade);
		}

		if (pulando) {
			if (contadorPulo < limitePulo) {
				contadorPulo += 20;
				setPosY(getPosY() - 20);
			} else {
				contadorPulo = 0;
				gravidade = true;
				pulando = false;
			}
		}
	}

	public void darSoco() {
		if (!dandoSoco) {
			dandoSoco = true;
			setFrameX(0);
			if (eraEsquerda) {
				setFrameY(2);
			} else {
				setFrameY(1);
			}
		} else {
			setFrameX(1);
			dandoSoco = false;
			// contadorSoco++;
			// if (contadorSoco == 2) {
			// contadorSoco = 0;
			// }
		}
	}

	public boolean isColidindoComCaixaDireita() {
		return (getPosX() + getWidth() >= 3 * (Utils.getInstance().getWidth() / 4));
	}

	public boolean isColidindoComCaixaEsquerda() {
		return (getPosX() <= Utils.getInstance().getWidth() / 4);
	}

	public boolean isColidindoComCaixa() {
		return isColidindoComCaixaDireita() || isColidindoComCaixaEsquerda();
	}

	public boolean colidindoComChao(LinkedList<Chao> plataformas) {
		for (int i = 0; i < plataformas.size(); i++) {
			if (getRectangle().intersects(plataformas.get(i).getRectangle())) {
				gravidade = false;
				return true;
			}
		}
		if (!pulando) gravidade = true;
		return false;
	}

	public boolean isIndoPraEsquerda() {
		return indoPraEsquerda;
	}

	public void setIndoPraEsquerda(boolean indoPraEsquerda) {
		if (indoPraEsquerda != this.indoPraEsquerda) {
			if (!indoPraEsquerda) {
				setFrameY(0);
				setFrameX(1);
				eraEsquerda = true;
			} else {
				setFrameY(4);
				setVelX(Math.abs(getVelX()) * -1);
			}
			this.indoPraEsquerda = indoPraEsquerda;
		}
	}

	public boolean isIndoPraDireita() {
		return indoPraDireita;
	}

	public void setIndoPraDireita(boolean indoPraDireita) {
		if (indoPraDireita != this.indoPraDireita) {
			if (!indoPraDireita) {
				setFrameY(0);
				setFrameX(0);
				eraEsquerda = false;
			} else {
				setFrameY(3);
				setVelX(Math.abs(getVelX()));
			}
			this.indoPraDireita = indoPraDireita;
		}
	}

	public boolean isPulando() {
		return pulando;
	}

	public void setPulando(boolean pulando) {
		this.pulando = pulando;
	}

	public boolean isEraEsquerda() {
		return eraEsquerda;
	}

	public void setEraEsquerda(boolean eraEsquerda) {
		this.eraEsquerda = eraEsquerda;
	}

	public boolean isPodeAndar() {
		return podeAndar;
	}

	public void setPodeAndar(boolean podeAndar) {
		this.podeAndar = podeAndar;
	}

	public boolean isGravidade() {
		return gravidade;
	}

	public void setGravidade(boolean gravidade) {
		this.gravidade = gravidade;
	}

	public boolean isDandoSoco() {
		return dandoSoco;
	}

	public void setDandoSoco(boolean dandoSoco) {
		this.dandoSoco = dandoSoco;
	}

	public int getLimitePulo() {
		return limitePulo;
	}

	public void setLimitePulo(int limitePulo) {
		this.limitePulo = limitePulo;
	}

	public int getContadorPulo() {
		return contadorPulo;
	}

	public void setContadorPulo(int contadorPulo) {
		this.contadorPulo = contadorPulo;
	}

	public int getValorGravidade() {
		return valorGravidade;
	}

	public void setValorGravidade(int valorGravidade) {
		this.valorGravidade = valorGravidade;
	}
}