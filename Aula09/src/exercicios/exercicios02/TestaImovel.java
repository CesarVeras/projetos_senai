package exercicios.exercicios02;

public class TestaImovel {
	public static void main(String[] args) {
		Imovel i = new Imovel("lagoa", 50000);
		System.out.println(i.valorFinal());
		
		ImovelNovo in = new ImovelNovo("saco grande", 60000, 10000);
		System.out.println(in.valorFinal());
		
		ImovelVelho iv = new ImovelVelho("saco grande", 66000, 10000);
		System.out.println(iv.valorFinal());
	}
}
