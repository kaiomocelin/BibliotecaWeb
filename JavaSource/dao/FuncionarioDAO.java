package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Funcionario;
import utils.JPAUtils;

public class FuncionarioDAO {
	public static void cadastrar(Funcionario funcionario) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
	}
	
	public static List<Funcionario> listar(){
		EntityManager em = JPAUtils.getInstance();
		List<Funcionario> funcionarios =
				em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
				return funcionarios;
	}
	
	public static boolean remover(Funcionario funcionario) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(funcionario));
		em.getTransaction().commit();
		return true;
	}
	
	public static void alterar(Funcionario funcionario) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
	}
	
	public static Funcionario buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Funcionario.class, id);
	}

}
