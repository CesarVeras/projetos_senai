package stream;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaArquivoChar {

	public static void main(String[] args) {

		FileWriter fout = null;
		try {
			fout = new FileWriter("C:/Users/Aluno/projetos_senai/ED_Aula07/src/arquivos/abc.txt");
			String s = "Gravando dados via OutputStream";
			fout.write(s);
			fout.close();
			System.out.println("success...");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (fout != null)
					fout.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		File file = new File("abc.txt");
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
