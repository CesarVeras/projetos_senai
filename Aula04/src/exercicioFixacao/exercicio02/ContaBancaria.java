package exercicioFixacao.exercicio02;

public class ContaBancaria {
	private String titularConta;
	private String segundoTitularConta;
	private float saldo;
	private String nomeBanco;
	private String numeroConta;

	public ContaBancaria() {}

	public ContaBancaria(String titularConta, String segundoTitularConta,
			float saldo, String nomeBanco, String numeroConta) {
		setTitularConta(segundoTitularConta);
		this.segundoTitularConta = segundoTitularConta;
		setSaldo(saldo);
		this.nomeBanco = nomeBanco;
		this.numeroConta = numeroConta;
	}
	
	public void imprimeDados() {
		System.out.println("Dados da Conta\nTitular: " + titularConta 
				+ "\nSegundo Titular: " + segundoTitularConta
				+ "\nSaldo: " + saldo
				+ "\nNome do Banco: " + nomeBanco
				+ "\nNumero da Conta: " + numeroConta);
	}
	
	public void depositar(float valorDeposito) {
		if (valorDeposito > 0) {
			saldo += valorDeposito;
		}
	}
	
	public void sacar(float valorSaque) {
		if (valorSaque > 0 && valorSaque <= saldo) {
			saldo -= valorSaque;
		}
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		if (titularConta != null && !titularConta.isEmpty()) {
			this.titularConta = titularConta;
		}
	}

	public String getSegundoTitularConta() {
		return segundoTitularConta;
	}

	public void setSegundoTitularConta(String segundoTitularConta) {
		this.segundoTitularConta = segundoTitularConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if (saldo >= 0) {
			this.saldo = saldo;
		}
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		if (nomeBanco != null && !nomeBanco.isEmpty()) {
			this.nomeBanco = nomeBanco;			
		}
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
}
