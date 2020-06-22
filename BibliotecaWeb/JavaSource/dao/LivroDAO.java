package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Livro;
import utils.JPAUtils;

public class LivroDAO {
	public static void cadastrar(Livro livro) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
	}
	
	public static List<Livro> listar(){
		EntityManager em = JPAUtils.getInstance();
		List<Livro> livros =
				em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
				return livros;
	}
	
	public static void remover(Livro livro) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(livro));
		em.getTransaction().commit();
	}
	
	public static void alterar(Livro livro) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.merge(livro);
		em.getTransaction().commit();
	}
	
	public static Livro buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Livro.class, id);
	}

}
