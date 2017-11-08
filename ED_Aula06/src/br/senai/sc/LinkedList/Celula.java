package br.senai.sc.LinkedList;

public class Celula {
	private Object elemento;
	private Celula proximoElemento;
	
	public Celula(Object elemento, Celula proximoElemento) {
		this.elemento = elemento;
		this.proximoElemento = proximoElemento;
	}

	public Celula(Object elemento) {
		this.elemento = elemento;
	}

	public Celula getProximoElemento() {
		return proximoElemento;
	}
	public void setProximoElemento(Celula proximoElemento) {
		this.proximoElemento = proximoElemento;
	}
	public Object getElemento() {
		return elemento;
	}
	
	public String toString() {
		return elemento.toString();
	}
}
