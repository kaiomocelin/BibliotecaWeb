package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.EmprestimoDAO;
import models.Cliente;
import models.Emprestimo;
import models.Funcionario;
import models.Livro;

@Named
@SessionScoped
public class EmprestimoBean implements Serializable {

	// Construtor
	public EmprestimoBean() {
		emprestimo = new Emprestimo();
		emprestimos = new ArrayList<Emprestimo>();
		livros = new ArrayList<Livro>();
		clientes = new ArrayList<Cliente>();
		funcionarios = new ArrayList<Funcionario>();
	}

	// Atributos
	private static final long serialVersionUID = 1728576448215873831L;
	private Emprestimo emprestimo;
	private List<Emprestimo> emprestimos;
	private List<Livro> livros;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;

	// Ações
	public String cadastrarEmprestimo() {
		if (emprestimo.verificarPendencia() == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este cliente tem pendencias!"));
			return null;
		} else {
			if (emprestimo.verificarStatus() == true) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro já foi emprestado!"));
				return null;
			} else {
				if (EmprestimoDAO.cadastrarEmprestimo(emprestimo)) {
					return "Index.xhtml?faces-redirect=true";
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro está ocupado!"));
					return null;
				}
			}
		}
	}

	public String devolverLivro(Emprestimo emprestimo) {
<<<<<<< HEAD
		emprestimo.gerarMulta();
=======

>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
		if (emprestimo.devolverLivro() == false) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro não foi emprestado!"));
			return null;
		} else {
			if (EmprestimoDAO.devolverLivro(emprestimo)) {
				return "GerenciarEmprestimos.xhtml?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro não foi emprestado!"));
				return null;
			}
		}

	}
<<<<<<< HEAD
	
	public String adiarDevolucao(Emprestimo emprestimo) {
		emprestimo.adiarDevolucao();
		if(EmprestimoDAO.alterar(emprestimo)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Data adiada com sucesso!"));
			return "GerenciarEmprestimos.xhtml?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não é possivel adiar a data!"));
			return null;
		}
		
		
	}
=======
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16

	// Getter & Setters
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