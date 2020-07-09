package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.FuncionarioDAO;
import models.Funcionario;

@Named
@SessionScoped
public class FuncionarioBean implements Serializable{
	

	public FuncionarioBean() {
		funcionario = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
	}
	
	
	private static final long serialVersionUID = 3501885734852251418L;
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	
	public String cadastrar() {
		FuncionarioDAO.cadastrar(funcionario);
		funcionario = new Funcionario();
		return "Index.xhtml?faces-redirect=true";
	}
	
	public String remover(Funcionario funcionario) {
		if(FuncionarioDAO.remover(funcionario)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Funcionario removido com sucesso!"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este funcionario não pode ser removido!"));
			return null;
		}
		
	}
	
	public String detalhar() {
		int idFuncionario = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFuncionario"));
		funcionario = FuncionarioDAO.buscarPorId(idFuncionario);
		return "AlterarFuncionario.xhtml?faces-redirect=true";
	}
	
	public String alterar() {
		FuncionarioDAO.alterar(funcionario);
		funcionario = new Funcionario();
		return "GerenciarFuncionarios.xhtml?faces-redirect=true";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		funcionarios = FuncionarioDAO.listar();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
