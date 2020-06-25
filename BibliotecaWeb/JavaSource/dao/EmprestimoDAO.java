package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Emprestimo;
import models.Livro;
import utils.JPAUtils;

public class EmprestimoDAO {
	
		public static void cadastrarEmprestimo(Emprestimo emprestimo) {
			EntityManager em = JPAUtils.getInstance();
			em.getTransaction().begin();
			em.persist(emprestimo);
			em.getTransaction().commit();
		}
	
	public static List<Emprestimo> listar(){
		EntityManager em = JPAUtils.getInstance();
		List<Emprestimo> emprestimos =
				em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class).getResultList();
				return emprestimos;
	}
	
	public static Emprestimo buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Emprestimo.class, id);
	}
	
	public static void devolverLivro(Emprestimo emprestimo) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(emprestimo));
		em.getTransaction().commit();
	}
}
