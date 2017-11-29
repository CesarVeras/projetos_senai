package exercicio.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class GravaMeuComputador {
	public static void main(String[] args) {
		Computador pc = criaComputador();
		escreverArquivo(pc, "computador.txt");
	}

	public static Computador criaComputador() {
		String marca = JOptionPane
				.showInputDialog("Informe a modelo do seu computador:");
		String velocidade = JOptionPane
				.showInputDialog("Informe a velocidade do seu computador:");
		String memoria = JOptionPane
				.showInputDialog("Informe a memória do seu computador:");
		String hd = JOptionPane
				.showInputDialog("Informe o hd do seu computador:");
		return new Computador(marca, velocidade, memoria, hd);
	}
	
	public static void escreverArquivo(Computador pc, String arquivo) {
		try {
			String caminho = "C:/Users/Aluno/projetos_senai/ExercicioED/src/arquivos/";
			caminho += arquivo;
			File file = new File(caminho);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println("Meu computador tem:");
			
			pw.println(pc.getModelo());
			pw.println(pc.getVelocidade());
			pw.println(pc.getMemoria());
			pw.println(pc.getHd());
			pw.close();

			System.out.println("Dados salvos com sucesso!");

		} catch (IOException ioe) {
			System.out.println("Uma excessão ocorreu:");
			ioe.printStackTrace();
		}
	}
}
