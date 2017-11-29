package exercicio.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class LeComputador {
	public static void main(String[] args) {
		File file = new File(
				"C:/Users/Aluno/projetos_senai/ExercicioED/src/arquivos/computador.txt");
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
