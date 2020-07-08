package models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Emprestimo implements Serializable {

	public Emprestimo() {
		livro = new Livro();
		cliente = new Cliente();
		funcionario = new Funcionario();
	}

	private static final long serialVersionUID = 7219524593887351044L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emprestimo_seq_gen")
	@SequenceGenerator(name = "emprestimo_seq_gen", sequenceName = "emprestimo_id_seq")
	private int id;
	private LocalDate dataEmprestimo = LocalDate.now();
	private LocalDate dataDevolucao = dataEmprestimo.plusDays(7);

	@ManyToOne(cascade = CascadeType.MERGE)
	private Livro livro;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Funcionario funcionario;

	public boolean verificarStatus() {
		if (livro.getEmprestado() == true) {
			return true;
		} else {
			getLivro().setEmprestado(true);
			return false;
		}

	}

	public boolean devolverLivro() {
		if (livro.getEmprestado() == false) {
			return false;
		} else {
			getLivro().setEmprestado(false);
			return true;
		}
	}

	public boolean verificarPendencia() {
		if (cliente.getPendencia() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void gerarMulta() {
		if (getLivro().getEmprestado() == true && LocalDate.now().isEqual(dataEmprestimo)) {
			cliente.setMulta(1);
			cliente.setPendencia(true);
		}
	}
<<<<<<< HEAD
	
	public void adiarDevolucao() {
		dataDevolucao = dataDevolucao.plusDays(2);
	}
=======
>>>>>>> 01260eccaa5401f2bff7a8d1eb665da6c13f7e16

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + id;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id != other.id)
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		return true;
	}

}
