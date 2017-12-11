package rec;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Jogador extends ObjetoGrafico{
	
	double vida;
	int movendo;

	public Jogador() {
		super(0, 0, 10, 0, 50, 50);
		voltapromeio();
		vida = 100;
	}

	private void voltapromeio() {
		// TODO Auto-generated method stub
		x = Utils.getInstance().getWidth() / 2;
		y = 650;
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if (movendo == 1) {
			if (x + 50 < Utils.getInstance().getWidth()) {
				
				x = x + velocidadex;
			}
		} else if (movendo == -1) {
			if (x > 0) {
				
				x = x - velocidadex;
			}
			
		}
		
		if (vida > 0) {
			vida = vida - 0.5;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.green);
		g.fillRect(x, y, largura, altura);
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	
	
	public int getMovendo() {
		return movendo;
	}

	public void setMovendo(int movendo) {
		this.movendo = movendo;
	}
	
	
}
