package exercicios.exercicios03;

public class TestaPessoa {

	public static void main(String[] args) {
		Fornecedor f = new Fornecedor("Alan", "estreito", "34344343", 10000,
				9999);
		System.out.println(f.obterSaldo());
		System.out.println(f);

		System.out.println("-------------------");
		Empregado e = new Empregado("Peterson", "trindade", "30001000", 123,
				1600, 15);
		System.out.println(e);
		System.out.println(e.calcularSalario());

		System.out.println("-------------------");
		Administrador a = new Administrador(e.getNome(), e.getEndereco(),
				e.getTelefone(), e.getCodigoSetor(), e.getSalarioBase(),
				e.getImposto(), 1500);
		System.out.println(a);
		System.out.println(a.calcularSalario());
		
		System.out.println("-------------------");
		Operario o = new Operario("Alcemar", "Costeira", "44444444", 123, 2500f, 20f, 1500f, 10f);
		System.out.println(o);
		System.out.println(o.calcularSalario());
		
		System.out.println("-------------------");
		Vendedor v = new Vendedor("Vlad", "Caixao", "55555555", 123, 4000f, 10, 6000, 5);
		System.out.println(v);
		System.out.println(v.calcularSalario());
	}
}
