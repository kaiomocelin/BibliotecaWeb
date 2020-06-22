package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.GeneroDAO;
import dao.LivroDAO;
import models.Genero;
import models.Livro;
import java.io.Serializable;

@Named
@SessionScoped
public class LivroBean implements Serializable {

	// Construtor
	public LivroBean() {
		livro = new Livro();
		livros = new ArrayList<Livro>();
		generos = new ArrayList<Genero>();

	}
	
	// Atributos
	private static final long serialVersionUID = 1306734049083259978L;
	private Livro livro;
	private List<Livro> livros;
	private List<Genero> generos;
	
	// A��es
	public String cadastrar() {
		LivroDAO.cadastrar(livro);
		livro = new Livro();
		return "GerenciarLivros.xhtml?faces-redirect=true";
	}

	public void remover(Livro livro) {
		LivroDAO.remover(livro);
	}

	public String detalhar() {
		int idLivro = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro"));
		livro = LivroDAO.buscarPorId(idLivro);
		return "AlterarLivro.xhtml?faces-redirect=true";

	}

	public String alterar() {
		LivroDAO.alterar(livro);
		livro = new Livro();
		return "GerenciarLivros.xhtml?faces-redirect=true";
	}

	// Getter & Setters
	public List<Genero> getGeneros() {
		generos = GeneroDAO.listar();
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Livro> getLivros() {
		livros = LivroDAO.listar();
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
