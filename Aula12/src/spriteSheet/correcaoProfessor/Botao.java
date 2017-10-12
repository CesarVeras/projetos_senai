package spriteSheet.correcaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Botao {
	private String texto;
	private int x;
	private int y;
	private int width;
	private int height;
	private int tamanhoLetra;

	public Botao(String texto, int x, int y, int width, int height,
			int tamanhoLetra) {
		this.texto = texto;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tamanhoLetra = tamanhoLetra;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, tamanhoLetra));
		g.drawString(texto, x + width/2 - width/4 , y + height - height/3);
	}

	public boolean isPressed(int x, int y) {
		return ((x >= this.x && x <= this.x + width) && (y >= this.y && y <= this.y
				+ height));
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
}
