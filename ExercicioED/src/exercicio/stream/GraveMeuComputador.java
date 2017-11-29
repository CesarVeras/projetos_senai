package exercicio.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class GraveMeuComputador {
	public static void main(String[] args) {
		String modelo = JOptionPane.showInputDialog("Qual o modelo do seu PC?");
		String velocidade = JOptionPane.showInputDialog("Qual a velocidade do seu PC?");
		String hd = JOptionPane.showInputDialog("Qual o HD do seu PC?");
		String memoria = JOptionPane.showInputDialog("Qua a memória do seu PC?");
		try {
			File file = new File("C:/Users/Aluno/Downloads/computador.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			// This will add a new line to the file content
			pw.println("");
			/*
			 * Below three statements would add three mentioned Strings to the
			 * file in new lines.
			 */
			pw.println(modelo);
			pw.println(velocidade);
			pw.println(hd);
			pw.println(memoria);
			pw.close();

			System.out.println("Data successfully appended at the end of file");

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
		
		File file = new File(
				"C:/Users/Aluno/Downloads/computador.txt");
		FileReader fr = null;

		try {
			fr = new FileReader(file);

			int content;
			while ((content = fr.read()) != -1) {
				System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
