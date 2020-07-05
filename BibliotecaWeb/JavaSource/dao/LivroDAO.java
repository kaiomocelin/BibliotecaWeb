package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import models.Livro;
import utils.JPAUtils;

public class LivroDAO {

	public static boolean cadastrar(Livro livro) {
		if (buscarPorTitulo(livro.getTitulo()) == null) {
			EntityManager em = JPAUtils.getInstance();
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public static Livro buscarPorTitulo(String titulo) {
		EntityManager em = JPAUtils.getInstance();
		TypedQuery<Livro> livro = em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo", Livro.class);
		livro.setParameter("titulo", titulo);

		try {
			return livro.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public static List<Livro> listar() {
		EntityManager em = JPAUtils.getInstance();
		List<Livro> livros = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
		return livros;
	}

	public static boolean remover(Livro livro) {
		EntityManager em = JPAUtils.getInstance();
		em.getTransaction().begin();
		em.remove(em.merge(livro));
		em.getTransaction().commit();
		return true;
	}

	public static boolean alterar(Livro livro) {
		if (buscarPorTitulo(livro.getTitulo()) == null) {
			EntityManager em = JPAUtils.getInstance();
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public static Livro buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Livro.class, id);
	}
		
}

