package br.senai.sc.aluno;

public class Aluno {
	
	private String nome;
	
	public Aluno() {
	}
	
	public Aluno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object o) {
		Aluno outro = (Aluno)o;
		return nome.equals(outro);
	}
	
	public boolean equals(Aluno aluno) {
		if (aluno != null && this != null) {
			return nome.equalsIgnoreCase(aluno.nome);
		}
		return false;
	}
}
