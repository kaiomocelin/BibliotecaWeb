package dao;

import java.util.List;

import javax.persistence.EntityManager;

import models.Genero;
import utils.JPAUtils;

public class GeneroDAO {
	
	public static List<Genero> listar(){
		EntityManager em = JPAUtils.getInstance();
		List<Genero> generos =
				em.createQuery("SELECT g FROM Genero g", Genero.class).getResultList();
				return generos;
	}
	
	public static Genero buscarPorId(int id) {
		EntityManager em = JPAUtils.getInstance();
		return em.find(Genero.class, id);
	}
}
