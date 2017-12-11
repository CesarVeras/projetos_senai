package jogo;

import java.awt.Graphics2D;
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
	private int contadorSoco;
	private int contadorSprite;

	public Personagem() {
		super(Utils.getInstance().getWidth() / 2, 500, 64, 100, 10, 10, Utils
				.getInstance().loadImage("imagens/spritesheet_personagem.png"),
				4, 4, 5);
		contadorPulo = 0;
		limitePulo = 200;
		valorGravidade = 20;
		gravidade = true;
		contadorSoco = 0;
		contadorSprite = 0;
	}

	public boolean caiuDaTela() {
		if (getPosY() + getHeight() >= Utils.getInstance().getHeight()) {
			reset();
		}
		return (getPosY() + getHeight() >= Utils.getInstance().getHeight());
	}

	public boolean colisao(Inimigo inimigo) {
		if (getRectangle().intersects(inimigo.getRectangle())) {
			if (dandoSoco) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean colidindoComChao(LinkedList<Chao> plataformas) {
		for (int i = 0; i < plataformas.size(); i++) {
			if (getRectangle().intersects(plataformas.get(i).getRectangle())) {
				gravidade = false;
				return true;
			}
		}
		if (!pulando)
			gravidade = true;
		return false;
	}

	public void darSoco() {
		if (!dandoSoco) {
			contadorSoco = 0;
			dandoSoco = true;
			setFrameY(0);
			if (eraEsquerda) {
				setFrameX(2);
			} else {
				setFrameX(3);
			}
		} else {
			if (contadorSoco == 15) {
				dandoSoco = false;
				if (eraEsquerda) {
					setFrameX(0);
				} else {
					setFrameX(1);
				}
				setFrameY(0);
			} else {
				setFrameY(0);
				if (eraEsquerda) {
					setFrameX(2);
				} else {
					setFrameX(3);
				}
				contadorSoco++;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(getSprite(), getPosX(), getPosY(), getPosX() + getWidth(),
				getPosY() + getHeight(), getFrameX() * getWidth(),
				getFrameY() * 96, getFrameX() * getWidth() + getWidth(),
				getFrameY() * 96 + 74, null);
	}

	private void passarSprite(){
		if (contadorSprite == 3) {
			contadorSprite = 0;
			setFrameX(getFrameX() + 1);
			if (getFrameX() == getColunas()) {
				setFrameX(0);
			}
		} else {
			contadorSprite++;
		}
	}

	public void reset() {
		this.setPosX(Utils.getInstance().getWidth() / 2);
		this.setPosY(500);
		this.setVidas(getVidas() - 1);
	}

	@Override
	public void update() {
		if (dandoSoco) {
			darSoco();
		} else {
			if ((indoPraEsquerda || indoPraDireita) && getFrameY() > 0) {
				passarSprite();
			}
			if (indoPraDireita) {
				if ((!isColidindoComCaixaDireita() || podeAndar)
						&& (getPosX() + getWidth() < Utils.getInstance().getWidth())) {
					setPosX(getPosX() + getVelX());
				}
			} else if (indoPraEsquerda) {
				if ((!isColidindoComCaixaEsquerda() || podeAndar)
						&& (getPosX() > 0)) {
					setPosX(getPosX() + getVelX());
				}
			}
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

	public boolean isColidindoComCaixaDireita() {
		return (getPosX() + getWidth() >= 3 * (Utils.getInstance().getWidth() / 4));
	}

	public boolean isColidindoComCaixaEsquerda() {
		return (getPosX() <= Utils.getInstance().getWidth() / 4);
	}

	public boolean isColidindoComCaixa() {
		return isColidindoComCaixaDireita() || isColidindoComCaixaEsquerda();
	}

	public boolean isIndoPraEsquerda() {
		return indoPraEsquerda;
	}

	public void setIndoPraEsquerda(boolean indoPraEsquerda) {
		if (indoPraEsquerda != this.indoPraEsquerda) {
			if (!indoPraEsquerda) {
				setFrameY(0);
				setFrameX(0);
			} else {
				setFrameY(2);
				setVelX(Math.abs(getVelX()) * -1);
			}
			this.indoPraEsquerda = indoPraEsquerda;
			eraEsquerda = true;
		}
	}

	public boolean isIndoPraDireita() {
		return indoPraDireita;
	}

	public void setIndoPraDireita(boolean indoPraDireita) {
		if (indoPraDireita != this.indoPraDireita) {
			if (!indoPraDireita) {
				setFrameY(0);
				setFrameX(1);
			} else {
				setFrameY(1);
				setVelX(Math.abs(getVelX()));
			}
			this.indoPraDireita = indoPraDireita;
			eraEsquerda = false;
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