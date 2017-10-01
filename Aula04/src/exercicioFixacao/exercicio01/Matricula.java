package exercicioFixacao.exercicio01;

public class Matricula {

	private String nomeAluno;
	private String dataNascimento;
	private String codigoTurma;
	private String statusMatricula;
	private float valorMensalidade;

	public Matricula() {
		statusMatricula = "regular";
	}

	public Matricula(String nomeAluno, String dataNascimento,
			String codigoTurma, float valorMensalidade) {
		this.nomeAluno = nomeAluno;
		this.dataNascimento = dataNascimento;
		this.codigoTurma = codigoTurma;
		setValorMensalidade(valorMensalidade);
		statusMatricula = "regular";
	}

	public void imprimirDados() {
		System.out.println("Dados d@ Alun@\nNome: " + nomeAluno
				+ "\nData de Nascimento: " + dataNascimento
				+ "\nCódigo da Turma: " + codigoTurma
				+ "\nStatus da Matricula: " + statusMatricula
				+ "\nValor da Mensalidade: " + valorMensalidade);
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		if (statusMatricula.equalsIgnoreCase("regular")
				|| statusMatricula.equalsIgnoreCase("evadido")
				|| statusMatricula.equalsIgnoreCase("trancado")){			
			this.statusMatricula = statusMatricula;
		}
	}

	public float getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(float valorMensalidade) {
		if (valorMensalidade >= 0) {
			this.valorMensalidade = valorMensalidade;
		}
	}
}
