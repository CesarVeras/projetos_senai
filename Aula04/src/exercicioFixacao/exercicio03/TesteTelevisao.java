package exercicioFixacao.exercicio03;

public class TesteTelevisao {
	public static void main(String[] args) {
		Televisao  tv1 = new Televisao("Samsung", 42, 12, false);
		
		imprimeEstado(tv1.isLigada());
		tv1.setLigada(true);
		imprimeEstado(tv1.isLigada());
		tv1.setLigada(false);
		imprimeEstado(tv1.isLigada());
		tv1.setLigada(true);
		imprimeEstado(tv1.isLigada());
		System.out.println("A tv está no canal: " + tv1.getCanalAtual());
		tv1.setCanalAtual(45);
		System.out.println("A tv está no canal: " + tv1.getCanalAtual());
	}
	
	public static void imprimeEstado(boolean estado){
		if (estado) {
			System.out.println("A tv está ligada");
		} else {
			System.out.println("A tv está desligada");
		}
	}
}
