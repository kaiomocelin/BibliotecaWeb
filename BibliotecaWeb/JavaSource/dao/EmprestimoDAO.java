package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Emprestimo;
<<<<<<< HEAD
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

=======
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
	
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
	public static Emprestimo buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Emprestimo.class, id);
	}
	
<<<<<<< HEAD
	public static boolean devolverLivro(Emprestimo emprestimo) {
=======
	public static void devolverLivro(Emprestimo emprestimo) {
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(emprestimo));
		em.getTransaction().commit();
<<<<<<< HEAD
		return true;
	}

=======
	}
>>>>>>> 62756635758920db1db877917d32ecaf53a49188
}
