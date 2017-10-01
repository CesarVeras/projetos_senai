package exercicioFixacao.exercicio05;

public class TimeFutebol {
	
	// Atributos
	private String nome;
	private String sigla;
	private String divisaoAtual;
	private int qntJogos;
	private int qntVitorias;
	private int qntEmpates;
	private int qntDerrotas;
	private int qntGolsMarcados;
	private int qntGolsSofridos;
	private String[] nomeJogadores;
	
	// Construtores
	public TimeFutebol() {
	}

	public TimeFutebol(String nome, String sigla, String divisaoAtual,
			int qntJogos, int qntVitorias, int qntEmpates, int qntDerrotas,
			int qntGolsMarcados, int qntGolsSofridos) {
		this.nome = nome;
		this.sigla = sigla;
		this.divisaoAtual = divisaoAtual;
		this.qntJogos = qntJogos;
		this.qntVitorias = qntVitorias;
		this.qntEmpates = qntEmpates;
		this.qntDerrotas = qntDerrotas;
		this.qntGolsMarcados = qntGolsMarcados;
		this.qntGolsSofridos = qntGolsSofridos;
	}
	
	// Métodos
	public void jogar() {
		qntJogos++;
	}
	
	public void vencer() {
		if (qntJogos > (qntVitorias + qntDerrotas + qntEmpates)) {
			qntVitorias++;
		}
	}
	
	public void empatar() {
		if (qntJogos > (qntVitorias + qntDerrotas + qntEmpates)) {			
			qntEmpates++;
		}
	}
	
	public void perder() {
		if (qntJogos > (qntVitorias + qntDerrotas + qntEmpates)) {
			qntDerrotas++;
		}
	}
	
	public void marcarGols(int quantidade) {
		qntGolsMarcados += quantidade;
	}
	
	public void sofrerGols(int quantidade) {
		qntGolsSofridos += quantidade;
	}
	
	public int calcularSaldoGols() {
		return qntGolsMarcados - qntGolsSofridos;
	}
	
	public int calcularPontosTime() {
		return ((3 * qntVitorias) + (1 * qntEmpates));
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDivisaoAtual() {
		return divisaoAtual;
	}

	public void setDivisaoAtual(String divisaoAtual) {
		this.divisaoAtual = divisaoAtual;
	}

	public int getQntJogos() {
		return qntJogos;
	}

	public void setQntJogos(int qntJogos) {
		this.qntJogos = qntJogos;
	}

	public int getQntVitorias() {
		return qntVitorias;
	}

	public void setQntVitorias(int qntVitorias) {
		this.qntVitorias = qntVitorias;
	}

	public int getQntEmpates() {
		return qntEmpates;
	}

	public void setQntEmpates(int qntEmpates) {
		this.qntEmpates = qntEmpates;
	}

	public int getQntDerrotas() {
		return qntDerrotas;
	}

	public void setQntDerrotas(int qntDerrotas) {
		this.qntDerrotas = qntDerrotas;
	}

	public int getQntGolsMarcados() {
		return qntGolsMarcados;
	}

	public void setQntGolsMarcados(int qntGolsMarcados) {
		this.qntGolsMarcados = qntGolsMarcados;
	}

	public int getQntGolsSofridos() {
		return qntGolsSofridos;
	}

	public void setQntGolsSofridos(int qntGolsSofridos) {
		this.qntGolsSofridos = qntGolsSofridos;
	}

	public String[] getNomeJogadores() {
		return nomeJogadores;
	}
	
	public void setNomeJogadores(String[] nomeJogadores) {
		this.nomeJogadores = nomeJogadores;
	}
	
	public String getNomeJogador(int posicao) {
		return nomeJogadores[posicao];
	}
}
