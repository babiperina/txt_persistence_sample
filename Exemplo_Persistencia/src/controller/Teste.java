package controller;

import model.Livro;
import persistence.LivroDAO;

public class Teste {

	public static void main(String[] args) {

		LivroDAO dao = new LivroDAO();

		String titulo = "Mentes Perigosas";
		String autor = "Ana Beatriz Barbosa Silva";

		Livro livro = new Livro(titulo, autor);

		dao.cadastrar(livro);

		titulo = "O nome do vento.";
		autor = "Patrick Rothfuss";

		livro = new Livro(titulo, autor);

		dao.cadastrar(livro);

		titulo = "O homem que venceu Hitler.";
		autor = "Marcio Pitliuk";

		livro = new Livro(titulo, autor);

		dao.cadastrar(livro);

		for (Livro l : dao.listar()) {
			System.out.println(l.toString());
		}

	}

}
