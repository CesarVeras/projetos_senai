package exercicioFixacao.exercicio05;

public class TestaTime {
	public static void main(String[] args) {
		TimeFutebol time = new TimeFutebol("Bom de Chute", "BC", "F", 30, 20,
				7, 3, 60, 10);
		time.setNomeJogadores(new String[] { "Pedro", "Carlos", "Jos�",
				"Lucio", "Matheus", "Tadeu", "Tom�", "Thiago", "Rafael",
				"Lucas", "Paulo", });
		
		time.calcularPontosTime();
		
	}
}
