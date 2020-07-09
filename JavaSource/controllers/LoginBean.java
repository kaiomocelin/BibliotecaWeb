package controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.ClienteDAO;
import models.Cliente;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO = new ClienteDAO();
	private Cliente cliente = new Cliente();

	public String envia() {
		cliente = clienteDAO.getCliente(cliente.getEmail(), cliente.getSenha());
		if (cliente == null) {
			cliente = new Cliente();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado ou senha incorreta!", "Erro no Login!"));
			return null;
		}else {
			return "Index.xhtml?faces-redirect=true";
		}
	}
	
	public String deslogar() {
		cliente = null;
		return "Login.jsf";
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
