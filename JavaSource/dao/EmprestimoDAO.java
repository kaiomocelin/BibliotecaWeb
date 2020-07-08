package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Emprestimo;
import utils.JPAUtils;

public class EmprestimoDAO {

	public static boolean cadastrarEmprestimo(Emprestimo emprestimo) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.merge(emprestimo);
		em.getTransaction().commit();
		return true;
	}

	public static List<Emprestimo> listar() {
		EntityManager em = JPAUtils.getInstance();
		return em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class).getResultList();
	}

	public static Emprestimo buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Emprestimo.class, id);
	}
	
	public static boolean devolverLivro(Emprestimo emprestimo) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(emprestimo));
		em.getTransaction().commit();
		return true;
	}
	
	public static boolean alterar(Emprestimo emprestimo) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.merge(emprestimo);
		em.getTransaction().commit();
		return true;
	}

}
