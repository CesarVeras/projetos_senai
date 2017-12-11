package rec;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class Poder extends ObjetoGrafico{

	int qualpoder; // 0 cafe 1 acucar 2 refrigerante 3 agua
	boolean saiu;
	
	public Poder() {
		super(0, -25, 0, 15, 25, 25);
		cria();
		// TODO Auto-generated constructor stub
	}

	private void cria() {
		// TODO Auto-generated method stub
		Random sorteio = new Random();
		x = sorteio.nextInt(Utils.getInstance().getWidth());
		qualpoder = sorteio.nextInt(4);	}
	
	public boolean foipego(Jogador j) {
		if (new Rectangle(x,y,largura,altura).intersects(new Rectangle(j.x, j.y, j.largura, j.altura))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (y < Utils.getInstance().getHeight()) {
			y = y + velocidadey;
		} else {
			saiu = true;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		if (qualpoder == 0) {
			 g.setColor(new Color(89, 52, 10));
		} else
		if (qualpoder == 1) {
			g.setColor(Color.white);
		} else 
		if (qualpoder == 2) {
			g.setColor(new Color(201, 126, 42));

			 g.fillOval(x, y, largura, altura);
		} else {
			g.setColor(Color.cyan);
		}
		g.fillOval(x, y, largura, altura);
 	}
	
}
