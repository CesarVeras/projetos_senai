package rec;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import br.senai.sc.engine.Utils;

public class Tela extends ObjetoGrafico{
	
	public Tela() {
		super(0, 0, 0, 0, 0, 0);
	}

	@Override
	public void update() {
		System.out.println("Método não é usado nessa classe!");
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Utils.getInstance().getWidth(),Utils.getInstance().getHeight());
		
		g.setColor(Color.RED);
		g.setFont(new Font("Sans-serif", Font.PLAIN, 30));
		g.drawString("Você perdeu", 400, 100);
		
		g.setColor(new Color(89, 52, 10));
		g.setFont(new Font("Sans-serif", Font.PLAIN, 20));
		g.drawString("Quantidade de café coletado: " + Roda.contadorCafe, 400, 200);
		
		g.setColor(Color.WHITE);
		g.drawString("Quantidade de açucar coletado: " + Roda.contadorAcucar, 400, 250);
		
		g.setColor(new Color(201, 126, 42));
		g.drawString("Quantidade de refrigerante coletado: " + Roda.contadorRefrigerante, 400, 300);
		
		g.setColor(Color.CYAN);
		g.drawString("Quantidade de água coletada: " + Roda.contadorAgua, 400, 350);
	}
}
