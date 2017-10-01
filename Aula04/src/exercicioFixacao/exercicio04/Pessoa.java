package exercicioFixacao.exercicio04;

public class Pessoa {
	private String nome;
	private int idade;
	private String rg;
	private float altura;
	private float peso;
	private char genero;

	public Pessoa() {
	}

	public Pessoa(String nome, int idade, String rg, float altura, float peso,
			char genero) {
		this.nome = nome;
		this.idade = idade;
		this.rg = rg;
		this.altura = altura;
		this.peso = peso;
		this.genero = genero;
	}

	public void irNoRodizio() {
		peso += 3;
	}

	public void malharUmaHora() {
		peso -= 2;
	}

	public void calcularIMC() {
		float imc = peso / (altura * altura);
		if (imc < 18.5) {
			System.out.println(nome + " está abaixo do peso ideal");
		} else if (imc >= 18.5 && imc < 25) {
			System.out.println(nome + " está no peso ideal");
		} else if (imc >= 25 && imc < 30) {
			System.out.println(nome + " está acima do peso");
		} else {
			System.out.println(nome + " está obes@!");
		}
	}

	public void imprimeDados() {
		System.out.println("Dados da Pessoa\nNome: " + nome 
				+ "\nIdade: " + idade 
				+ "\nRG: " + rg 
				+ "\nAltura: " + altura 
				+ "\nPeso: " + peso 
				+ "\nGênero: " + genero
				+ "\n------------------------------------\n");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
}
