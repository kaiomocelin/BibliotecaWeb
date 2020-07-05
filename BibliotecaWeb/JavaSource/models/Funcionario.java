package models;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 62756635758920db1db877917d32ecaf53a49188

import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.SequenceGenerator;
=======
import javax.persistence.OneToMany;
>>>>>>> 62756635758920db1db877917d32ecaf53a49188

@Entity
@RequestScoped
public class Funcionario implements Serializable{	

	
	public Funcionario() {
	}
	
	private static final long serialVersionUID = 8226313799339113292L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq_gen")
	@SequenceGenerator(name = "funcionario_seq_gen", sequenceName = "funcionario_id_seq")
	private int id;
	private String nome;
	
//	@OneToMany(mappedBy="funcionario")
//    private List<Emprestimo> emprestimos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
