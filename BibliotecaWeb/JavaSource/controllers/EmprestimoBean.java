package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
<<<<<<< HEAD
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.EmprestimoDAO;
=======
import javax.inject.Named;

import dao.EmprestimoDAO;
import dao.LivroDAO;
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
import models.Cliente;
import models.Emprestimo;
import models.Funcionario;
import models.Livro;

@Named
@SessionScoped
public class EmprestimoBean implements Serializable {

<<<<<<< HEAD
	// Construtor
	public EmprestimoBean() {
		emprestimo = new Emprestimo();
=======
	//Construtor
	public EmprestimoBean() {
		emprestimo = new Emprestimo();
		livro = new Livro();
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
		emprestimos = new ArrayList<Emprestimo>();
		livros = new ArrayList<Livro>();
		clientes = new ArrayList<Cliente>();
		funcionarios = new ArrayList<Funcionario>();
<<<<<<< HEAD
	}

	// Atributos
	private static final long serialVersionUID = 1728576448215873831L;
	private Emprestimo emprestimo;
=======
//		funcionarios = new ArrayList<Funcionario>();
//		clientes = new ArrayList<Cliente>();
	}

	//Atributos
	private static final long serialVersionUID = 1728576448215873831L;
	private Emprestimo emprestimo;
	private Livro livro;
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
	private List<Emprestimo> emprestimos;
	private List<Livro> livros;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
<<<<<<< HEAD

	// A��es
	public String cadastrarEmprestimo() {
		if (emprestimo.verificarPendencia() == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este cliente tem pendencias!"));
			return null;
		} else {
			if (emprestimo.verificarStatus() == true) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro j� foi emprestado!"));
				return null;
			} else {
				if (EmprestimoDAO.cadastrarEmprestimo(emprestimo)) {
					return "Index.xhtml?faces-redirect=true";
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro est� ocupado!"));
					return null;
				}
			}
		}
	}

	public String devolverLivro(Emprestimo emprestimo) {
		emprestimo.gerarMulta();
		if (emprestimo.devolverLivro() == false) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro n�o foi emprestado!"));
			return null;
		} else {
			if (EmprestimoDAO.devolverLivro(emprestimo)) {
				return "GerenciarEmprestimos.xhtml?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro n�o foi emprestado!"));
				return null;
			}
		}

	}

	// Getter & Setters
=======
//	private List<Funcionario> funcionarios;
//	private List<Cliente> clientes;
	
	
	// A��es
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
	
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
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

<<<<<<< HEAD
=======


>>>>>>> 62756635758920db1db877917d32ecaf53a49188
}