package models;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@RequestScoped
public class Cliente implements Serializable{

	


	public Cliente() {
	}

	private static final long serialVersionUID = 5466992116885310170L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq_gen")
	@SequenceGenerator(name = "cliente_seq_gen", sequenceName = "cliente_id_seq")
	private int id;
	private String nome;
	private boolean pendencia;
<<<<<<< HEAD
	private double multa = 0;
=======
	private double multa;
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16
	private String telefone;
	private String email;

	
	
	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getPendencia() {
		return pendencia;
	}

	public void setPendencia(boolean pendencia) {
		this.pendencia = pendencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (pendencia ? 1231 : 1237);
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pendencia != other.pendencia)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
