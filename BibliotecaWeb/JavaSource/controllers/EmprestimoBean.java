package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import models.Cliente;
import models.Emprestimo;
import models.Funcionario;
import models.Livro;

@Named
@SessionScoped
public class EmprestimoBean implements Serializable {

	//Construtor
	public EmprestimoBean() {
		emprestimo = new Emprestimo();
		livro = new Livro();
		emprestimos = new ArrayList<Emprestimo>();
		livros = new ArrayList<Livro>();
		clientes = new ArrayList<Cliente>();
		funcionarios = new ArrayList<Funcionario>();
//		funcionarios = new ArrayList<Funcionario>();
//		clientes = new ArrayList<Cliente>();
	}

	//Atributos
	private static final long serialVersionUID = 1728576448215873831L;
	private Emprestimo emprestimo;
	private Livro livro;
	private List<Emprestimo> emprestimos;
	private List<Livro> livros;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
//	private List<Funcionario> funcionarios;
//	private List<Cliente> clientes;
	
	
	// Ações
	public String cadastrarEmprestimo() {
		emprestimo.getLivro().setEmprestado(true);
		livro.setEmprestado(true);
		EmprestimoDAO.cadastrarEmprestimo(emprestimo);
		emprestimo = new Emprestimo();
		return "Index.xhtml?faces-redirect=true";
	}
	

	public void devolverLivro(Emprestimo emprestimo) {
		EmprestimoDAO.devolverLivro(emprestimo);
	}

	// Getter & Setters
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Emprestimo> getEmprestimos() {
		emprestimos = EmprestimoDAO.listar();
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}



}