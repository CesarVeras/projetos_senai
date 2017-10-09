package br.senai.sc.array;

public class Produto {

	private String nome;
	private double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object objeto) {
		Produto produto = (Produto)objeto;
		return (nome.equals(produto.nome) && preco == produto.preco);
	}
}
