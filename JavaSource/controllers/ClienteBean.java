package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
<<<<<<< HEAD
import javax.faces.application.FacesMessage;
=======
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.ClienteDAO;
import models.Cliente;

@Named
@SessionScoped
<<<<<<< HEAD
public class ClienteBean implements Serializable {
=======
public class ClienteBean implements Serializable{
	
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16

	public ClienteBean() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
	}
<<<<<<< HEAD

	private static final long serialVersionUID = 3501885734852251418L;
	private Cliente cliente;
	private List<Cliente> clientes;

=======
	
	
	private static final long serialVersionUID = 3501885734852251418L;
	private Cliente cliente;
	private List<Cliente> clientes;
	
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
	public String cadastrar() {
		ClienteDAO.cadastrar(cliente);
		cliente = new Cliente();
		return "GerenciarClientes.xhtml?faces-redirect=true";
	}
<<<<<<< HEAD

	public String remover(Cliente cliente) {
		if (cliente.getPendencia() == false) {
			ClienteDAO.remover(cliente);
			return "GerenciarClientes.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este livro não foi emprestado!"));
			return null;
		}
	}

=======
	
	public void remover(Cliente cliente) {
		ClienteDAO.remover(cliente);
	}
	
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
	public String detalhar() {
		int idCliente = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCliente"));
		cliente = ClienteDAO.buscarPorId(idCliente);
		return "AlterarCliente.xhtml?faces-redirect=true";
	}
<<<<<<< HEAD

=======
	
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
	public String alterar() {
		ClienteDAO.alterar(cliente);
		cliente = new Cliente();
		return "GerenciarClientes.xhtml?faces-redirect=true";
	}

<<<<<<< HEAD
	public String pagarMulta(Cliente cliente) {
		cliente.setPendencia(false);
		cliente.setMulta(0);
		ClienteDAO.alterar(cliente);
		return null;

	}

=======
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		clientes = ClienteDAO.listar();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
<<<<<<< HEAD

=======
	
	
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
}
