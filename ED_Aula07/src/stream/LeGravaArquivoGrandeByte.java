package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeGravaArquivoGrandeByte {

	public static void main(String[] args) {

		long inicioProcesso = System.currentTimeMillis();

		File file = new File("c:/Users/w8.1/Desktop/AUTOKIT.pdf");
			
		if (!file.exists()) {
			System.out.println("Arquivo não existe!");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		String s = "";

		try {
			fis = new FileInputStream(file);
			
			bis = new BufferedInputStream(fis);

			System.out.println("Tamanho em bytes do arquivo : " + fis.available());

			int content;
			while ((content = bis.read()) != -1) {
				s.concat(String.valueOf((char) content));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("c:/Users/w8.1/Desktop/COPIA-AUTOKIT.pdf");
			bos = new BufferedOutputStream(fos);
			byte b[] = s.getBytes();
			bos.write(b);
			bos.close();
			System.out.println("Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		long fimProcesso = System.currentTimeMillis();

		System.out.println("Tempo de leitura e gravação em milisegundos " + 
				((fimProcesso-inicioProcesso)));

	}
}
