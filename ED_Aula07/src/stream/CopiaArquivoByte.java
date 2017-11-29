package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArquivoByte {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("C:/Users/Aluno/projetos_senai/ED_Aula07/src/arquivos/abc.txt");
			String s = "Gravando dados via OutputStream";
			byte b[] = s.getBytes();
			fos.write(b);
			fos.close();
			System.out.println("Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		File file = new File("abc.txt");
			
		if (!file.exists()) {
			System.out.println("Arquivo não existe!");
			System.exit(0);
		}
		
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			//fis = new FileInputStream("abc.txt");

			System.out.println("Tamanho em bytes do arquivo : " + fis.available());

			int content;
			while ((content = fis.read()) != -1) {
				System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}