/**
 * 
 */
package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IPersistence;
import model.Livro;
import util.Constantes;

/**
 * @author barbarasperinas
 *
 */
public class LivroDAO implements IPersistence<Livro> {

	private static ArrayList<Livro> livros = new ArrayList<Livro>();

	@Override
	public void cadastrar(Livro livro) {
		livros.add(livro);
		gravarArquivo();
	}

	@Override
	public ArrayList<Livro> listar() {
		return livros;
	}

	private void gravarArquivo() {
		File f = new File(Constantes.ARQUIVO_DE_LIVROS);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Livro l : livros) {
				bw.write(l.getTitulo() + ";" + l.getAutor());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static {
		File f = new File(Constantes.ARQUIVO_DE_LIVROS);

		FileReader fr = null;
		BufferedReader br = null;

		try {
			if (!f.exists())
				f.createNewFile();

			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");

				Livro c = new Livro(dados[0], dados[1]);
				livros.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
