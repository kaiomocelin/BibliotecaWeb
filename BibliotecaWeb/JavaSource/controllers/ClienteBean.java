package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.ClienteDAO;
import models.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable{
	

	public ClienteBean() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
	}
	
	
	private static final long serialVersionUID = 3501885734852251418L;
	private Cliente cliente;
	private List<Cliente> clientes;
	
	public String cadastrar() {
		ClienteDAO.cadastrar(cliente);
		cliente = new Cliente();
		return "GerenciarClientes.xhtml?faces-redirect=true";
	}
	
	public void remover(Cliente cliente) {
		ClienteDAO.remover(cliente);
	}
	
	public String detalhar() {
		int idCliente = Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCliente"));
		cliente = ClienteDAO.buscarPorId(idCliente);
		return "AlterarCliente.xhtml?faces-redirect=true";
	}
	
	public String alterar() {
		ClienteDAO.alterar(cliente);
		cliente = new Cliente();
		return "GerenciarClientes.xhtml?faces-redirect=true";
	}

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
	
	
}
