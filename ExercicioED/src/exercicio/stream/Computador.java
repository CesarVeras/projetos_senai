package exercicio.stream;
public class Computador {
	private String modelo, velocidade, memoria, hd;
	
	public Computador() {
	}

	public Computador(String modelo, String velocidade, String memoria,
			String hd) {
		this.modelo = modelo;
		this.velocidade = velocidade;
		this.memoria = memoria;
		this.hd = hd;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}
	
	
}
